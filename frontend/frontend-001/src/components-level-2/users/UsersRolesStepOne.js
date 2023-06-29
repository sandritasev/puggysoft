import React from "react";
import { useHistory } from "react-router";
import i18n from "../../i18n/i18n";
import enumPaths from "./../../models/enumPaths";
import { handleFilterRequest } from "../../actions/HandleManager";
import UserGenericTable from "./generic/UserGenericTable";
import enumTableColumnsToShow from "./../../models/system/enumTableColumnsToShow";

function UsersRolesStepOne () {
  const tableTitle = i18n.userTable.title;
  const tableSubTitle = i18n.userTable.subTitleSelect;
  const pageSize = 10;
  const numberPagesToShow = 10;
  const history = useHistory();
  const tenant = window.sessionStorage.getItem("tenant");

  function handleGetData (activePage, filterBody, updateArrayData) {
    handleFilterRequest(`users/filter/with-tenants?page=${activePage - 1}&size=${pageSize}&tenant=${tenant}`, filterBody, updateArrayData);
  }

  function handleGetSize (filterBody, setTotalPages) {
    handleFilterRequest(`users/filter/with-tenants/size?&pageSize=${pageSize}&tenant=${tenant}`, filterBody, setTotalPages);
  }

  function handleSelection (userData) {
    history.push({
      pathname: enumPaths.USERS_ROLES_STEP_TWO,
      state: {
        data: userData
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
    <UserGenericTable
      tableTitle={tableTitle}
      tableSubTitle={tableSubTitle}
      numberPagesToShow={numberPagesToShow}
      handleGetData={handleGetData}
      handleGetSize={handleGetSize}
      tableArrayCustomRowButtons={tableArrayCustomRowButtons}
      columnsToShow={enumTableColumnsToShow.MINIMUM}
    >
    </UserGenericTable>
  );
}

export default UsersRolesStepOne;
