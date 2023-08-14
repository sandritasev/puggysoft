import React, { useEffect, useState, useCallback } from "react";
import { useHistory } from "react-router";

import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import CommonLoading from "../../components-level-1/CommonLoading";
import i18n from "../../i18n/i18n";
import useInput from "../../hooks/useInput";
import enumVentaStatus from "./../../models/alcaldia/enumVentaStatus";
import GeneratePdf from "../../tools/alcaldia/pdfBuilderComprobante";
import enumCompareOperators from "../../models/enumCompareOperators";
import {
  handleEditRequest,
  handleAddRequest,
  handleFilterRequest
} from "../../actions/HandleManager";
import {
  handleValidation,
  classNameFormTextNew
} from "../../validations/alcaldia/HandleAlcaldiaRecursosMunicipalesTimbresVentasFormValidations";
import CommonMessage from "../../components-level-1/CommonMessage";

import "./../css/all-forms.css";
import "./../css/all-two-divs-side-by-side.css";
import "./../css/all-five-divs-side-by-side.css";
import "./../css/button-inline.css";

function AlcaldiaRecursosMunicipalesTimbresVentasForm () {
  const history = useHistory();
  const isEditDefaultValue =
    history && history.location && history.location.state;
  const [isEdit] = useState(isEditDefaultValue);
  const [classNameFormText, setClassNameFormText] =
    useState(classNameFormTextNew);
  const [isRequestInProgress, setIsRequestInProgress] = useState(false);
  // Message states
  const [isBlock, setIsBlock] = useState(false);
  const [isEmpy, setIsEmpy] = useState(false);
  const [isMessageVisible, setIsMessageVisible] = useState(false);
  const [messageTitle, setMessageTitle] = useState("");
  const [messageText, setMessageText] = useState("");

  // Put default values:
  const venta = isEdit && isEdit.data.id !== null ? isEdit.data.id : "";
  const clienteNombre = isEdit && isEdit.data.clienteNombre !== null ? isEdit.data.clienteNombre : "";
  const clienteCiNit = isEdit && isEdit.data.clienteCiNit !== null ? isEdit.data.clienteCiNit : "";
  const direccion = isEdit && isEdit.data.direccion !== null ? isEdit.data.direccion : "";
  const nota = isEdit && isEdit.data.nota !== null ? isEdit.data.nota : "";
  const ventaPrecioTotal = isEdit && isEdit.data.ventaPrecioTotal !== null ? isEdit.data.ventaPrecioTotal : 0;
  const clienteDinero = isEdit && isEdit.data.clienteDinero !== null ? isEdit.data.clienteDinero : "";
  const clienteCambio = isEdit && isEdit.data.clienteCambio !== null ? isEdit.data.clienteCambio : 0;

  const [valueTimbres, setValueTimbres] = useState({ talonarioMovimiento: 0, precio: 0, talonarioFinal: 0 });
  const [valueHastaTimbre, setValueHastaTimbre] = useState({ talonarioMovimiento: "" });
  // eslint-disable-next-line no-unused-vars
  const [valueVentaPrecioTotal, setValueVentaPrecioTotal] = useState(ventaPrecioTotal);
  const [idVenta, setIdVenta] = useState(venta);
  const [valueClienteCambio, setValueClienteCambio] = useState(clienteCambio);
  // Use custom hook
  const { value: valueClienteNombre, onChange: onChangeClienteNombre } = useInput(clienteNombre);
  const { value: valueClienteCiNit, onChange: onChangeClienteCiNit } = useInput(clienteCiNit);
  const { value: valueDireccion, onChange: onChangeDireccion } = useInput(direccion);
  const { value: valueCantidad, onChange: onChangeCantidad } = useInput(nota);
  const { value: valueClienteDinero, onChange: onChangeClienteDinero } = useInput(clienteDinero);

  const tenant = window.sessionStorage.getItem("tenant");
  const filterBody = {
    nameCriteria: i18n.alcaldiaRecursosMunicipalesTimbresForm.defaultTimbre,
    nameOperator: enumCompareOperators.TEXT_EQUALS,
    tenantCriteria: tenant,
    tenantOperator: enumCompareOperators.TEXT_EQUALS
  };

  const afterGetTimbres = data => {
    if (data.length !== 0) {
      setValueTimbres(data[0]);
    } else {
      setIsEmpy(true);
    }
  };

  if (valueTimbres?.talonarioMovimiento === 0) {
    handleFilterRequest("alcaldia-recursos-municipales-timbres-ventas", filterBody, afterGetTimbres);
  }

  const getBody = useCallback(
    function () {
      const username = window.sessionStorage.getItem("username");
      const tenant = window.sessionStorage.getItem("tenant");
      const nota = i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.fieldTalonarioActual +
        `  ${valueTimbres.talonarioMovimiento}, ` +
        i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.fieldTalonarioVenta +
        `  ${valueHastaTimbre}, `;
      const body = [
        {
          clienteNombre: valueClienteNombre,
          clienteCiNit: valueClienteCiNit,
          direccion: valueDireccion,
          clienteDinero: valueClienteDinero,
          nota,
          ventaStatus: enumVentaStatus.ACTIVO,
          ventaPrecioTotal: valueVentaPrecioTotal,
          clienteCambio: valueClienteCambio,
          tenant,
          createdBy: username,
          updatedBy: username
        },
        {
          idRecursoMunicipal: valueTimbres.id,
          precioUnidad: valueTimbres.precio,
          tenant,
          cantidad: valueCantidad,
          createdBy: username,
          updatedBy: username
        },
        {
          ...valueTimbres,
          talonarioMovimiento: valueHastaTimbre
        }
      ];
      return body;
    },
    [valueClienteNombre, valueClienteCiNit, valueDireccion, valueClienteDinero, valueClienteCambio, valueVentaPrecioTotal, valueCantidad]
  );

  function afterAddTimbreToSaleOnFail () {
    console.error("error in add producto to sale");
  }
  const handleAfterAdd = function (newEntityId) {
    const body = getBody();
    handleAddRequest("alcaldia-recursos-municipales-ventas-detalle/", { ...body[1], idVenta: newEntityId }, () => {}, false, afterAddTimbreToSaleOnFail);
    handleEditRequest("alcaldia-recursos-municipales/", body[2], body[2].id, () => {});
    setIsBlock(true);
    setIdVenta(newEntityId);
    setIsRequestInProgress(false);
  };

  const handleAdd = (event) => {
    event?.preventDefault();
    const body = getBody();
    const isValid = handleValidation(body, setClassNameFormText);
    if (isValid) {
      setIsRequestInProgress(true);
      handleAddRequest("alcaldia-recursos-municipales-ventas/", body[0], handleAfterAdd);
    } else {
      setMessageTitle(i18n.errorMessages.validationErrorTitle);
      setMessageText(i18n.errorMessages.validationError);
    }
  };

  const afterDataComprobante = data => {
    const body = getBody();
    GeneratePdf(data, body);
    setIsRequestInProgress(false);
  };

  const handleComprobante = function () {
    setIsRequestInProgress(true);
    const tenant = window.sessionStorage.getItem("tenant");
    const filterBody = {
      tenantCriteria: tenant,
      tenantOperator: enumCompareOperators.TEXT_EQUALS
    };
    handleFilterRequest(`alcaldia/filter-by-ventas-id?ventasId=${idVenta}`, filterBody, afterDataComprobante);
  };

  useEffect(() => {
    const body = getBody();
    handleValidation(body, setClassNameFormText);
  }, [getBody]);

  useEffect(() => {
    setValueHastaTimbre(Number(valueCantidad) + Number(valueTimbres.talonarioMovimiento));
    setValueVentaPrecioTotal(Number(valueCantidad) * Number(valueTimbres.precio));
  }, [valueCantidad]);

  useEffect(() => {
    setValueClienteCambio(Number(valueClienteDinero) - Number(valueVentaPrecioTotal));
  }, [valueVentaPrecioTotal, valueClienteDinero]);

  if (isRequestInProgress) {
    return <CommonLoading></CommonLoading>;
  }
  if (isEmpy) {
    return <Card.Header as="h2">{i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.empyTimbres}</Card.Header>;
  }

  return (
    <div className="">
      <CommonMessage
        isVisible={isMessageVisible}
        setIsVisible={setIsMessageVisible}
        titleText={messageTitle}
        bodyText={messageText}
        variant="danger"
      />
      <Card>
        <Card.Header as="h3">
          {i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.title}
        </Card.Header>
        { !isBlock && <Card.Header as="h5">
          {i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.subTitle + valueTimbres?.talonarioFinal}
        </Card.Header>}
        <Card.Header as="h5">
          {!isBlock && i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.subTitleTwo + valueTimbres?.precio}
          { isBlock &&
          <Button
            style={{ width: "auto", margin: "0px 15px" }}
            onClick={handleComprobante}
            variant="success"
            type="button"
            className="puggysoft-button-inline"
          >
            {i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.buttonComprobante}
          </Button>}
        </Card.Header>
        <Card.Body>
          <div className="puggysoft-five-divs-side-by-side-child-container">
            <div className="puggysoft-five-divs-side-by-side-child">
              <Form.Group className="mb-3" controlId="clienteNombre">
                <Form.Label>
                  {i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.fieldClienteNombre}
                </Form.Label>
                <Form.Control
                  disabled={isBlock}
                  onChange={onChangeClienteNombre}
                  value={valueClienteNombre}
                  type="text"
                  placeholder={i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.fieldClienteNombre}
                />
                <Form.Text muted className={classNameFormText.clienteNombre}>
                  {i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.fieldClienteNombreText}
                </Form.Text>
              </Form.Group>
            </div>
            <div className="puggysoft-five-divs-side-by-side-child">
              <Form.Group className="mb-3" controlId="clienteCiNit">
                <Form.Label>
                  {i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.fieldClienteCiNit}
                </Form.Label>
                <Form.Control
                  disabled={isBlock}
                  onChange={onChangeClienteCiNit}
                  value={valueClienteCiNit}
                  type="number"
                  placeholder={i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.fieldClienteCiNit}
                />
                <Form.Text muted className={classNameFormText.clienteCiNit}>
                  {i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.fieldClienteCiNitText}
                </Form.Text>
              </Form.Group>
            </div>
            <div className="puggysoft-five-divs-side-by-side-child">
              <Form.Group className="mb-3" controlId="direccion">
                <Form.Label>
                  {i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.fieldDireccion}
                </Form.Label>
                <Form.Control
                  disabled={isBlock}
                  onChange={onChangeDireccion}
                  value={valueDireccion}
                  placeholder={i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.fieldDireccion}
                />
                <Form.Text muted className={classNameFormText.direccion}>
                  {i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.fieldDireccionText}
                </Form.Text>
              </Form.Group>
            </div>
            <div className="puggysoft-five-divs-side-by-side-child">
              <Form.Group className="mb-3" controlId="talonarioActual">
                <Form.Label>
                  {i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.fieldTalonarioActual}
                </Form.Label>
                <Form.Control
                  disabled
                  style={{ resize: "none" }}
                  value={valueTimbres?.talonarioMovimiento}
                />
              </Form.Group>
            </div>
            <div className="puggysoft-five-divs-side-by-side-child">
              <Form.Group className="mb-3" controlId="cantidad">
                <Form.Label>
                  {i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.fieldCantidad}
                </Form.Label>
                <Form.Control
                  disabled={isBlock}
                  style={{ resize: "none" }}
                  value={valueCantidad}
                  onChange={onChangeCantidad}
                  placeholder={i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.fieldCantidad}
                />
                <Form.Text muted className={classNameFormText.cantidad}>
                  {i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.fieldCantidadText}
                </Form.Text>
              </Form.Group>
            </div>
            <div className="puggysoft-five-divs-side-by-side-child">
              <Form.Group className="mb-3" controlId="talonarioVenta">
                <Form.Label>
                  {i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.fieldTalonarioVenta}
                </Form.Label>
                <Form.Control
                  disabled
                  style={{ resize: "none" }}
                  value={valueHastaTimbre}
                />
              </Form.Group>
            </div>
            <div className="puggysoft-five-divs-side-by-side-child">
              <Form.Group className="mb-3" controlId="ventaPrecioTotal">
                <Form.Label>
                  {i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.fieldVentaPrecioTotal}
                </Form.Label>
                <Form.Control
                  disabled
                  value={valueVentaPrecioTotal}
                  type="text"
                />
              </Form.Group>
            </div>
            <div className="puggysoft-five-divs-side-by-side-child">
              <Form.Group className="mb-3" controlId="clienteDinero">
                <Form.Label>
                  {i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.fieldClienteDinero}
                </Form.Label>
                <Form.Control
                  disabled={isBlock}
                  onChange={onChangeClienteDinero}
                  value={valueClienteDinero}
                  placeholder={i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.fieldClienteDinero}
                />
                <Form.Text muted className={classNameFormText.clienteDinero}>
                  {i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.fieldClienteDineroText}
                </Form.Text>
              </Form.Group>
            </div>
            <div className="puggysoft-five-divs-side-by-side-child">
              <Form.Group className="mb-3" controlId="clienteCambio">
                <Form.Label>
                  {i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.fieldClienteCambio}
                </Form.Label>
                <Form.Control
                  value={valueClienteCambio}
                  type="number"
                  disabled
                  placeholder={i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.fieldClienteCambio}
                />
                <Form.Text muted className={classNameFormText.clienteCambio}>
                  {i18n.alcaldiaRecursosMunicipalesTimbresVentasForm.fieldClienteCambioText}
                </Form.Text>
              </Form.Group>
            </div>
            <div className="puggysoft-five-divs-side-by-side-child">
              <Button
                onClick={handleAdd}
                variant="primary"
                type="button"
                className="puggysoft-button-inline"
              >
                {i18n.commonForm.saveButton}
              </Button>
            </div>
            <div className="puggysoft-five-divs-side-by-side-child"></div>
          </div>
        </Card.Body>
      </Card>
    </div>
  );
}

export default AlcaldiaRecursosMunicipalesTimbresVentasForm;
