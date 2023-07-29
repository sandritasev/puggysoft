import React, { useEffect, useState } from "react";
import { useHistory } from "react-router";

import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import Alert from "react-bootstrap/Alert";
import i18n from "../../i18n/i18n";
import useInput from "../../hooks/useInput";
import { handleAddRequest, handleEditRequest, handleAddFileRequest } from "../../actions/HandleManager";
import { handleValidation, classNameFormTextNew } from "../../validations/system/HandleTenantFormValidations";
import appUrlConfig from "../../tools/appUrlConfig";
import CommonLoading from "../../components-level-1/CommonLoading";
import CommonMessage from "../../components-level-1/CommonMessage";
import enumStatus from "../../models/system/enumStatus";

import "./../css/all-forms.css";
import "./tenant-form-styles.css";

function TenantForm () {
  const history = useHistory();
  const isEditDefaultValue = history && history.location && history.location.state;
  const [isEdit, setIsEdit] = useState(isEditDefaultValue);
  const [classNameFormText, setClassNameFormText] = useState(classNameFormTextNew);
  const title = isEdit ? i18n.tenantForm.titleEdit : i18n.tenantForm.title;
  const [isRequestInProgress, setIsRequestInProgress] = useState(false);
  const [isMessageVisible, setIsMessageVisible] = useState(false);
  const [messageTitle, setMessageTitle] = useState("");
  const [messageText, setMessageText] = useState("");
  // Put default values:
  const id = isEdit && isEdit.data.id !== null ? isEdit.data.id : "";
  const name = isEdit && isEdit.data.name !== null ? isEdit.data.name : "";
  const shortName = isEdit && isEdit.data.shortName !== null ? isEdit.data.shortName : "";

  const status = isEdit?.data?.status === i18n.tenantStatusText.active
    ? enumStatus.ACTIVE
    : isEdit?.data?.status === i18n.tenantStatusText.inactive ? enumStatus.INACTIVE : enumStatus.ACTIVE;

  const description = isEdit && isEdit.data.description !== null ? isEdit.data.description : "";
  const telephone = isEdit && isEdit.data.telephone !== null ? isEdit.data.telephone : "";
  const address = isEdit && isEdit.data.address !== null ? isEdit.data.address : "";

  // CONFIGURE IMAGE
  const fileName = "tenant-default.jpg";
  const imageUrlInit = `${appUrlConfig.PROTOCOL}//${appUrlConfig.HOSTNAME}:${appUrlConfig.PORT}/${fileName}`;
  let imageUrlInitAux = imageUrlInit;
  const tenantImage =
    isEdit &&
      isEdit.data &&
      isEdit.data.image &&
      isEdit.data.image !== null
      ? isEdit.data.image
      : null;
  if (tenantImage && tenantImage !== null) {
    if (tenantImage.includes("blob:")) {
      imageUrlInitAux = tenantImage;
    } else {
      imageUrlInitAux = `data:image/jpeg;base64, ${tenantImage}`;
    }
  }
  const { value: valuePictureToShow, setValue: setValuePictureToShow } = useInput(imageUrlInitAux);

  // Use custom hook
  const { value: valueName, onChange: onChangeName, setValue: setName } = useInput(name);
  const { value: valueShortName, onChange: onChangeShortName, setValue: setShortName } = useInput(shortName);
  const { value: valueStatus, onChange: onChangeStatus, setValue: setStatus } = useInput(status);
  const { value: valueDescription, onChange: onChangeDescription, setValue: setDescription } = useInput(description);
  const { value: valueTelephone, onChange: onChangeTelephone, setValue: setTelephone } = useInput(telephone);
  const { value: valueAddress, onChange: onChangeAddress, setValue: setAddress } = useInput(address);
  const { value: valuePicture, setValue: setPicture } = useInput(null);
  const { value: valuePicturePath, onChange: onChangePicturePath, setValue: setPicturePath } = useInput("");

  const handleReset = () => {
    setName("");
    setShortName("");
    setStatus("");
    setDescription("");
    setTelephone("");
    setAddress("");
    setPicture(null);
    setPicturePath("");
    setValuePictureToShow(imageUrlInit);
  };

  const handleAfterAdd = function (newTenantId) {
    handleAddImage(newTenantId);
    handleReset();
  };

  const handleAddImage = (tenantId) => {
    // const pictureFile = { ...valuePicture }
    if (valuePicture !== null) {
      handleAddFileRequest("tenants/picture/", valuePicture, tenantId, finishLoading, false, finishLoading);
    } else {
      finishLoading();
    }
  };

  const handleAfterEdit = function () {
    handleAddImage(id);
    handleReset();
    setIsEdit(undefined);
  };

  const getBody = function () {
    const username = window.sessionStorage.getItem("username");
    const body = {
      name: valueName,
      shortName: valueShortName,
      status: valueStatus,
      description: valueDescription,
      telephone: valueTelephone,
      address: valueAddress,
      createdBy: username,
      updatedBy: username,
      image: null
    };
    if (tenantImage !== null) {
      body.image = tenantImage;
    }
    return body;
  };

  const handleAdd = (event) => {
    event.preventDefault();
    const body = getBody();
    const isValid = handleValidation(body, setClassNameFormText);
    if (!isValid) {
      setMessageTitle(i18n.errorMessages.validationErrorTitle);
      setMessageText(i18n.errorMessages.validationError);
      setIsMessageVisible(true);
    }
    if (isValid) {
      setIsRequestInProgress(true);
      if (isEdit) {
        handleEditRequest("tenants/", body, id, handleAfterEdit);
      } else {
        handleAddRequest("tenants/", body, handleAfterAdd);
      }
    }
  };

  function finishLoading () {
    setIsRequestInProgress(false);
  }

  const handleUploadPicture = (event) => {
    // file.name file.size file.type
    const file = event.target.files[0];
    // const fileTypeName = file.constructor.name
    setPicture(file);
    onChangePicturePath(event);
    setValuePictureToShow(URL.createObjectURL(file));
  };

  useEffect(() => {
    const body = getBody();
    handleValidation(body, setClassNameFormText);
  }, [valueName, valueShortName, valueStatus,
    valueDescription, valueTelephone, valueAddress]);

  if (isRequestInProgress) {
    return <CommonLoading></CommonLoading>;
  }

  return (
    <div className="puggysoft-tenant-form" >
      <CommonMessage
        isVisible={isMessageVisible}
        setIsVisible={setIsMessageVisible}
        titleText={messageTitle}
        bodyText={messageText}
        variant="danger"
      />
      <Card>
        <Card.Header as="h3">{title}</Card.Header>
        <Card.Body>
          <Form>
            <Form.Group className="mb-3" controlId="name">
              <Form.Label>{i18n.tenantForm.fieldName}</Form.Label>
              <Form.Control
                onChange={onChangeName}
                value={valueName}
                type="text"
                placeholder={i18n.tenantForm.fieldName} />
              <Alert key={"danger"} variant={"danger"} className={classNameFormText.name}>
                {i18n.tenantForm.formTextName}
              </Alert>
            </Form.Group>
            <Form.Group className="mb-3" controlId="shortName">
              <Form.Label>{i18n.tenantForm.fieldShortName}</Form.Label>
              <Form.Control
                onChange={onChangeShortName}
                value={valueShortName}
                type="text"
                placeholder={i18n.tenantForm.fieldShortName} />
              <Alert key={"danger"} variant={"danger"} className={classNameFormText.shortName}>
                {i18n.tenantForm.formTextShortName}
              </Alert>
            </Form.Group>
            <Form.Group className="mb-3" controlId="status">
              <Form.Label>{i18n.tenantForm.fieldStatus}</Form.Label>
              <Form.Select
                onChange={onChangeStatus}
                value={valueStatus} >
                <option key="option-true" value={enumStatus.ACTIVE}>{i18n.tenantStatusText.active}</option>
                <option key="option-false" value={enumStatus.INACTIVE}>{i18n.tenantStatusText.inactive}</option>
              </Form.Select>
              <Alert key={"light"} variant={"light"}>
                {i18n.tenantForm.formTextStatus}
              </Alert>
            </Form.Group>
            <Form.Group className="mb-3" controlId="description">
              <Form.Label>{i18n.tenantForm.fieldDescription}</Form.Label>
              <Form.Control
                onChange={onChangeDescription}
                value={valueDescription}
                type="text"
                placeholder={i18n.tenantForm.fieldDescription} />
              <Alert key={"danger"} variant={"danger"} className={classNameFormText.description}>
                {i18n.tenantForm.formTextDescription}
              </Alert>
            </Form.Group>
            <Form.Group className="mb-3" controlId="telephone">
              <Form.Label>{i18n.tenantForm.fieldTelephone}</Form.Label>
              <Form.Control
                onChange={onChangeTelephone}
                value={valueTelephone}
                type="number"
                placeholder={i18n.tenantForm.fieldTelephone} />
              <Alert key={"danger"} variant={"danger"} className={classNameFormText.telephone}>
                {i18n.tenantForm.formTextTelephone}
              </Alert>
            </Form.Group>
            <Form.Group className="mb-3" controlId="address">
              <Form.Label>{i18n.tenantForm.fieldAddress}</Form.Label>
              <Form.Control
                onChange={onChangeAddress}
                value={valueAddress}
                type="text"
                placeholder={i18n.tenantForm.fieldAddress} />
              <Alert key={"danger"} variant={"danger"} className={classNameFormText.address}>
                {i18n.tenantForm.formTextAddress}
              </Alert>
            </Form.Group>
            <Card.Img variant="top tenant-image" src={valuePictureToShow} />
            <Form.Group controlId="formFile" className="mb-3 puggysoft-form-item-input-file">
              <Form.Label>{i18n.tenantForm.fieldImage}</Form.Label>
              <Form.Control
                type="file"
                onChange={(event) => handleUploadPicture(event)}
                value={valuePicturePath}
              />
              <Alert key={"light"} variant={"light"}>
                {i18n.tenantForm.formTextImage}
              </Alert>
            </Form.Group>
            <Button
              onClick={handleAdd}
              variant="primary"
              type="button">{isEdit ? i18n.tenantForm.buttonEdit : i18n.tenantForm.buttonAdd}</Button>
          </Form>
        </Card.Body>
      </Card>
    </div >
  );
}

export default TenantForm;
