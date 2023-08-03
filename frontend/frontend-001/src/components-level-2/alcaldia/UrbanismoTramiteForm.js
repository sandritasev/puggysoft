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
} from "../../validations/alcaldia/HandleUrbanismoTramiteFormValidations";
import CommonMessage from "../../components-level-1/CommonMessage";

import "./../css/all-forms.css";

function UrbanismoTramiteForm () {
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
  const [messageVariant, setMessageVariant] = useState("danger");

  // Put default values:
  const id = isEdit && isEdit.data.id !== null ? isEdit.data.id : "";
  const nombre = isEdit && isEdit.data.nombre !== null ? isEdit.data.nombre : "";
  const nombreCorto =
    isEdit && isEdit.data.nombreCorto !== null ? isEdit.data.nombreCorto : "";

  // Use custom hook
  const {
    value: valueNombre,
    onChange: onChangeNombre,
    reset: resetNombre
  } = useInput(nombre);
  const {
    value: valueNombreCorto,
    onChange: onChangeNombreCorto,
    reset: resetNombreCorto
  } = useInput(nombreCorto);

  const handleReset = () => {
    resetNombre();
    resetNombreCorto();
  };

  const getBody = useCallback(
    function () {
      const username = window.sessionStorage.getItem("username");
      const tenant = window.sessionStorage.getItem("tenant");
      const body = {
        nombre: valueNombre,
        nombreCorto: valueNombreCorto,
        tenant,
        createdBy: username,
        updatedBy: username
      };
      return body;
    },
    [valueNombre, valueNombreCorto]
  );

  const handleAfterAdd = function (newEntityId) {
    handleReset();
    const body = getBody();
    handleValidation(body, setClassNameFormText);
    setIsRequestInProgress(false);
    setMessageVariant("success");
    setMessageTitle(i18n.successMessages.successTitle);
    setMessageText(i18n.successMessages.successfullyCreated);
    setIsMessageVisible(true);
  };

  const handleAfterEdit = function () {
    handleReset();
    setIsEdit(undefined);
    const body = getBody();
    handleValidation(body, setClassNameFormText);
    setIsRequestInProgress(false);
    setMessageVariant("warning");
    setMessageTitle(i18n.successMessages.successTitle);
    setMessageText(i18n.successMessages.successfullyEdited);
    setIsMessageVisible(true);
  };

  const handleRequestFailed = function (response, errorMessage) {
    setIsRequestInProgress(false);
    setMessageVariant("danger");
    setMessageTitle(i18n.errorMessages.errorTitle);
    setMessageText(errorMessage);
    setIsMessageVisible(true);
  };

  const handleAdd = (event) => {
    event.preventDefault();
    const body = getBody();
    const isValid = handleValidation(body, setClassNameFormText);
    if (isValid) {
      setIsRequestInProgress(true);
      if (isEdit) {
        handleEditRequest(
          "urbanismo-tramite/",
          body,
          id,
          handleAfterEdit,
          handleRequestFailed,
          false
        );
      } else {
        handleAddRequest(
          "urbanismo-tramite/",
          body,
          handleAfterAdd,
          false,
          handleRequestFailed
        );
      }
    } else {
      setMessageVariant("danger");
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
        variant={messageVariant}
      />
      <Card>
        <Card.Header as="h3">
          {i18n.urbanismoTramiteForm.title}
        </Card.Header>
        <Card.Body>
          <Form>
            <Form.Group className="mb-3" controlId="nombre">
              <Form.Label>
                {i18n.urbanismoTramiteForm.fieldNombre}
              </Form.Label>
              <Form.Control
                onChange={onChangeNombre}
                value={valueNombre}
                type="text"
                placeholder={i18n.urbanismoTramiteForm.fieldNombre}
              />
              <Form.Text muted className={classNameFormText.nombre}>
                {i18n.urbanismoTramiteForm.fieldNombreText}
              </Form.Text>
            </Form.Group>
            <Form.Group className="mb-3" controlId="nombreCorto">
              <Form.Label>
                {i18n.urbanismoTramiteForm.fieldNombreCorto}
              </Form.Label>
              <Form.Control
                onChange={onChangeNombreCorto}
                value={valueNombreCorto}
                type="text"
                placeholder={i18n.urbanismoTramiteForm.fieldNombreCorto}
                disabled={!!isEdit}
              />
              <Form.Text muted className={classNameFormText.nombreCorto}>
                {i18n.urbanismoTramiteForm.fieldNombreCortoText}
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

export default UrbanismoTramiteForm;
