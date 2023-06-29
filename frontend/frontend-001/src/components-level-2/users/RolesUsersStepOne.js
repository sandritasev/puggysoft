import React from "react";
import { useHistory } from "react-router";
import i18n from "../../i18n/i18n";
import enumPaths from "./../../models/enumPaths";
import { handleFilterRequest } from "../../actions/HandleManager";
import RoleGenericTable from "./generic/RoleGenericTable";
import enumTableColumnsToShow from "./../../models/system/enumTableColumnsToShow";

function RolesUsersStepOne () {
  const tableTitle = i18n.roleTable.title;
  const tableSubTitle = i18n.roleTable.subTitleSelect;
  const pageSize = 10;
  const numberPagesToShow = 10;

  const history = useHistory();

  const tenant = window.sessionStorage.getItem("tenant");

  function handleGetData (activePage, filterBody, updateArrayData) {
    handleFilterRequest(`roles/filter/with-tenants?page=${activePage - 1}&size=${pageSize}&tenant=${tenant}`, filterBody, updateArrayData);
  }

  function handleGetSize (filterBody, setTotalPages) {
    handleFilterRequest(`roles/filter/with-tenants/size?&pageSize=${pageSize}&tenant=${tenant}`, filterBody, setTotalPages);
  }

  function handleSelection (roleData) {
    history.push({
      pathname: enumPaths.ROLES_USERS_STEP_TWO,
      state: {
        data: roleData
      }
    });
  }

  const tableArrayCustomRowButtons = [
    {
      variant: "info",
      handleCustom: handleSelection,
      text: i18n.commonTable.selectButton
    }
  ];

  return (
    <RoleGenericTable
      tableTitle={tableTitle}
      tableSubTitle={tableSubTitle}
      numberPagesToShow={numberPagesToShow}
      handleGetData={handleGetData}
      handleGetSize={handleGetSize}
      tableArrayCustomRowButtons={tableArrayCustomRowButtons}
      columnsToShow={enumTableColumnsToShow.FULL}
    >
    </RoleGenericTable>
  );
}

export default RolesUsersStepOne;
