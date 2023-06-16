import React, { useHistory } from "react-router";
import UserGenericTable from "./generic/UserGenericTable";
import { handleFilterRequest, handleDeleteRequest } from "../../actions/HandleManager";
import enumPaths from "./../../models/enumPaths";
import enumTableColumnsToShow from "../../models/enumTableColumnsToShow";
import i18n from "../../i18n/i18n";

function UserTableFilterEditDeleteOnlyTenant () {
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

  function handleEdit (data) {
    history.push({
      pathname: enumPaths.USERS_FORM,
      state: {
        data,
        edit: true
      }
    });
  }

  function handleDelete (data) {
    handleDeleteRequest(`users/${data.id}`, undefined, undefined, undefined, true);
  }

  const tableArrayCustomRowButtons = [
    {
      variant: "warning",
      handleCustom: handleEdit,
      text: i18n.commonTable.editButton
    },
    {
      variant: "danger",
      handleCustom: handleDelete,
      text: i18n.commonTable.deleteButton
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

export default UserTableFilterEditDeleteOnlyTenant;
