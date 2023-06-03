import React, { useState } from "react";
import { useHistory } from "react-router";

import { handleFilterRequest, handleAddRequest, handleDeleteRequest } from "../../actions/HandleManager";
import TenantTableSuperReducedGeneric from "./TenantTableSuperReducedGeneric";
import i18n from "../../i18n/i18n";
import CommonLoading from "../../components-level-1/CommonLoading";
import arrayColumns from "../../models/system/arrayTenantColumnsReduce";

import "./../css/all-two-divs-side-by-side.css";
import "./../css/all-six-divs-side-by-side.css";
import "./../css/all-forms-inline-block.css";
import "./tenant-table-filter-by-user.css";

function TenantTableFilterByUsers () {
  const history = useHistory();
  const pageSize = 10;
  const numberPagesToShow = 10;

  const routerProps = history && history.location && history.location.state;
  const userSelected = routerProps.data;
  const tableTitleAddUsersToTenant = `${i18n.tenantUserTableByUser.titleAddUsers} ${userSelected.username}`;
  const tableTitleDeleteUsersFromTenant = `${i18n.tenantUserTableByUser.titleRemoveUsers} ${userSelected.username}`;
  const [isRequestInProgress, setIsRequestInProgress] = useState(false);

  // functions to add users to a tenant.
  function handleGetDataTenantsWithUser (activePage, filterBody, updateArrayData) {
    handleFilterRequest(`tenants/filter/with-users?page=${activePage - 1}&size=${pageSize}&username=${userSelected.username}`, filterBody, updateArrayData);
  }
  function handleGetSizeTenantsWithUser (filterBody, setTotalPages) {
    handleFilterRequest(`tenants/filter/with-users/size?&pageSize=${pageSize}&username=${userSelected.username}`, filterBody, setTotalPages);
  }

  // functions to delete users from a tenant.
  function handleGetDataTenantsWithOutUser (activePage, filterBody, updateArrayData) {
    handleFilterRequest(`tenants/filter/without-users?page=${activePage - 1}&size=${pageSize}&username=${userSelected.username}`, filterBody, updateArrayData);
  }
  function handleGetSizeTenantsWithOutUser (filterBody, setTotalPages) {
    handleFilterRequest(`tenants/filter/without-users/size?&pageSize=${pageSize}&username=${userSelected.username}`, filterBody, setTotalPages);
  }

  function handleAfterDeleteOrCreateUser () {
    setIsRequestInProgress(false);
  }

  function handleDeleteTenantUserRelation (tenantData) {
    setIsRequestInProgress(true);
    const shortNameRelation = tenantData.shortName;
    handleDeleteRequest(`tenants-users?username=${userSelected.username}&tenant=${shortNameRelation}`, handleAfterDeleteOrCreateUser, handleAfterDeleteOrCreateUser);
  }

  function handleCreateTenantUserRelation (tenantData) {
    setIsRequestInProgress(true);
    const createdBy = window.sessionStorage.getItem("username");
    const body = {
      username: userSelected.username,
      tenant: tenantData.shortName,
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
        <TenantTableSuperReducedGeneric
          tableTitle={tableTitleAddUsersToTenant}
          handleGetData={handleGetDataTenantsWithOutUser}
          handleGetSize={handleGetSizeTenantsWithOutUser}
          tableArrayCustomRowButtons={tableArrayCustomRowButtonsAddToUser}
          arrayColumns={arrayColumns}
          numberPagesToShow={numberPagesToShow}
        >
        </TenantTableSuperReducedGeneric>
      </div>
      <div className="puggysoft-two-divs-side-by-side-child">
        <TenantTableSuperReducedGeneric
          tableTitle={tableTitleDeleteUsersFromTenant}
          handleGetData={handleGetDataTenantsWithUser}
          handleGetSize={handleGetSizeTenantsWithUser}
          tableArrayCustomRowButtons={tableArrayCustomRowButtonsDeleteToUser}
          numberPagesToShow={numberPagesToShow}
          arrayColumns={arrayColumns}
        >
        </TenantTableSuperReducedGeneric>
      </div>
    </div >
  );
}

export default TenantTableFilterByUsers;
