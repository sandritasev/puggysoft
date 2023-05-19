import React from "react";
import PropTypes from "prop-types";
import TableFilterGeneric from "../generic/TableFilterGeneric";

import arrayDataFields from "../../models/users/arrayUserDataFieldsReduce";
import arrayColumnsDefault from "../../models/users/arrayUserColumnsReduce";
import getColumnsFilterModel from "../../models/users/arrayUserColumnsFilterReduced";

import enumCompareOperators from "../../models/enumCompareOperators";
import useInput from "../../hooks/useInput";

function UserTableSuperReducedGeneric (props) {
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
  const { value: criteriaUsername, onChange: criteriaOnChangeUsername, setValue: criteriaSetUsername } = useInput("");
  const { value: criteriaDni, onChange: criteriaOnChangeDni, setValue: criteriaSetDni } = useInput("");
  const { value: criteriaName, onChange: criteriaOnChangeName, setValue: criteriaSetName } = useInput("");
  const { value: criteriaLastName, onChange: criteriaOnChangeLastName, setValue: criteriaSetLastName } = useInput("");

  // FILTER OPERATORS
  const { value: operatorUsername, onChange: operatorOnChangeUsername, setValue: operatorSetUsername } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorDni, onChange: operatorOnChangeDni, setValue: operatorSetDni } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorName, onChange: operatorOnChangeName, setValue: operatorSetName } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorLastName, onChange: operatorOnChangeLastName, setValue: operatorSetLastName } = useInput(enumCompareOperators.TEXT_CONTAINS);

  const { arrayColumnsFilter, clearFilters, getFilterBody } = getColumnsFilterModel(
    /* USERNAME */ criteriaUsername, criteriaOnChangeUsername, criteriaSetUsername, operatorUsername, operatorOnChangeUsername, operatorSetUsername,
    /* DNI */ criteriaDni, criteriaOnChangeDni, criteriaSetDni, operatorDni, operatorOnChangeDni, operatorSetDni,
    /* NAME */ criteriaName, criteriaOnChangeName, criteriaSetName, operatorName, operatorOnChangeName, operatorSetName,
    /* LAST NAME */ criteriaLastName, criteriaOnChangeLastName, criteriaSetLastName, operatorLastName, operatorOnChangeLastName, operatorSetLastName
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

export default UserTableSuperReducedGeneric;

UserTableSuperReducedGeneric.propTypes = {
  handleGetData: PropTypes.func,
  handleGetSize: PropTypes.func,
  tableTitle: PropTypes.string,
  tableArrayCustomRowButtons: PropTypes.array,
  numberPagesToShow: PropTypes.number,
  fixArrayData: PropTypes.func,
  arrayColumns: PropTypes.array
};

UserTableSuperReducedGeneric.defaultProps = {
  handleGetData: () => { },
  handleGetSize: () => { },
  tableTitle: "",
  tableArrayCustomRowButtons: [],
  numberPagesToShow: 0,
  fixArrayData: undefined,
  arrayColumns: []
};
