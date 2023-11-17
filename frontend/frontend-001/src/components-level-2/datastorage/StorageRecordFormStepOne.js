import React from "react";
import { useHistory } from "react-router";
import i18n from "../../i18n/i18n";
import enumPaths from "../../models/enumPaths";
import { handleFilterRequest } from "../../actions/HandleManager";
import StorageSchemaGenericTable from "./generic/StorageSchemaGenericTable";
import enumTableColumnsToShow from "../../models/enumTableColumnsToShow";

function StorageSchemaTable () {
  const tableTitle = i18n.datastorage.recordFormTitleStepOne;
  const tableSubTitle = i18n.datastorage.recordSubTitle;
  const pageSize = 7;
  const numberPagesToShow = 7;

  const history = useHistory();

  function handleGetData (activePage, filterBody, updateArrayData) {
    handleFilterRequest(`storage-schema/filter?page=${activePage - 1}&size=${pageSize}`, filterBody, updateArrayData);
  }

  function handleGetSize (filterBody, setTotalPages) {
    handleFilterRequest(`storage-schema/filter/size/${pageSize}`, filterBody, setTotalPages);
  }

  function handleNavigate (data) {
    history.push({
      pathname: enumPaths.DATA_STORAGE_RECORD_FORM_STEP_TWO,
      state: { schemaSelected: data }
    });
  }

  const tableArrayCustomRowButtons = [
    {
      variant: "primary",
      handleCustom: handleNavigate,
      text: i18n.commonTable.selectButton
    }
  ];

  return (
    <StorageSchemaGenericTable
      tableTitle={tableTitle}
      tableSubTitle={tableSubTitle}
      numberPagesToShow={numberPagesToShow}
      handleGetData={handleGetData}
      handleGetSize={handleGetSize}
      tableArrayCustomRowButtons={tableArrayCustomRowButtons}
      columnsToShow={enumTableColumnsToShow.MEDIUM}
    >
    </StorageSchemaGenericTable>
  );
}

export default StorageSchemaTable;
