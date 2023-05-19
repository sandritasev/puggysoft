import enumFilterType from "../enumFilterType";
import enumCompareOperators from "../enumCompareOperators";
import enumStatus from "./enumStatus";
import i18n from "../../i18n/i18n";

const getColumnsFilterModel = function (
  /* NAME */ criteriaName, criteriaOnChangeName, criteriaSetName, operatorName, operatorOnChangeName, operatorSetName,
  /* SHORT NAME */ criteriaShortName, criteriaOnChangeShortName, criteriaSetShortName, operatorShortName, operatorOnChangeShortName, operatorSetShortName,
  /* STATUS */criteriaStatus, criteriaOnChangeStatus, criteriaSetStatus, operatorStatus, operatorOnChangeStatus, operatorSetStatus,
  /* DESCRIPTION */ criteriaDescription, criteriaOnChangeDescription, criteriaSetDescription, operatorDescription, operatorOnChangeDescription, operatorSetDescription
) {
  const arrayColumnsFilter = [
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
      type: enumFilterType.NONE
    }
  ];

  const setOperatorsDefaultValues = function () {
    operatorSetName(enumCompareOperators.TEXT_CONTAINS);
    operatorSetShortName(enumCompareOperators.TEXT_CONTAINS);
    operatorSetStatus(enumCompareOperators.TEXT_EQUALS);
    operatorSetDescription(enumCompareOperators.TEXT_CONTAINS);
  };

  const clearFilters = function () {
    criteriaSetName("");
    criteriaSetShortName("");
    criteriaSetStatus("");
    criteriaSetDescription("");
    setOperatorsDefaultValues();
  };

  const getFilterBody = () => {
    const filterBody = {
      nameCriteria: criteriaShortName,
      nameOperator: operatorShortName,
      shortNameCriteria: criteriaShortName,
      shortNameOperator: operatorShortName,
      statusCriteria: criteriaStatus,
      statusOperator: operatorStatus,
      descriptionCriteria: criteriaDescription,
      descriptionOperator: operatorDescription
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
