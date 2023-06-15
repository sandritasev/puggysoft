import enumFilterType from "../enumFilterType";
import enumCompareOperators from "../enumCompareOperators";
import enumStatus from "./enumStatus";
import i18n from "../../i18n/i18n";

const getColumnsFilterModel = function (
  /* ID */ criteriaId, criteriaOnChangeId, criteriaSetId, operatorId, operatorOnChangeId, operatorSetId,
  /* NAME */ criteriaName, criteriaOnChangeName, criteriaSetName, operatorName, operatorOnChangeName, operatorSetName,
  /* SHORT NAME */ criteriaShortName, criteriaOnChangeShortName, criteriaSetShortName, operatorShortName, operatorOnChangeShortName, operatorSetShortName,
  /* STATUS */criteriaStatus, criteriaOnChangeStatus, criteriaSetStatus, operatorStatus, operatorOnChangeStatus, operatorSetStatus,
  /* DESCRIPTION */ criteriaDescription, criteriaOnChangeDescription, criteriaSetDescription, operatorDescription, operatorOnChangeDescription, operatorSetDescription,
  /* TELEPHONE */criteriaTelephone, criteriaOnChangeTelephone, criteriaSetTelephone, operatorTelephone, operatorOnChangeTelephone, operatorSetTelephone,
  /* ADDRESS */criteriaAddress, criteriaOnChangeAddress, criteriaSetAddress, operatorAddress, operatorOnChangeAddress, operatorSetAddress,
  /* CREATED BY */criteriaCreatedBy, criteriaOnChangeCreatedBy, criteriaSetCreatedBy, operatorCreatedBy, operatorOnChangeCreatedBy, operatorSetCreatedBy,
  /* UPDATED BY */criteriaUpdatedBy, criteriaOnChangeUpdatedBy, criteriaSetUpdatedBy, operatorUpdatedBy, operatorOnChangeUpdatedBy, operatorSetUpdatedBy,
  /* CREATED DATE */criteriaCreatedDate, criteriaOnChangeCreatedDate, criteriaSetCreatedDate, operatorCreatedDate, operatorOnChangeCreatedDate, operatorSetCreatedDate,
  /* UPDATED DATE */criteriaUpdatedDate, criteriaOnChangeUpdatedDate, criteriaSetUpdatedDate, operatorUpdatedDate, operatorOnChangeUpdatedDate, operatorSetUpdatedDate
) {
  const arrayColumnsFilter = [
    {
      type: enumFilterType.NONE
    },
    {
      type: enumFilterType.TEXTBOX,
      criteriaValue: criteriaId,
      criteriaOnchange: criteriaOnChangeId,
      operatorValue: operatorId,
      operatorOnchange: operatorOnChangeId
    },
    {
      type: enumFilterType.TEXTBOX,
      criteriaValue: criteriaName,
      criteriaOnchange: criteriaOnChangeName,
      operatorValue: operatorName,
      operatorOnchange: operatorOnChangeName
    },
    {
      type: enumFilterType.TEXTBOX,
      criteriaValue: criteriaShortName,
      criteriaOnchange: criteriaOnChangeShortName,
      operatorValue: operatorShortName,
      operatorOnchange: operatorOnChangeShortName
    },
    {
      type: enumFilterType.DROPDOWN,
      criteriaValue: criteriaStatus,
      criteriaOnchange: criteriaOnChangeStatus,
      operatorValue: operatorStatus,
      operatorOnchange: operatorOnChangeStatus,
      dropdownValues: [
        { value: "", text: i18n.tenantStatusText.all },
        { value: enumStatus.ACTIVE, text: i18n.tenantStatusText.active },
        { value: enumStatus.INACTIVE, text: i18n.tenantStatusText.inactive }
      ]
    },
    {
      type: enumFilterType.TEXTBOX,
      criteriaValue: criteriaDescription,
      criteriaOnchange: criteriaOnChangeDescription,
      operatorValue: operatorDescription,
      operatorOnchange: operatorOnChangeDescription
    },
    {
      type: enumFilterType.TEXTBOX,
      criteriaValue: criteriaTelephone,
      criteriaOnchange: criteriaOnChangeTelephone,
      operatorValue: operatorTelephone,
      operatorOnchange: operatorOnChangeTelephone
    },
    {
      type: enumFilterType.TEXTBOX,
      criteriaValue: criteriaAddress,
      criteriaOnchange: criteriaOnChangeAddress,
      operatorValue: operatorAddress,
      operatorOnchange: operatorOnChangeAddress
    },
    {
      type: enumFilterType.TEXTBOX,
      criteriaValue: criteriaCreatedBy,
      criteriaOnchange: criteriaOnChangeCreatedBy,
      operatorValue: operatorCreatedBy,
      operatorOnchange: operatorOnChangeCreatedBy
    },
    {
      type: enumFilterType.TEXTBOX,
      criteriaValue: criteriaUpdatedBy,
      criteriaOnchange: criteriaOnChangeUpdatedBy,
      operatorValue: operatorUpdatedBy,
      operatorOnchange: operatorOnChangeUpdatedBy
    },
    {
      type: enumFilterType.DATE,
      criteriaValue: criteriaCreatedDate,
      criteriaOnchange: criteriaOnChangeCreatedDate,
      operatorValue: operatorCreatedDate,
      operatorOnchange: operatorOnChangeCreatedDate
    },
    {
      type: enumFilterType.DATE,
      criteriaValue: criteriaUpdatedDate,
      criteriaOnchange: criteriaOnChangeUpdatedDate,
      operatorValue: operatorUpdatedDate,
      operatorOnchange: operatorOnChangeUpdatedDate
    }
  ];

  const setOperatorsDefaultValues = function () {
    operatorSetId(enumCompareOperators.TEXT_CONTAINS);
    operatorSetName(enumCompareOperators.TEXT_CONTAINS);
    operatorSetShortName(enumCompareOperators.TEXT_CONTAINS);
    operatorSetStatus(enumCompareOperators.NUMBER_EQUALS);
    operatorSetDescription(enumCompareOperators.NUMBER_EQUALS);
    operatorSetTelephone(enumCompareOperators.NUMBER_EQUALS);
    operatorSetAddress(enumCompareOperators.NUMBER_EQUALS);
    operatorSetCreatedBy(enumCompareOperators.TEXT_CONTAINS);
    operatorSetUpdatedBy(enumCompareOperators.TEXT_CONTAINS);
    operatorSetCreatedDate(enumCompareOperators.DATE_EQUALS);
    operatorSetUpdatedDate(enumCompareOperators.DATE_EQUALS);
  };

  const clearFilters = function () {
    criteriaSetId("");
    criteriaSetName("");
    criteriaSetShortName("");
    criteriaSetStatus("");
    criteriaSetDescription("");
    criteriaSetTelephone("");
    criteriaSetAddress("");
    criteriaSetCreatedBy("");
    criteriaSetUpdatedBy("");
    criteriaSetCreatedDate("");
    criteriaSetUpdatedDate("");
    setOperatorsDefaultValues();
  };

  const getFilterBody = () => {
    const filterBody = {
      idCriteria: criteriaId,
      idOperator: operatorId,
      shortNameCriteria: criteriaShortName,
      shortNameOperator: operatorShortName,
      statusCriteria: criteriaStatus,
      statusOperator: operatorStatus,
      descriptionCriteria: criteriaDescription,
      descriptionOperator: operatorDescription,
      telephoneCriteria: criteriaTelephone,
      telephoneOperator: operatorTelephone,
      addressCriteria: criteriaAddress,
      addressOperator: operatorAddress,
      nameCriteria: criteriaName,
      nameOperator: operatorName,
      createdByCriteria: criteriaCreatedBy,
      createdByOperator: operatorCreatedBy,
      updatedByCriteria: criteriaUpdatedBy,
      updatedByOperator: operatorUpdatedBy,
      creationDateCriteria: criteriaCreatedDate,
      creationDateOperator: operatorCreatedDate,
      updateDateCriteria: criteriaUpdatedDate,
      updateDateOperator: operatorUpdatedDate
    };
    return filterBody;
  };

  return {
    arrayColumnsFilter,
    clearFilters,
    getFilterBody,
    setOperatorsDefaultValues
  };
};

export default getColumnsFilterModel;
