import enumCompareOperators from "../enumCompareOperators";
import enumTableColumnsToShow from "../enumTableColumnsToShow";
import arrayDataFields from "./scheduleDataFields";
import arrayColumnsLabels from "./scheduleColumnsLabels";
import columnsFilter from "./scheduleColumnsFilter";

const tableModels = function (
  tableColumnsToShow,
  /* ID */ criteriaId, criteriaOnChangeId, criteriaSetId, operatorId, operatorOnChangeId, operatorSetId,
  /* NAME */ criteriaName, criteriaOnChangeName, criteriaSetName, operatorName, operatorOnChangeName, operatorSetName,
  /* CREATED BY */criteriaCreatedBy, criteriaOnChangeCreatedBy, criteriaSetCreatedBy, operatorCreatedBy, operatorOnChangeCreatedBy, operatorSetCreatedBy,
  /* UPDATED BY */criteriaUpdatedBy, criteriaOnChangeUpdatedBy, criteriaSetUpdatedBy, operatorUpdatedBy, operatorOnChangeUpdatedBy, operatorSetUpdatedBy,
  /* CREATED DATE */criteriaCreatedDate, criteriaOnChangeCreatedDate, criteriaSetCreatedDate, operatorCreatedDate, operatorOnChangeCreatedDate, operatorSetCreatedDate,
  /* UPDATED DATE */criteriaUpdatedDate, criteriaOnChangeUpdatedDate, criteriaSetUpdatedDate, operatorUpdatedDate, operatorOnChangeUpdatedDate, operatorSetUpdatedDate
) {
  const arrayColumnsFilter = columnsFilter(
    /* ID */ criteriaId, criteriaOnChangeId, operatorId, operatorOnChangeId,
    /* NAME */ criteriaName, criteriaOnChangeName, operatorName, operatorOnChangeName,
    /* CREATED BY */criteriaCreatedBy, criteriaOnChangeCreatedBy, operatorCreatedBy, operatorOnChangeCreatedBy,
    /* UPDATED BY */criteriaUpdatedBy, criteriaOnChangeUpdatedBy, operatorUpdatedBy, operatorOnChangeUpdatedBy,
    /* CREATED DATE */criteriaCreatedDate, criteriaOnChangeCreatedDate, operatorCreatedDate, operatorOnChangeCreatedDate,
    /* UPDATED DATE */criteriaUpdatedDate, criteriaOnChangeUpdatedDate, operatorUpdatedDate, operatorOnChangeUpdatedDate);

  const setOperatorsDefaultValues = function () {
    operatorSetId(enumCompareOperators.NUMBER_EQUALS);
    operatorSetName(enumCompareOperators.TEXT_CONTAINS);
    operatorSetCreatedBy(enumCompareOperators.TEXT_CONTAINS);
    operatorSetUpdatedBy(enumCompareOperators.TEXT_CONTAINS);
    operatorSetCreatedDate(enumCompareOperators.DATE_EQUALS);
    operatorSetUpdatedDate(enumCompareOperators.DATE_EQUALS);
  };

  const clearFilters = function () {
    criteriaSetId("");
    criteriaSetName("");
    criteriaSetCreatedBy("");
    criteriaSetUpdatedBy("");
    criteriaSetCreatedDate("");
    criteriaSetUpdatedDate("");
    setOperatorsDefaultValues();
  };

  const isMedium = tableColumnsToShow === enumTableColumnsToShow.MENDIUM;
  const isMinimum = tableColumnsToShow === enumTableColumnsToShow.MINIMUM;

  if (isMedium) {
    arrayColumnsFilter.slice(0, arrayColumnsFilter.length - 4);
    arrayColumnsLabels.slice(0, arrayColumnsFilter.length - 4);
    arrayDataFields.slice(0, arrayColumnsFilter.length - 4);
  } else if (isMinimum) {
    arrayColumnsFilter.slice(0, arrayColumnsFilter.length - 5);
    arrayColumnsLabels.slice(0, arrayColumnsFilter.length - 5);
    arrayDataFields.slice(0, arrayColumnsFilter.length - 5);
  }

  const getFilterBody = () => {
    const filterBody = {
      idCriteria: criteriaId,
      idOperator: operatorId,
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

export default tableModels;
