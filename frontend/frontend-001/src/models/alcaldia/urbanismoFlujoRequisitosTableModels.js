import enumCompareOperators from "../enumCompareOperators";
import enumTableColumnsToShow from "../enumTableColumnsToShow";
import arrayDataFieldsImport from "./urbanismoFlujoRequisitosDataFields";
import arrayColumnsLabelsImport from "./urbanismoFlujoRequisitosColumnsLabels";
import urbanismoFlujoRequisitosColumnsFilter from "./urbanismoFlujoRequisitosColumnsFilter";

const urbanismoTramiteEstadosTableModels = function (
  tableColumnsToShow,
  /* ID */ criteriaId,
  criteriaOnChangeId,
  criteriaSetId,
  operatorId,
  operatorOnChangeId,
  operatorSetId,
  /* IDFLUJO */ criteriaIdFlujo,
  criteriaOnChangeIdFlujo,
  criteriaSetIdFlujo,
  operatorIdFlujo,
  operatorOnChangeIdFlujo,
  operatorSetIdFlujo,
  /* REQUISITOS */criteriaRequisitos,
  criteriaOnChangeRequisitos,
  criteriaSetRequisitos,
  operatorRequisitos,
  operatorOnChangeRequisitos,
  operatorSetRequisitos,
  /* ESTADOS */ criteriaEstados,
  criteriaOnChangeEstados,
  criteriaSetEstados,
  operatorEstados,
  operatorOnChangeEstados,
  operatorSetEstados,
  /* ARCHIVO */ criteriaArchivo,
  criteriaOnChangeArchivo,
  criteriaSetArchivo,
  operatorArchivo,
  operatorOnChangeArchivo,
  operatorSetArchivo,
  /* CREATED BY */ criteriaCreatedBy,
  criteriaOnChangeCreatedBy,
  criteriaSetCreatedBy,
  operatorCreatedBy,
  operatorOnChangeCreatedBy,
  operatorSetCreatedBy,
  /* UPDATED BY */ criteriaUpdatedBy,
  criteriaOnChangeUpdatedBy,
  criteriaSetUpdatedBy,
  operatorUpdatedBy,
  operatorOnChangeUpdatedBy,
  operatorSetUpdatedBy,
  /* CREATED DATE */ criteriaCreatedDate,
  criteriaOnChangeCreatedDate,
  criteriaSetCreatedDate,
  operatorCreatedDate,
  operatorOnChangeCreatedDate,
  operatorSetCreatedDate,
  /* UPDATED DATE */ criteriaUpdatedDate,
  criteriaOnChangeUpdatedDate,
  criteriaSetUpdatedDate,
  operatorUpdatedDate,
  operatorOnChangeUpdatedDate,
  operatorSetUpdatedDate
) {
  let arrayDataFields = arrayDataFieldsImport;
  let arrayColumnsLabels = arrayColumnsLabelsImport;
  let arrayColumnsFilter = urbanismoFlujoRequisitosColumnsFilter(
    /* ID */ criteriaId,
    criteriaOnChangeId,
    operatorId,
    operatorOnChangeId,
    /* FLUJO */ criteriaIdFlujo,
    criteriaOnChangeIdFlujo,
    operatorIdFlujo,
    operatorOnChangeIdFlujo,
    /* REQUISITOS */ criteriaRequisitos,
    criteriaOnChangeRequisitos,
    operatorRequisitos,
    operatorOnChangeRequisitos,
    /* ESTADO */ criteriaEstados,
    criteriaOnChangeEstados,
    operatorEstados,
    operatorOnChangeEstados,
    /* CREATED BY */ criteriaCreatedBy,
    criteriaOnChangeCreatedBy,
    operatorCreatedBy,
    operatorOnChangeCreatedBy,
    /* UPDATED BY */ criteriaUpdatedBy,
    criteriaOnChangeUpdatedBy,
    operatorUpdatedBy,
    operatorOnChangeUpdatedBy,
    /* CREATED DATE */ criteriaCreatedDate,
    criteriaOnChangeCreatedDate,
    operatorCreatedDate,
    operatorOnChangeCreatedDate,
    /* UPDATED DATE */ criteriaUpdatedDate,
    criteriaOnChangeUpdatedDate,
    operatorUpdatedDate,
    operatorOnChangeUpdatedDate
  );

  const setOperatorsDefaultValues = function () {
    operatorSetId(enumCompareOperators.NUMBER_EQUALS);
    operatorSetIdFlujo(enumCompareOperators.TEXT_CONTAINS);
    operatorSetEstados(enumCompareOperators.TEXT_CONTAINS);
    operatorSetRequisitos(enumCompareOperators.TEXT_CONTAINS);
    operatorSetCreatedBy(enumCompareOperators.TEXT_CONTAINS);
    operatorSetUpdatedBy(enumCompareOperators.TEXT_CONTAINS);
    operatorSetCreatedDate(enumCompareOperators.DATE_EQUALS);
    operatorSetUpdatedDate(enumCompareOperators.DATE_EQUALS);
  };

  const clearFilters = function () {
    criteriaSetId("");
    criteriaSetIdFlujo("");
    criteriaSetEstados("");
    criteriaSetRequisitos("");
    criteriaSetCreatedBy("");
    criteriaSetUpdatedBy("");
    criteriaSetCreatedDate("");
    criteriaSetUpdatedDate("");
    setOperatorsDefaultValues();
  };

  const isMedium = tableColumnsToShow === enumTableColumnsToShow.MEDIUM;
  const isMinimum = tableColumnsToShow === enumTableColumnsToShow.MINIMUM;

  if (isMedium) {
    arrayColumnsFilter = arrayColumnsFilter.slice(
      0,
      arrayColumnsFilter.length - 4
    );
    arrayColumnsLabels = arrayColumnsLabels.slice(
      0,
      arrayColumnsLabels.length - 5
    );
    arrayDataFields = arrayDataFields.slice(0, arrayDataFields.length - 5);
  } else if (isMinimum) {
    arrayColumnsFilter = arrayColumnsFilter.slice(
      1,
      arrayColumnsFilter.length - 4
    );
    arrayColumnsLabels = arrayColumnsLabels.slice(
      1,
      arrayColumnsLabels.length - 5
    );
    arrayDataFields = arrayDataFields.slice(1, arrayDataFields.length - 5);
  }

  const getFilterBody = () => {
    const tenant = window.sessionStorage.getItem("tenant");
    const filterBody = {
      idCriteria: criteriaId,
      idOperator: operatorId,
      idTramiteFlujoCriteria: criteriaIdFlujo,
      idTramiteFlujoOperator: operatorIdFlujo,
      requisitoNombreCortoCriteria: criteriaRequisitos,
      requisitoNombreCortoOperator: operatorRequisitos,
      estadoCriteria: criteriaEstados,
      estadoOperator: operatorEstados,
      createdByCriteria: criteriaCreatedBy,
      createdByOperator: operatorCreatedBy,
      updatedByCriteria: criteriaUpdatedBy,
      updatedByOperator: operatorUpdatedBy,
      creationDateCriteria: criteriaCreatedDate,
      creationDateOperator: operatorCreatedDate,
      updateDateCriteria: criteriaUpdatedDate,
      updateDateOperator: operatorUpdatedDate,
      tenantCriteria: tenant,
      tenantOperator: enumCompareOperators.TEXT_EQUALS
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

export default urbanismoTramiteEstadosTableModels;
