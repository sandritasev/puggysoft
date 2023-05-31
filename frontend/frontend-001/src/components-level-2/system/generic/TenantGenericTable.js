import React from "react";
import PropTypes from "prop-types";
import TableFilterGeneric from "./../../generic/TableFilterGeneric";
import useInput from "./../../../hooks/useInput";
import enumCompareOperators from "./../../../models/enumCompareOperators";
import enumTableColumnsToShow from "./../../../models/system/enumTableColumnsToShow";
import tenantTableModels from "../../../models/system/tenantTableModels";

function TenantGenericTable (props) {
  const {
    numberPagesToShow,
    tableTitle,
    tableSubTitle,
    handleGetData,
    handleGetSize,
    tableArrayCustomRowButtons,
    columnsToShow
  } = props;

  // CRITERIA OF SEARCH OR FILTER
  const { value: criteriaId, onChange: criteriaOnChangeId, setValue: criteriaSetId } = useInput("");
  const { value: criteriaName, onChange: criteriaOnChangeName, setValue: criteriaSetName } = useInput("");
  const { value: criteriaShortName, onChange: criteriaOnChangeShortName, setValue: criteriaSetShortName } = useInput("");
  const { value: criteriaStatus, onChange: criteriaOnChangeStatus, setValue: criteriaSetStatus } = useInput("");
  const { value: criteriaDescription, onChange: criteriaOnChangeDescription, setValue: criteriaSetDescription } = useInput("");
  const { value: criteriaTelephone, onChange: criteriaOnChangeTelephone, setValue: criteriaSetTelephone } = useInput("");
  const { value: criteriaAddress, onChange: criteriaOnChangeAddress, setValue: criteriaSetAddress } = useInput("");
  const { value: criteriaCreatedBy, onChange: criteriaOnChangeCreatedBy, setValue: criteriaSetCreatedBy } = useInput("");
  const { value: criteriaUpdatedBy, onChange: criteriaOnChangeUpdatedBy, setValue: criteriaSetUpdatedBy } = useInput("");
  const { value: criteriaCreatedDate, onChange: criteriaOnChangeCreatedDate, setValue: criteriaSetCreatedDate } = useInput("");
  const { value: criteriaUpdatedDate, onChange: criteriaOnChangeUpdatedDate, setValue: criteriaSetUpdatedDate } = useInput("");

  // FILTER OPERATORS
  const { value: operatorId, onChange: operatorOnChangeId, setValue: operatorSetId } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorName, onChange: operatorOnChangeName, setValue: operatorSetName } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorShortName, onChange: operatorOnChangeShortName, setValue: operatorSetShortName } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorStatus, onChange: operatorOnChangeStatus, setValue: operatorSetStatus } = useInput(enumCompareOperators.TEXT_EQUALS);
  const { value: operatorDescription, onChange: operatorOnChangeDescription, setValue: operatorSetDescription } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorTelephone, onChange: operatorOnChangeTelephone, setValue: operatorSetTelephone } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorAddress, onChange: operatorOnChangeAddress, setValue: operatorSetAddress } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorCreatedBy, onChange: operatorOnChangeCreatedBy, setValue: operatorSetCreatedBy } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorUpdatedBy, onChange: operatorOnChangeUpdatedBy, setValue: operatorSetUpdatedBy } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorCreatedDate, onChange: operatorOnChangeCreatedDate, setValue: operatorSetCreatedDate } = useInput(enumCompareOperators.DATE_EQUALS);
  const { value: operatorUpdatedDate, onChange: operatorOnChangeUpdatedDate, setValue: operatorSetUpdatedDate } = useInput(enumCompareOperators.DATE_EQUALS);

  const { arrayColumnsFilter, clearFilters, getFilterBody, arrayColumnsLabels, arrayDataFields } = tenantTableModels(
    columnsToShow,
    /* ID */ criteriaId, criteriaOnChangeId, criteriaSetId, operatorId, operatorOnChangeId, operatorSetId,
    /* NAME */ criteriaName, criteriaOnChangeName, criteriaSetName, operatorName, operatorOnChangeName, operatorSetName,
    /* SHORT NAME */ criteriaShortName, criteriaOnChangeShortName, criteriaSetShortName, operatorShortName, operatorOnChangeShortName, operatorSetShortName,
    /* STATUS */criteriaStatus, criteriaOnChangeStatus, criteriaSetStatus, operatorStatus, operatorOnChangeStatus, operatorSetStatus,
    /* DESCRIPTION */criteriaDescription, criteriaOnChangeDescription, criteriaSetDescription, operatorDescription, operatorOnChangeDescription, operatorSetDescription,
    /* TELEPHONE */criteriaTelephone, criteriaOnChangeTelephone, criteriaSetTelephone, operatorTelephone, operatorOnChangeTelephone, operatorSetTelephone,
    /* ADDRESS */criteriaAddress, criteriaOnChangeAddress, criteriaSetAddress, operatorAddress, operatorOnChangeAddress, operatorSetAddress,
    /* CREATED BY */criteriaCreatedBy, criteriaOnChangeCreatedBy, criteriaSetCreatedBy, operatorCreatedBy, operatorOnChangeCreatedBy, operatorSetCreatedBy,
    /* UPDATED BY */criteriaUpdatedBy, criteriaOnChangeUpdatedBy, criteriaSetUpdatedBy, operatorUpdatedBy, operatorOnChangeUpdatedBy, operatorSetUpdatedBy,
    /* CREATED DATE */criteriaCreatedDate, criteriaOnChangeCreatedDate, criteriaSetCreatedDate, operatorCreatedDate, operatorOnChangeCreatedDate, operatorSetCreatedDate,
    /* UPDATED DATE */criteriaUpdatedDate, criteriaOnChangeUpdatedDate, criteriaSetUpdatedDate, operatorUpdatedDate, operatorOnChangeUpdatedDate, operatorSetUpdatedDate
  );

  const fixArrayData = (data) => data.map((tenant) => tenant.status === "ACTIVE" ? { ...tenant, status: "ACTIVO" } : { ...tenant, status: "INACTIVO" });

  return (
    <TableFilterGeneric
      arrayColumns={arrayColumnsLabels}
      arrayDataFields={arrayDataFields}
      handleGetData={handleGetData}
      handleGetSize={handleGetSize}
      tableTitle={tableTitle}
      tableSubTitle={tableSubTitle}
      tableArrayCustomRowButtons={tableArrayCustomRowButtons}
      numberPagesToShow={numberPagesToShow}
      arrayColumnsFilter={arrayColumnsFilter}
      clearFilters={clearFilters}
      getFilterBody={getFilterBody}
      fixArrayData={fixArrayData}
    >
    </TableFilterGeneric>
  );
}

export default TenantGenericTable;

TenantGenericTable.propTypes = {
  numberPagesToShow: PropTypes.number,
  tableTitle: PropTypes.string,
  tableSubTitle: PropTypes.string,
  handleGetData: PropTypes.func,
  handleGetSize: PropTypes.func,
  tableArrayCustomRowButtons: PropTypes.array,
  columnsToShow: PropTypes.oneOf([
    enumTableColumnsToShow.FULL,
    enumTableColumnsToShow.MEDIUM,
    enumTableColumnsToShow.MINIMUM
  ])
};

TenantGenericTable.defaultProps = {
  numberPagesToShow: 0,
  tableTitle: "",
  tableSubTitle: undefined,
  handleGetData: () => { },
  handleGetSize: () => { },
  tableArrayCustomRowButtons: [],
  columnsToShow: enumTableColumnsToShow.FULL
};
