import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import RoleTableSelectForTenant from "../../components-level-2/users/RoleTableSelectForTenant";

function RoleTableSelectForTenantPage () {
  return (
    <div className="role-table-select-for-tenant-page">
      <NavBar></NavBar>
      <RoleTableSelectForTenant></RoleTableSelectForTenant>
    </div>
  );
}

export default RoleTableSelectForTenantPage;
