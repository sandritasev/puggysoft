import React, { useHistory } from "react-router";
import UserGenericTable from "./generic/UserGenericTable";
import { handleFilterRequest } from "../../actions/HandleManager";
import enumPaths from "./../../models/enumPaths";
import i18n from "../../i18n/i18n";
import enumTableColumnsToShow from "../../models/enumTableColumnsToShow";

function UserTableFilterToDetailsOnlyTenant () {
  const pageSize = 10;
  const numberPagesToShow = 10;
  const tableTitle = i18n.userTable.titleEditDelete;
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
      pathname: enumPaths.USERS_DETAILS,
      state: {
        data: userData
      }
    });
  }

  const tableArrayCustomRowButtons = [
    {
      variant: "info",
      handleCustom: handleSelection,
      text: i18n.commonTable.detailsButton
    }
  ];

  return (
    <UserGenericTable
      handleGetData={handleGetData}
      handleGetSize={handleGetSize}
      tableTitle={tableTitle}
      tableArrayCustomRowButtons={tableArrayCustomRowButtons}
      numberPagesToShow={numberPagesToShow}
      columnsToShow={enumTableColumnsToShow.MEDIUM}
    >
    </UserGenericTable>
  );
}

export default UserTableFilterToDetailsOnlyTenant;
