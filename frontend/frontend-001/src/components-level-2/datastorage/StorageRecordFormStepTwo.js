import React, {
  useState,
  useEffect
} from "react";

import { useDispatch } from "react-redux";
import { useHistory } from "react-router";
import i18n from "./../../i18n/i18n";
import CommonForm from "./../../components-level-1/CommonForm";
import enumInputType from "./../../models/enumInputType";
import enumBootstrapVariant from "./../../models/enumBootstrapVariant";
import { openCommonMessage } from "./../../redux/reducers/reducerCommonMessage";
import { handleGetRequest, handleAddRequest, handleEditRequest } from "../../actions/HandleManager";
import CommonLoading from "../../components-level-1/CommonLoading";
import uuidv4 from "../../tools/uuidv4";

function StorageSchemaForm () {
  const dispatch = useDispatch();
  const history = useHistory();
  const dataParams = history && history.location && history.location.state;
  const [isRequestInProgress, setIsRequestInProgress] = useState(false);
  const [editData, setEditData] = useState(
    dataParams && dataParams.editData
      ? dataParams.editData
      : null);
  // Form Data
  const schemaSelected = dataParams?.schemaSelected;
  const [formSchema, setFormSchema] = useState([]);
  const [currentValue, setCurrentValue] = useState(null);

  const getBodyData = function (
    formSchemaItem,
    recoredShortName,
    schemaShortName
  ) {
    const username = window.sessionStorage.getItem("username");
    const tenant = window.sessionStorage.getItem("tenant");
    const body = {
      record: recoredShortName,
      field: formSchemaItem.key,
      fieldValue: formSchemaItem.inputValue,
      schema: schemaShortName,
      tenant,
      createdBy: username,
      updatedBy: username
    };
    return body;
  };

  const getBodyRecord = function (schemaShortName) {
    const username = window.sessionStorage.getItem("username");
    const tenant = window.sessionStorage.getItem("tenant");
    const uuid = uuidv4();
    const body = {
      shortName: schemaShortName + "-" + uuid,
      schema: schemaShortName,
      aux: "",
      tenant,
      createdBy: username,
      updatedBy: username
    };
    return body;
  };

  const handleReset = function () {
    const newFormSchema = [];
    formSchema.forEach((schemaFormItem) => {
      const newSchemaFormItem = {
        ...schemaFormItem,
        inputValue: ""
      };
      newFormSchema.push(newSchemaFormItem);
    });
    setEditData(null);
    setFormSchema(newFormSchema);
  };

  // Update inputs
  useEffect(() => {
    if (currentValue) {
      const newFormSchema = [];
      formSchema.forEach((schemaFormItem) => {
        const newSchemaFormItem = {
          ...schemaFormItem
        };
        if (schemaFormItem.key === currentValue.key) {
          newSchemaFormItem.inputValue = currentValue.value;
          newFormSchema.push(newSchemaFormItem);
        } else {
          newFormSchema.push(newSchemaFormItem);
        }
      });
      setFormSchema(newFormSchema);
      setCurrentValue(null);
    }
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [currentValue]);

  const onChangeValue = (event, commonFormItem) => {
    event.preventDefault();
    setCurrentValue({
      key: commonFormItem.key,
      value: event.target.value
    });
  };

  const afterSuccessGetAllFields = function (arrayOfFieldsData) {
    setIsRequestInProgress(false);
    const newFormSchema = [];
    arrayOfFieldsData.forEach((itemField) => {
      const schemaFormItem = {};
      schemaFormItem.key = itemField.shortName;
      schemaFormItem.inputType = itemField.type;
      schemaFormItem.label = itemField.name;
      schemaFormItem.inputValue = editData ? editData[itemField.shortName] : "";
      schemaFormItem.suggestionText = "";
      schemaFormItem.suggestionTextClassName = "";
      schemaFormItem.onChange = onChangeValue;
      schemaFormItem.isDisabledEdit = false;
      if (itemField.type === enumInputType.SELECT) {
        const objectSelectOption = JSON.parse(itemField.textboxOption);
        if (objectSelectOption && objectSelectOption.constructor.name === "Array") {
          schemaFormItem.inputSelectOption = objectSelectOption;
          if (objectSelectOption.length > 0) {
            const defaultValue = objectSelectOption[0].value;
            schemaFormItem.inputValue = defaultValue;
          }
        }
      }
      newFormSchema.push(schemaFormItem);
    });
    setFormSchema(newFormSchema);
  };

  useEffect(() => {
    // Get all fields that belongs to schema
    if (schemaSelected) {
      setIsRequestInProgress(true);
      handleGetRequest(`storage-field-by-schema?schemaShortName=${schemaSelected.shortName}`,
        afterSuccessGetAllFields,
        showErrorMessage,
        false
      );
    }
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  const handleAddEdit = function (event) {
    event.preventDefault();
    if (formSchema.length === 0) {
      return;
    }
    setIsRequestInProgress(true);
    if (editData) {
      formSchema.forEach((formSchemaItem, index) => {
        const body = getBodyData(formSchemaItem, editData.record, schemaSelected.shortName);
        if (formSchema.length === index + 1) {
          handleEditRequest("storage-data/", body, editData.mapIds.get(formSchemaItem.key), handleAferAddEdit, showErrorMessage, false);
        } else {
          handleEditRequest("storage-data/", body, editData.mapIds.get(formSchemaItem.key), () => { }, showErrorMessage, false);
        }
      });
      return;
    }
    const bodyRecord = getBodyRecord(schemaSelected.shortName);
    // This function is executed after get record a new record
    function addDataToRecord (record) {
      formSchema.forEach((formSchemaItem, index) => {
        const body = getBodyData(formSchemaItem, record.shortName, schemaSelected.shortName);
        if (formSchema.length === index + 1) {
          handleAddRequest("storage-data/", body, handleAferAddEdit, false, showErrorMessage);
        } else {
          handleAddRequest("storage-data/", body, () => { }, false, showErrorMessage);
        }
      });
    }
    // This function execute after create a new record
    function getRecordById (recordId) {
      handleGetRequest(`storage-record/${recordId}`, addDataToRecord, showErrorMessage, false);
    }
    handleAddRequest("storage-record/", bodyRecord, getRecordById, false, showErrorMessage);
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

  const formProps = {
    title: i18n.datastorage.recordFormTitleStepTwo,
    handleAction: handleAddEdit,
    buttonText: i18n.commonForm.saveButton,
    buttonVariant: enumBootstrapVariant.PRIMARY
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
      schema={formSchema}
    />
  );
}

export default StorageSchemaForm;
