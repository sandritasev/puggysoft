import React, { useState } from "react";
import { useHistory } from "react-router";

import { handleFilterRequest, handleAddRequest, handleDeleteRequest } from "../../actions/HandleManager";
import i18n from "../../i18n/i18n";
import CommonLoading from "../../components-level-1/CommonLoading";
import RoleGenericTable from "./generic/RoleGenericTable";
import enumTableColumnsToShow from "./../../models/system/enumTableColumnsToShow";

import "./../css/all-two-divs-side-by-side.css";
import "./../css/all-six-divs-side-by-side.css";
import "./../css/all-forms-inline-block.css";
import "./role-table-filter-by-user.css";

function RoleTableFilterByTenant () {
  const history = useHistory();
  const pageSize = 10;
  const numberPagesToShow = 10;

  const routerProps = history && history.location && history.location.state;
  const tenantSelected = routerProps.data;
  const tableTitleAddRolesToTenant = `${i18n.tenantRoleTableByTenant.titleAddRoles} ${tenantSelected.shortName}`;
  const tableTitleDeleteRolesFromTenant = `${i18n.tenantRoleTableByTenant.titleRemoveRoles} ${tenantSelected.shortName}`;
  // Message states.

  const [isRequestInProgress, setIsRequestInProgress] = useState(false);

  // functions to add roles to a tenant.
  function handleGetDataRolesWithTenant (activePage, filterBody, updateArrayData) {
    handleFilterRequest(`roles/filter/with-tenants?page=${activePage - 1}&size=${pageSize}&tenant=${tenantSelected.shortName}`, filterBody, updateArrayData);
  }
  function handleGetSizeRolesWithTenant (filterBody, setTotalPages) {
    handleFilterRequest(`roles/filter/with-tenants/size?&pageSize=${pageSize}&tenant=${tenantSelected.shortName}`, filterBody, setTotalPages);
  }

  /* - dataElement.onChange
  - dataElement.value */

  // functions to delete roles from a tenant.
  function handleGetDataRolesWithOutTenant (activePage, filterBody, updateArrayData) {
    handleFilterRequest(`roles/filter/without-tenants?page=${activePage - 1}&size=${pageSize}&tenant=${tenantSelected.shortName}`, filterBody, updateArrayData);
  }
  function handleGetSizeRolesWithOutTenant (filterBody, setTotalPages) {
    handleFilterRequest(`roles/filter/without-tenants/size?&pageSize=${pageSize}&tenant=${tenantSelected.shortName}`, filterBody, setTotalPages);
  }

  function handleAfterDeleteOrCreateRole () {
    setIsRequestInProgress(false);
  }

  function handleDeleteTenantRoleRelation (roleData) {
    setIsRequestInProgress(true);
    const nameRelation = roleData.name;
    handleDeleteRequest(`tenants-roles?role=${nameRelation}&tenant=${tenantSelected.shortName}`, handleAfterDeleteOrCreateRole, handleAfterDeleteOrCreateRole);
  }

  function handleCreateTenantRoleRelation (roleData) {
    setIsRequestInProgress(true);
    const createdBy = window.sessionStorage.getItem("username");
    const body = {
      tenant: tenantSelected.shortName,
      role: roleData.name,
      createdBy
    };
    handleAddRequest("tenants-roles", body, handleAfterDeleteOrCreateRole);
  }

  const tableArrayCustomRowButtonsAddToRole = [
    {
      variant: "primary",
      handleCustom: handleCreateTenantRoleRelation,
      text: i18n.tenantRoleTableByTenant.addButton
    }
  ];

  const tableArrayCustomRowButtonsDeleteToRole = [
    {
      variant: "danger",
      handleCustom: handleDeleteTenantRoleRelation,
      text: i18n.tenantRoleTableByTenant.removeButton
    }
  ];

  if (isRequestInProgress) {
    return <CommonLoading />;
  }

  return (
    <div>
      <div className="puggysoft-two-divs-side-by-side-child">
        <RoleGenericTable
          tableTitle={tableTitleAddRolesToTenant}
          handleGetData={handleGetDataRolesWithOutTenant}
          handleGetSize={handleGetSizeRolesWithOutTenant}
          tableArrayCustomRowButtons={tableArrayCustomRowButtonsAddToRole}
          numberPagesToShow={numberPagesToShow}
          columnsToShow={enumTableColumnsToShow.MINIMUM}
        >
        </RoleGenericTable>
      </div>
      <div className="puggysoft-two-divs-side-by-side-child">
        <RoleGenericTable
          tableTitle={tableTitleDeleteRolesFromTenant}
          handleGetData={handleGetDataRolesWithTenant}
          handleGetSize={handleGetSizeRolesWithTenant}
          tableArrayCustomRowButtons={tableArrayCustomRowButtonsDeleteToRole}
          numberPagesToShow={numberPagesToShow}
          columnsToShow={enumTableColumnsToShow.MINIMUM}
        >
        </RoleGenericTable>
      </div>
    </div >
  );
}

export default RoleTableFilterByTenant;
