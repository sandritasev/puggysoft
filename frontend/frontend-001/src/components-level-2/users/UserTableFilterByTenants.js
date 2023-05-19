import React, { useState } from "react";
import { useHistory } from "react-router";

import { handleFilterRequest, handleAddRequest, handleDeleteRequest } from "../../actions/HandleManager";
import UserTableSuperReducedGeneric from "./UserTableSuperReducedGeneric";
import i18n from "../../i18n/i18n";
import CommonLoading from "../../components-level-1/CommonLoading";
// import CommonMessage from "./../../components-level-1/CommonMessage";
import arrayColumns from "../../models/users/arrayUserColumnsReduce";

import "./../css/all-two-divs-side-by-side.css";
import "./../css/all-six-divs-side-by-side.css";
import "./../css/all-forms-inline-block.css";
import "./user-table-filter-by-role.css";

function UserTableFilterByTenants () {
  const history = useHistory();
  const pageSize = 10;
  const numberPagesToShow = 10;

  const routerProps = history && history.location && history.location.state;
  const tenantSelected = routerProps.data;
  const tableTitleAddUsersToTenant = `${i18n.tenantUserTableByTenant.titleAddUsers} ${tenantSelected.shortName}`;
  const tableTitleDeleteUsersFromTenant = `${i18n.tenantUserTableByTenant.titleRemoveUsers} ${tenantSelected.shortName}`;
  // Message states.

  const [isRequestInProgress, setIsRequestInProgress] = useState(false);

  // functions to add users to a tenant.
  function handleGetDataUsersWithTenant (activePage, filterBody, updateArrayData) {
    handleFilterRequest(`users/filter/with-tenants?page=${activePage - 1}&size=${pageSize}&tenant=${tenantSelected.shortName}`, filterBody, updateArrayData);
  }
  function handleGetSizeUsersWithTenant (filterBody, setTotalPages) {
    handleFilterRequest(`users/filter/with-tenants/size?&pageSize=${pageSize}&tenant=${tenantSelected.shortName}`, filterBody, setTotalPages);
  }

  /* - dataElement.onChange
  - dataElement.value */

  // functions to delete users from a tenant.
  function handleGetDataUsersWithOutTenant (activePage, filterBody, updateArrayData) {
    handleFilterRequest(`users/filter/without-tenants?page=${activePage - 1}&size=${pageSize}&tenant=${tenantSelected.shortName}`, filterBody, updateArrayData);
  }
  function handleGetSizeUsersWithOutTenant (filterBody, setTotalPages) {
    handleFilterRequest(`users/filter/without-tenants/size?&pageSize=${pageSize}&tenant=${tenantSelected.shortName}`, filterBody, setTotalPages);
  }

  function handleAfterDeleteOrCreateUser () {
    setIsRequestInProgress(false);
  }

  function handleDeleteTenantUserRelation (userData) {
    setIsRequestInProgress(true);
    const usernameRelation = userData.username;
    handleDeleteRequest(`tenants-users?username=${usernameRelation}&tenant=${tenantSelected.shortName}`, handleAfterDeleteOrCreateUser, handleAfterDeleteOrCreateUser);
  }

  function handleCreateTenantUserRelation (userData) {
    setIsRequestInProgress(true);
    const createdBy = window.sessionStorage.getItem("username");
    const body = {
      username: userData.username,
      tenant: tenantSelected.shortName,
      createdBy
    };
    handleAddRequest("tenants-users", body, handleAfterDeleteOrCreateUser);
  }

  const tableArrayCustomRowButtonsAddToUser = [
    {
      variant: "primary",
      handleCustom: handleCreateTenantUserRelation,
      text: i18n.tenantUserTableByTenant.addButton
    }
  ];

  const tableArrayCustomRowButtonsDeleteToUser = [
    {
      variant: "danger",
      handleCustom: handleDeleteTenantUserRelation,
      text: i18n.tenantUserTableByTenant.removeButton
    }
  ];

  if (isRequestInProgress) {
    return <CommonLoading />;
  }

  return (
    <div>
      <div className="puggysoft-two-divs-side-by-side-child">
        <UserTableSuperReducedGeneric
          tableTitle={tableTitleAddUsersToTenant}
          handleGetData={handleGetDataUsersWithOutTenant}
          handleGetSize={handleGetSizeUsersWithOutTenant}
          tableArrayCustomRowButtons={tableArrayCustomRowButtonsAddToUser}
          arrayColumns={arrayColumns}
          numberPagesToShow={numberPagesToShow}
        >
        </UserTableSuperReducedGeneric>
      </div>
      <div className="puggysoft-two-divs-side-by-side-child">
        <UserTableSuperReducedGeneric
          tableTitle={tableTitleDeleteUsersFromTenant}
          handleGetData={handleGetDataUsersWithTenant}
          handleGetSize={handleGetSizeUsersWithTenant}
          tableArrayCustomRowButtons={tableArrayCustomRowButtonsDeleteToUser}
          numberPagesToShow={numberPagesToShow}
          arrayColumns={arrayColumns}
        >
        </UserTableSuperReducedGeneric>
      </div>
    </div >
  );
}

export default UserTableFilterByTenants;
