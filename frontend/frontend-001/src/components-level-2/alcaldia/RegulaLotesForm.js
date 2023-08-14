import React, { useEffect, useState, useCallback } from "react";
import { useHistory } from "react-router";

import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import CommonLoading from "../../components-level-1/CommonLoading";
import i18n from "../../i18n/i18n";
import useInput from "../../hooks/useInput";
import {
  handleAddRequest,
  handleEditRequest
} from "../../actions/HandleManager";
import {
  handleValidation,
  classNameFormTextNew
} from "../../validations/alcaldia/HandleRegulaLotesFormValidations";
import CommonMessage from "../../components-level-1/CommonMessage";
import pdfBuilderComprobantePagoLotes from "./../../tools/alcaldia/pdfBuilderComprobantePagoLotes";

import "./../css/all-forms.css";

function RegulaLotesForm () {
  const history = useHistory();
  const isEditDefaultValue =
    history && history.location && history.location.state;
  const [isEdit, setIsEdit] = useState(isEditDefaultValue);
  const [classNameFormText, setClassNameFormText] =
    useState(classNameFormTextNew);
  const [isRequestInProgress, setIsRequestInProgress] = useState(false);
  // Message states
  const [isMessageVisible, setIsMessageVisible] = useState(false);
  const [messageTitle, setMessageTitle] = useState("");
  const [messageText, setMessageText] = useState("");

  // CONFIGURE IMAGE
  const archivo =
    isEdit &&
      isEdit.data &&
      isEdit.data.boletaPago &&
      isEdit.data.boletaPago !== null
      ? isEdit.data.boletaPago
      : null;

  // Put default values:
  const id = isEdit && isEdit.data.id !== null ? isEdit.data.id : "";
  const nombreCliente = isEdit && isEdit.data.nombreCliente !== null ? isEdit.data.nombreCliente : "";
  const ciCliente =
    isEdit && isEdit.data.ciCliente !== null ? isEdit.data.ciCliente : "";
  const monto =
    isEdit && isEdit.data.monto !== null ? isEdit.data.monto : "";

  // Use custom hook
  const {
    value: valueNombreCliente,
    onChange: onChangeNombreCliente,
    reset: resetNombreCliente
  } = useInput(nombreCliente);
  const {
    value: valueCiCliente,
    onChange: onChangeCiCliente,
    reset: resetCiCliente
  } = useInput(ciCliente);
  const {
    value: valueMonto,
    onChange: onChangeMonto,
    reset: resetMonto
  } = useInput(monto);

  const handleReset = () => {
    resetNombreCliente();
    resetCiCliente();
    resetMonto();
  };

  const getBody = useCallback(
    function () {
      const username = window.sessionStorage.getItem("username");
      const tenant = window.sessionStorage.getItem("tenant");
      const body = {
        nombreCliente: valueNombreCliente,
        ciCliente: valueCiCliente,
        monto: valueMonto,
        tenant,
        createdBy: username,
        updatedBy: username
      };
      if (archivo !== null) {
        body.image = archivo;
      }
      return body;
    },
    [valueNombreCliente, valueCiCliente, valueMonto]
  );

  const handleAfterAdd = function (newRegulaLotesId) {
    const createdBy = window.sessionStorage.getItem("username");
    pdfBuilderComprobantePagoLotes({
      id: newRegulaLotesId,
      client: valueCiCliente,
      createdBy
    }, valueMonto);
    handleReset();
    const body = getBody();
    handleValidation(body, setClassNameFormText);
    setIsRequestInProgress(false);
  };

  const handleAfterEdit = function () {
    handleReset();
    setIsEdit(undefined);
    const body = getBody();
    handleValidation(body, setClassNameFormText);
    setIsRequestInProgress(false);
  };

  const handleAdd = (event) => {
    event.preventDefault();
    const body = getBody();
    const isValid = handleValidation(body, setClassNameFormText);
    if (isValid) {
      setIsRequestInProgress(true);
      if (isEdit) {
        handleEditRequest(
          "regula-lotes/",
          body,
          id,
          handleAfterEdit
        );
      } else {
        handleAddRequest(
          "regula-lotes/",
          body,
          handleAfterAdd,
          false
        );
      }
    } else {
      setMessageTitle(i18n.errorMessages.validationErrorTitle);
      setMessageText(i18n.errorMessages.validationError);
      setIsMessageVisible(true);
    }
  };

  useEffect(() => {
    const body = getBody();
    handleValidation(body, setClassNameFormText);
  }, [getBody]);

  if (isRequestInProgress) {
    return <CommonLoading></CommonLoading>;
  }

  return (
    <div className="puggysoft-form-thirty-with">
      <CommonMessage
        isVisible={isMessageVisible}
        setIsVisible={setIsMessageVisible}
        titleText={messageTitle}
        bodyText={messageText}
        variant="danger"
      />
      <Card>
        <Card.Header as="h3">
          {i18n.regulaLotesForm.title}
        </Card.Header>
        <Card.Body>
          <Form>
            <Form.Group className="mb-3" controlId="nombreCliente">
              <Form.Label>
                {i18n.regulaLotesForm.fieldNombreCliente}
              </Form.Label>
              <Form.Control
                onChange={onChangeNombreCliente}
                value={valueNombreCliente}
                type="text"
                placeholder={i18n.regulaLotesForm.fieldNombreCliente}
              />
              <Form.Text muted className={classNameFormText.nombreCliente}>
                {i18n.regulaLotesForm.fieldNombreClienteText}
              </Form.Text>
            </Form.Group>
            <Form.Group className="mb-3" controlId="ciCliente">
              <Form.Label>
                {i18n.regulaLotesForm.fieldCiCliente}
              </Form.Label>
              <Form.Control
                onChange={onChangeCiCliente}
                value={valueCiCliente}
                type="text"
                placeholder={i18n.regulaLotesForm.fieldCiCliente}
              />
              <Form.Text muted className={classNameFormText.ciCliente}>
                {i18n.regulaLotesForm.fieldCiClienteText}
              </Form.Text>
            </Form.Group>
            <Form.Group className="mb-3" controlId="monto">
              <Form.Label>
                {i18n.regulaLotesForm.fieldMonto}
              </Form.Label>
              <Form.Control
                onChange={onChangeMonto}
                value={valueMonto}
                type="text"
                placeholder={i18n.regulaLotesForm.fieldMonto}
              />
              <Form.Text muted className={classNameFormText.monto}>
                {i18n.regulaLotesForm.fieldMontoText}
              </Form.Text>
            </Form.Group>
            <Button onClick={handleAdd} variant="primary" type="button">
              {i18n.commonForm.saveButton}
            </Button>
          </Form>
        </Card.Body>
      </Card>
    </div>
  );
}

export default RegulaLotesForm;
