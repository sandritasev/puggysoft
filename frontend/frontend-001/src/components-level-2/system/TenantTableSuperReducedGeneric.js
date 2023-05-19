import React from "react";
import PropTypes from "prop-types";
import TableFilterGeneric from "../generic/TableFilterGeneric";

import arrayDataFields from "../../models/system/arrayTenantDataFieldsReduce";
import arrayColumnsDefault from "../../models/system/arrayTenantColumnsReduce";
import getColumnsFilterModel from "../../models/system/arrayTenantColumnsFilterReduced";

import enumCompareOperators from "../../models/enumCompareOperators";
import useInput from "../../hooks/useInput";

function TenantTableSuperReducedGeneric (props) {
  const {
    numberPagesToShow,
    tableTitle,
    handleGetData,
    handleGetSize,
    tableArrayCustomRowButtons,
    fixArrayData
  } = props;
  const arrayColumns = props.arrayColumns ? props.arrayColumns : arrayColumnsDefault;

  // CRITERIA OF SEARCH OR FILTER
  const { value: criteriaName, onChange: criteriaOnChangeName, setValue: criteriaSetName } = useInput("");
  const { value: criteriaShortName, onChange: criteriaOnChangeShortName, setValue: criteriaSetShortName } = useInput("");
  const { value: criteriaStatus, onChange: criteriaOnChangeStatus, setValue: criteriaSetStatus } = useInput("");
  const { value: criteriaDescription, onChange: criteriaOnChangeDescription, setValue: criteriaSetDescription } = useInput("");

  // FILTER OPERATORS
  const { value: operatorName, onChange: operatorOnChangeName, setValue: operatorSetName } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorShortName, onChange: operatorOnChangeShortName, setValue: operatorSetShortName } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorStatus, onChange: operatorOnChangeStatus, setValue: operatorSetStatus } = useInput(enumCompareOperators.TEXT_EQUALS);
  const { value: operatorDescription, onChange: operatorOnChangeDescription, setValue: operatorSetDescription } = useInput(enumCompareOperators.TEXT_CONTAINS);

  const { arrayColumnsFilter, clearFilters, getFilterBody } = getColumnsFilterModel(
    /* NAME */ criteriaName, criteriaOnChangeName, criteriaSetName, operatorName, operatorOnChangeName, operatorSetName,
    /* SHORT NAME */ criteriaShortName, criteriaOnChangeShortName, criteriaSetShortName, operatorShortName, operatorOnChangeShortName, operatorSetShortName,
    /* STATUS */ criteriaStatus, criteriaOnChangeStatus, criteriaSetStatus, operatorStatus, operatorOnChangeStatus, operatorSetStatus,
    /* DESCRIPTION */ criteriaDescription, criteriaOnChangeDescription, criteriaSetDescription, operatorDescription, operatorOnChangeDescription, operatorSetDescription
  );

  return (
    <TableFilterGeneric
      arrayColumns={arrayColumns}
      arrayDataFields={arrayDataFields}
      handleGetData={handleGetData}
      handleGetSize={handleGetSize}
      tableTitle={tableTitle}
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

export default TenantTableSuperReducedGeneric;

TenantTableSuperReducedGeneric.propTypes = {
  handleGetData: PropTypes.func,
  handleGetSize: PropTypes.func,
  tableTitle: PropTypes.string,
  tableArrayCustomRowButtons: PropTypes.array,
  numberPagesToShow: PropTypes.number,
  fixArrayData: PropTypes.func,
  arrayColumns: PropTypes.array
};

TenantTableSuperReducedGeneric.defaultProps = {
  handleGetData: () => { },
  handleGetSize: () => { },
  tableTitle: "",
  tableArrayCustomRowButtons: [],
  numberPagesToShow: 0,
  fixArrayData: undefined,
  arrayColumns: []
};
