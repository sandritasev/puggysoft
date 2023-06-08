import React, { useState } from "react";
import { useHistory } from "react-router";

import { handleFilterRequest, handleAddRequest, handleDeleteRequest } from "../../actions/HandleManager";
import i18n from "../../i18n/i18n";
import CommonLoading from "../../components-level-1/CommonLoading";
import TenantGenericTable from "./generic/TenantGenericTable";
import enumTableColumnsToShow from "./../../models/system/enumTableColumnsToShow";

import "./../css/all-two-divs-side-by-side.css";
import "./../css/all-six-divs-side-by-side.css";
import "./../css/all-forms-inline-block.css";
import "./tenant-table-filter-by-user.css";

function TenantTableFilterByRole () {
  const history = useHistory();
  const pageSize = 10;
  const numberPagesToShow = 10;

  const routerProps = history && history.location && history.location.state;
  const roleSelected = routerProps.data;
  const tableTitleAddTenantToRoles = `${i18n.tenantRoleTableByRole.titleAddTenants} ${roleSelected.name}`;
  const tableTitleDeleteTenantFromRoles = `${i18n.tenantRoleTableByRole.titleRemoveTenants} ${roleSelected.name}`;
  // Message states.

  const [isRequestInProgress, setIsRequestInProgress] = useState(false);

  // functions to add roles to a tenant.
  function handleGetDataTenantsWithRole (activePage, filterBody, updateArrayData) {
    handleFilterRequest(`tenants/filter/with-roles?page=${activePage - 1}&size=${pageSize}&role=${roleSelected.name}`, filterBody, updateArrayData);
  }
  function handleGetSizeTenantsWithRole (filterBody, setTotalPages) {
    handleFilterRequest(`tenants/filter/with-roles/size?&pageSize=${pageSize}&role=${roleSelected.name}`, filterBody, setTotalPages);
  }

  /* - dataElement.onChange
  - dataElement.value */

  // functions to delete roles from a tenant.
  function handleGetDataTenantsWithOutRole (activePage, filterBody, updateArrayData) {
    handleFilterRequest(`tenants/filter/without-roles?page=${activePage - 1}&size=${pageSize}&role=${roleSelected.name}`, filterBody, updateArrayData);
  }
  function handleGetSizeTenantsWithOutRole (filterBody, setTotalPages) {
    handleFilterRequest(`tenants/filter/without-roles/size?&pageSize=${pageSize}&role=${roleSelected.name}`, filterBody, setTotalPages);
  }

  function handleAfterDeleteOrCreateRole () {
    setIsRequestInProgress(false);
  }

  function handleDeleteTenantRoleRelation (tenantData) {
    setIsRequestInProgress(true);
    const shortNameRelation = tenantData.shortName;
    handleDeleteRequest(`tenants-roles?role=${roleSelected.name}&tenant=${shortNameRelation}`, handleAfterDeleteOrCreateRole, handleAfterDeleteOrCreateRole);
  }

  function handleCreateTenantRoleRelation (tenantData) {
    setIsRequestInProgress(true);
    const createdBy = window.sessionStorage.getItem("username");
    const body = {
      role: roleSelected.name,
      tenant: tenantData.shortName,
      createdBy
    };
    handleAddRequest("tenants-roles", body, handleAfterDeleteOrCreateRole);
  }

  const tableArrayCustomRowButtonsAddToTenant = [
    {
      variant: "primary",
      handleCustom: handleCreateTenantRoleRelation,
      text: i18n.tenantRoleTableByRole.addButton
    }
  ];

  const tableArrayCustomRowButtonsDeleteToTenant = [
    {
      variant: "danger",
      handleCustom: handleDeleteTenantRoleRelation,
      text: i18n.tenantRoleTableByRole.removeButton
    }
  ];

  if (isRequestInProgress) {
    return <CommonLoading />;
  }

  return (
    <div>
      <div className="puggysoft-two-divs-side-by-side-child">
        <TenantGenericTable
          tableTitle={tableTitleAddTenantToRoles}
          handleGetData={handleGetDataTenantsWithOutRole}
          handleGetSize={handleGetSizeTenantsWithOutRole}
          tableArrayCustomRowButtons={tableArrayCustomRowButtonsAddToTenant}
          numberPagesToShow={numberPagesToShow}
          columnsToShow={enumTableColumnsToShow.MINIMUM}
        >
        </TenantGenericTable>
      </div>
      <div className="puggysoft-two-divs-side-by-side-child">
        <TenantGenericTable
          tableTitle={tableTitleDeleteTenantFromRoles}
          handleGetData={handleGetDataTenantsWithRole}
          handleGetSize={handleGetSizeTenantsWithRole}
          tableArrayCustomRowButtons={tableArrayCustomRowButtonsDeleteToTenant}
          numberPagesToShow={numberPagesToShow}
          columnsToShow={enumTableColumnsToShow.MINIMUM}
        >
        </TenantGenericTable>
      </div>
    </div >
  );
}

export default TenantTableFilterByRole;
