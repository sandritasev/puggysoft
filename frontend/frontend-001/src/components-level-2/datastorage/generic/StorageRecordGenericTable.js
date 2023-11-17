import React, {
  useEffect,
  useState
} from "react";
import PropTypes from "prop-types";
import TableFilterGeneric from "../../generic/TableFilterGeneric";
import enumTableColumnsToShow from "../../../models/enumTableColumnsToShow";
import { handleGetRequest } from "../../../actions/HandleManager";
import CommonLoading from "../../../components-level-1/CommonLoading";
// import convertInputTypeToFilterType from "../../../tools/convertInputTypeToFilterType";
import convertInputTypeToCompareOperator from "../../../tools/convertInputTypeToCompareOperator";
import enumFilterType from "./../../../models/enumFilterType";

function StorageRecordGenericTable (props) {
  const {
    numberPagesToShow,
    tableTitle,
    tableSubTitle,
    handleGetData,
    handleGetSize,
    tableArrayCustomRowButtons,
    // columnsToShow,
    fixArrayData,
    schemaSelected
  } = props;

  const [isRequestInProgress, setIsRequestInProgress] = useState(false);
  const [arrayColumnsLabels, setArrayColumnsLabels] = useState(null);
  const [arrayDataFields, setArrayDataFields] = useState(null);
  const [arrayColumnsFilter, setArrayColumnsFilter] = useState(null);

  useEffect(() => {
    // Get all fields that belongs to schema
    if (schemaSelected) {
      setIsRequestInProgress(true);
      handleGetRequest(`storage-field-by-schema?schemaShortName=${schemaSelected.shortName}`,
        afterSuccessGetAllFields,
        () => { }, // showErrorMessage
        false
      );
    }
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  function getFilterBody () {
    // Here add filter body to record;
  }

  function criteriaOnChange (event) {
    // Here update arrayColumnsFilter;
  }

  function operatorOnChange (event) {
    // Here update arrayColumnsFilter;
  }

  function clearFilters () {
    // Here update arrayColumnsFilter;
  }

  const afterSuccessGetAllFields = function (arrayOfFieldsData) {
    const newArrayDataFields = [];
    const newArrayColumnsLabels = [];
    const newArrayColumnsFilter = [];
    arrayOfFieldsData.forEach((itemField) => {
      // itemField.type
      // itemField.textboxOption
      newArrayDataFields.push(itemField.shortName);
      newArrayColumnsLabels.push(itemField.name);
      newArrayColumnsFilter.push({
        type: enumFilterType.NONE, // convertInputTypeToFilterType(itemField.type),
        criteriaValue: "",
        criteriaOnchange: criteriaOnChange,
        operatorValue: convertInputTypeToCompareOperator(itemField.type),
        operatorOnchange: operatorOnChange
      });
    });
    setArrayDataFields(newArrayDataFields);
    setArrayColumnsLabels(newArrayColumnsLabels);
    setArrayColumnsFilter(newArrayColumnsFilter);
    setIsRequestInProgress(false);
  };

  if (isRequestInProgress ||
    !arrayDataFields ||
    !arrayColumnsLabels ||
    !arrayColumnsFilter
  ) {
    return <CommonLoading />;
  }

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

export default StorageRecordGenericTable;

StorageRecordGenericTable.propTypes = {
  numberPagesToShow: PropTypes.number,
  tableTitle: PropTypes.string,
  tableSubTitle: PropTypes.string,
  handleGetData: PropTypes.func,
  handleGetSize: PropTypes.func,
  tableArrayCustomRowButtons: PropTypes.array,
  columnsToShow: PropTypes.oneOf([
    enumTableColumnsToShow.FULL,
    enumTableColumnsToShow.MEDIUM
  ]),
  fixArrayData: PropTypes.func,
  schemaSelected: PropTypes.object
};

StorageRecordGenericTable.defaultProps = {
  numberPagesToShow: 0,
  tableTitle: "",
  tableSubTitle: undefined,
  handleGetData: () => { },
  handleGetSize: () => { },
  tableArrayCustomRowButtons: [],
  columnsToShow: enumTableColumnsToShow.FULL,
  fixArrayData: undefined,
  schemaSelected: undefined
};
