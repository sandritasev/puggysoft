import React, {
  useState,
  useEffect
} from "react";

import { useDispatch } from "react-redux";
import { useHistory } from "react-router";
import { handleValidation, classNameFormTextNew } from "./../../validations/datastorage/HandleFieldFormValidations";
import useInput from "./../../hooks/useInput";
import i18n from "./../../i18n/i18n";
import CommonForm from "./../../components-level-1/CommonForm";
import enumInputType from "./../../models/enumInputType";
import enumBootstrapVariant from "./../../models/enumBootstrapVariant";
import { openCommonMessage } from "./../../redux/reducers/reducerCommonMessage";
import { handleAddRequest, handleEditRequest } from "../../actions/HandleManager";
import CommonLoading from "../../components-level-1/CommonLoading";

function StorageFieldForm () {
  const dispatch = useDispatch();
  const history = useHistory();
  const editDataParam = history && history.location && history.location.state;
  const [editData, setEditData] = useState(editDataParam);
  const [classNameFormText, setClassNameFormText] = useState(classNameFormTextNew);
  const [isRequestInProgress, setIsRequestInProgress] = useState(false);

  const name = editData && editData.data.name !== null ? editData.data.name : "";
  const shortName = editData && editData.data.shortName !== null ? editData.data.shortName : "";
  const type = editData && editData.data.type !== null ? editData.data.type : enumInputType.TEXT;
  const textboxOption = editData && editData.data.textboxOption !== null ? editData.data.textboxOption : "[]";

  const { value: valueName, onChange: onChangeName, setValue: setName } = useInput(name);
  const { value: valueShortName, onChange: onChangeShortName, setValue: setShortName } = useInput(shortName);
  const { value: valueType, onChange: onChangeType, setValue: setType } = useInput(type);
  const { value: valueTextboxOption, onChange: onChangeTextboxOption, setValue: setTextboxOption } = useInput(textboxOption);

  const getBody = function () {
    const username = window.sessionStorage.getItem("username");
    const tenant = window.sessionStorage.getItem("tenant");
    const body = {
      name: valueName,
      shortName: valueShortName,
      type: valueType,
      textboxOption: valueTextboxOption,
      tenant,
      createdBy: username,
      updatedBy: username
    };
    return body;
  };

  const handleReset = function () {
    setName("");
    setShortName("");
    setType(enumInputType.TEXT);
    setTextboxOption("[]");
    setEditData(null);
  };

  useEffect(() => {
    const body = getBody();
    handleValidation(body, setClassNameFormText);
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [valueName, valueShortName, valueType, valueTextboxOption]);

  const handleAddEdit = function (event) {
    event.preventDefault();
    setIsRequestInProgress(true);
    const body = getBody();
    const isValid = handleValidation(body, setClassNameFormText);
    if (isValid) {
      if (editData) {
        const id = editData.data.id;
        handleEditRequest("storage-field/", body, id, handleAferAddEdit, showErrorMessage, false);
      } else {
        handleAddRequest("storage-field/", body, handleAferAddEdit, false, showErrorMessage);
      }
    } else {
      showValidationMessage();
    }
  };

  const handleAferAddEdit = function () {
    handleReset();
    setIsRequestInProgress(false);
    showSuccessMessage();
  };

  const showSuccessMessage = function () {
    dispatch(openCommonMessage({
      isMessageModalVisible: true,
      messageModalTitle: i18n.successMessages.successTitle,
      messageModalBody: editData
        ? i18n.successMessages.successfullyEdited
        : i18n.successMessages.successfullyCreated,
      messageModalVariant: editData
        ? enumBootstrapVariant.WARNING
        : enumBootstrapVariant.successMessages
    }));
  };

  const showErrorMessage = function (response, errorMessage) {
    setIsRequestInProgress(false);
    dispatch(openCommonMessage({
      isMessageModalVisible: true,
      messageModalTitle: i18n.errorMessages.errorTitle,
      messageModalBody: errorMessage,
      messageModalVariant: enumBootstrapVariant.DANGER
    }));
  };

  const showValidationMessage = function () {
    setIsRequestInProgress(false);
    dispatch(openCommonMessage({
      isMessageModalVisible: true,
      messageModalTitle: i18n.errorMessages.validationErrorTitle,
      messageModalBody: i18n.errorMessages.validationError,
      messageModalVariant: enumBootstrapVariant.DANGER
    }));
  };

  const formProps = {
    title: i18n.datastorage.fieldFormTitle,
    handleAction: handleAddEdit,
    buttonText: i18n.commonForm.saveButton,
    buttonVariant: enumBootstrapVariant.PRIMARY,
    schema: [
      {
        key: "name",
        inputType: enumInputType.TEXT,
        label: i18n.datastorage.fieldNameLabel,
        inputValue: valueName,
        suggestionText: i18n.datastorage.fieldFormNameErrorInputText,
        suggestionTextClassName: classNameFormText.name,
        onChange: onChangeName,
        isDisabledEdit: false,
        inputSelectOption: undefined
      },
      {
        key: "shortName",
        inputType: enumInputType.TEXT,
        label: i18n.datastorage.fieldShortNameLabel,
        inputValue: valueShortName,
        suggestionText: i18n.datastorage.fieldFormShortNameErrorInputText,
        suggestionTextClassName: classNameFormText.shortName,
        onChange: onChangeShortName,
        isDisabledEdit: false,
        inputSelectOption: undefined
      },
      {
        key: "type",
        inputType: enumInputType.SELECT,
        label: i18n.datastorage.fieldTypeLabel,
        inputValue: valueType,
        suggestionText: i18n.datastorage.fieldFormTypeErrorInputText,
        suggestionTextClassName: classNameFormText.type,
        onChange: onChangeType,
        isDisabledEdit: false,
        inputSelectOption: [
          {
            key: enumInputType.TEXT,
            value: enumInputType.TEXT,
            label: i18n.commonInputTypes.text
          },
          {
            key: enumInputType.TEXT_AREA,
            value: enumInputType.TEXT_AREA,
            label: i18n.commonInputTypes.textarea
          },
          {
            key: enumInputType.NUMBER,
            value: enumInputType.NUMBER,
            label: i18n.commonInputTypes.number
          },
          {
            key: enumInputType.EMAIL,
            value: enumInputType.EMAIL,
            label: i18n.commonInputTypes.email
          },
          {
            key: enumInputType.DATE,
            value: enumInputType.DATE,
            label: i18n.commonInputTypes.date
          },
          {
            key: enumInputType.PASSWORD,
            value: enumInputType.PASSWORD,
            label: i18n.commonInputTypes.password
          },
          {
            key: enumInputType.FILE,
            value: enumInputType.FILE,
            label: i18n.commonInputTypes.file
          },
          {
            key: enumInputType.SELECT,
            value: enumInputType.SELECT,
            label: i18n.commonInputTypes.select
          }
        ]
      },
      {
        key: "dropdown-options",
        inputType: enumInputType.TEXT_AREA,
        label: i18n.datastorage.fieldOptionsLabel,
        inputValue: valueTextboxOption,
        suggestionText: i18n.datastorage.fieldFormDropdownOptionsErrorInputText,
        suggestionTextClassName: classNameFormText.textboxOption,
        onChange: onChangeTextboxOption,
        isDisabledEdit: valueType !== enumInputType.SELECT,
        inputSelectOption: undefined
      }
    ]
  };

  if (isRequestInProgress) {
    return <CommonLoading />;
  }

  return (
    <CommonForm
      title={formProps.title}
      handleAction={formProps.handleAction}
      buttonText={formProps.buttonText}
      buttonVariant={formProps.buttonVariant}
      schema={formProps.schema}
    />
  );
}

export default StorageFieldForm;
