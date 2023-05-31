import enumCompareOperators from "./../enumCompareOperators";
import enumTableColumnsToShow from "./enumTableColumnsToShow";
import arrayDataFieldsImport from "./arrayTenantDataFields";
import arrayColumnsLabelsImport from "./arrayTenantColumns";
import tenantsColumnsFilter from "./tenantsColumnsFilter";

const resourcesTableModels = function (
  tableColumnsToShow,
  /* ID */ criteriaId, criteriaOnChangeId, criteriaSetId, operatorId, operatorOnChangeId, operatorSetId,
  /* NAME */ criteriaName, criteriaOnChangeName, criteriaSetName, operatorName, operatorOnChangeName, operatorSetName,
  /* SHORT NAME */ criteriaShortName, criteriaOnChangeShortName, criteriaSetShortName, operatorShortName, operatorOnChangeShortName, operatorSetShortName,
  /* STATUS */criteriaStatus, criteriaOnChangeStatus, criteriaSetStatus, operatorStatus, operatorOnChangeStatus, operatorSetStatus,
  /* DESCRIPTION */ criteriaDescription, criteriaOnChangeDescription, criteriaSetDescription, operatorDescription, operatorOnChangeDescription, operatorSetDescription,
  /* TELEPHONE */criteriaTelephone, criteriaOnChangeTelephone, criteriaSetTelephone, operatorTelephone, operatorOnChangeTelephone, operatorSetTelephone,
  /* ADDRESS */criteriaAddress, criteriaOnChangeAddress, criteriaSetAddress, operatorAddress, operatorOnChangeAddress, operatorSetAddress,
  /* IMAGE */criteriaImage, criteriaOnChangeImage, criteriaSetImage, operatorImage, operatorOnChangeImage, operatorSetImage,
  /* CREATED BY */criteriaCreatedBy, criteriaOnChangeCreatedBy, criteriaSetCreatedBy, operatorCreatedBy, operatorOnChangeCreatedBy, operatorSetCreatedBy,
  /* UPDATED BY */criteriaUpdatedBy, criteriaOnChangeUpdatedBy, criteriaSetUpdatedBy, operatorUpdatedBy, operatorOnChangeUpdatedBy, operatorSetUpdatedBy,
  /* CREATED DATE */criteriaCreatedDate, criteriaOnChangeCreatedDate, criteriaSetCreatedDate, operatorCreatedDate, operatorOnChangeCreatedDate, operatorSetCreatedDate,
  /* UPDATED DATE */criteriaUpdatedDate, criteriaOnChangeUpdatedDate, criteriaSetUpdatedDate, operatorUpdatedDate, operatorOnChangeUpdatedDate, operatorSetUpdatedDate
) {
  const arrayDataFields = [...arrayDataFieldsImport];
  const arrayColumnsLabels = [...arrayColumnsLabelsImport];
  const arrayColumnsFilter = tenantsColumnsFilter(
    /* ID */ criteriaId, criteriaOnChangeId, operatorId, operatorOnChangeId,
    /* NAME */ criteriaName, criteriaOnChangeName, operatorName, operatorOnChangeName,
    /* SHORT NAME */ criteriaShortName, criteriaOnChangeShortName, operatorShortName, operatorOnChangeShortName,
    /* STATUS */criteriaStatus, criteriaOnChangeStatus, operatorStatus, operatorOnChangeStatus,
    /* DESCRIPTION */ criteriaDescription, criteriaOnChangeDescription, operatorDescription, operatorOnChangeDescription,
    /* TELEPHONE */criteriaTelephone, criteriaOnChangeTelephone, operatorTelephone, operatorOnChangeTelephone,
    /* ADDRESS */criteriaAddress, criteriaOnChangeAddress, operatorAddress, operatorOnChangeAddress,
    /* IMAGE */criteriaImage, criteriaOnChangeImage, operatorImage, operatorOnChangeImage,
    /* CREATED BY */criteriaCreatedBy, criteriaOnChangeCreatedBy, operatorCreatedBy, operatorOnChangeCreatedBy,
    /* UPDATED BY */criteriaUpdatedBy, criteriaOnChangeUpdatedBy, operatorUpdatedBy, operatorOnChangeUpdatedBy,
    /* CREATED DATE */criteriaCreatedDate, criteriaOnChangeCreatedDate, operatorCreatedDate, operatorOnChangeCreatedDate,
    /* UPDATED DATE */criteriaUpdatedDate, criteriaOnChangeUpdatedDate, operatorUpdatedDate, operatorOnChangeUpdatedDate
  );

  const setOperatorsDefaultValues = function () {
    operatorSetId(enumCompareOperators.TEXT_CONTAINS);
    operatorSetName(enumCompareOperators.TEXT_CONTAINS);
    operatorSetShortName(enumCompareOperators.TEXT_CONTAINS);
    operatorSetStatus(enumCompareOperators.NUMBER_EQUALS);
    operatorSetDescription(enumCompareOperators.NUMBER_EQUALS);
    operatorSetTelephone(enumCompareOperators.NUMBER_EQUALS);
    operatorSetAddress(enumCompareOperators.NUMBER_EQUALS);
    operatorSetImage(enumCompareOperators.TEXT_CONTAINS);
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
    criteriaSetImage("");
    criteriaSetCreatedBy("");
    criteriaSetUpdatedBy("");
    criteriaSetCreatedDate("");
    criteriaSetUpdatedDate("");
    setOperatorsDefaultValues();
  };

  const isMedium = tableColumnsToShow === enumTableColumnsToShow.MEDIUM;
  const isMinimum = tableColumnsToShow === enumTableColumnsToShow.MINIMUM;
  if (isMedium) {
    arrayColumnsFilter.splice(arrayColumnsFilter.length - 4, 4);
    arrayColumnsLabels.splice(arrayColumnsLabels.length - 4, 4);
    arrayDataFields.splice(arrayDataFields.length - 4, 4);
  } else if (isMinimum) {
    arrayColumnsFilter.splice(arrayColumnsFilter.length - 5, 5);
    arrayColumnsLabels.splice(arrayColumnsLabels.length - 5, 5);
    arrayDataFields.splice(arrayDataFields.length - 5, 5);
  }

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
      imageCriteria: criteriaImage,
      imageOperator: operatorImage,
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
    setOperatorsDefaultValues,
    arrayDataFields,
    arrayColumnsLabels
  };
};

export default resourcesTableModels;
