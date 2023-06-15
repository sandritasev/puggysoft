import React from "react";
import { useHistory } from "react-router";
import i18n from "../../i18n/i18n";
import enumPaths from "../../models/enumPaths";
import { handleFilterRequest } from "../../actions/HandleManager";
import TenantGenericTable from "./generic/TenantGenericTable";
import enumTableColumnsToShow from "../../models/system/enumTableColumnsToShow";

function TenantTableSelectForRole () {
  const tableTitle = i18n.tenantTable.title;
  const pageSize = 10;
  const numberPagesToShow = 10;

  const history = useHistory();

  function handleGetData (activePage, filterBody, updateArrayData) {
    handleFilterRequest(`tenants/filter?page=${activePage - 1}&size=${pageSize}`, filterBody, updateArrayData);
  }

  function handleGetSize (filterBody, setTotalPages) {
    handleFilterRequest(`tenants/filter/size/${pageSize}`, filterBody, setTotalPages);
  }

  function handleSelection (tenantData) {
    const afterSelectRoute = enumPaths.ROLES_TABLE_FILTER_BY_TENANT;
    history.push({
      pathname: afterSelectRoute,
      state: {
        data: tenantData
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
    <TenantGenericTable
      tableTitle={tableTitle}
      numberPagesToShow={numberPagesToShow}
      handleGetData={handleGetData}
      handleGetSize={handleGetSize}
      tableArrayCustomRowButtons={tableArrayCustomRowButtons}
      columnsToShow={enumTableColumnsToShow.MEDIUM}
    >
    </TenantGenericTable>
  );
}

export default TenantTableSelectForRole;
