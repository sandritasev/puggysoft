import React from "react";
import { useHistory } from "react-router";
import i18n from "../../i18n/i18n";
import enumPaths from "../../models/enumPaths";
import { handleFilterRequest } from "../../actions/HandleManager";
import RoleGenericTable from "./generic/RoleGenericTable";
import enumTableColumnsToShow from "../../models/system/enumTableColumnsToShow";

function RoleTableSelectForTenant () {
  const tableTitle = i18n.roleTable.title;
  const pageSize = 10;
  const numberPagesToShow = 10;

  const history = useHistory();

  function handleGetData (activePage, filterBody, updateArrayData) {
    handleFilterRequest(`roles/filter?page=${activePage - 1}&size=${pageSize}`, filterBody, updateArrayData);
  }

  function handleGetSize (filterBody, setTotalPages) {
    handleFilterRequest(`roles/filter/size/${pageSize}`, filterBody, setTotalPages);
  }

  function handleSelection (roleData) {
    const afterSelectRoute = enumPaths.TENANTS_TABLE_FILTER_BY_ROLE;
    history.push({
      pathname: afterSelectRoute,
      state: {
        data: roleData
      }
    });
  }

  const tableArrayCustomRowButtons = [
    {
      variant: "info",
      handleCustom: handleSelection,
      text: i18n.roleTable.selectButton
    }
  ];

  return (
    <RoleGenericTable
      tableTitle={tableTitle}
      numberPagesToShow={numberPagesToShow}
      handleGetData={handleGetData}
      handleGetSize={handleGetSize}
      tableArrayCustomRowButtons={tableArrayCustomRowButtons}
      columnsToShow={enumTableColumnsToShow.FULL}
    >
    </RoleGenericTable>
  );
}

export default RoleTableSelectForTenant;
