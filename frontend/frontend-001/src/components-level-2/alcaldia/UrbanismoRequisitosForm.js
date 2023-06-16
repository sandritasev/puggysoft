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
} from "../../validations/alcaldia/HandleUrbanismoRequisitosFormValidations";
import CommonMessage from "../../components-level-1/CommonMessage";

import "./../css/all-forms.css";

function UrbanismoRequisitosForm () {
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
          "urbanismo-requisitos/",
          body,
          id,
          handleAfterEdit
        );
      } else {
        handleAddRequest(
          "urbanismo-requisitos/",
          body,
          handleAfterAdd
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
          {i18n.urbanismoRequisitosForm.title}
        </Card.Header>
        <Card.Body>
          <Form>
            <Form.Group className="mb-3" controlId="nombre">
              <Form.Label>
                {i18n.urbanismoRequisitosForm.fieldNombre}
              </Form.Label>
              <Form.Control
                onChange={onChangeNombre}
                value={valueNombre}
                type="text"
                placeholder={i18n.urbanismoRequisitosForm.fieldNombre}
              />
              <Form.Text muted className={classNameFormText.nombre}>
                {i18n.urbanismoRequisitosForm.fieldNombreText}
              </Form.Text>
            </Form.Group>
            <Form.Group className="mb-3" controlId="nombreCorto">
              <Form.Label>
                {i18n.urbanismoRequisitosForm.fieldNombreCorto}
              </Form.Label>
              <Form.Control
                onChange={onChangeNombreCorto}
                value={valueNombreCorto}
                type="text"
                placeholder={i18n.urbanismoRequisitosForm.fieldNombreCorto}
              />
              <Form.Text muted className={classNameFormText.nombreCorto}>
                {i18n.urbanismoRequisitosForm.fieldNombreCortoText}
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

export default UrbanismoRequisitosForm;
