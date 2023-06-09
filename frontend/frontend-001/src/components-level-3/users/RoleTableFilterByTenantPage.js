import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import RoleTableFilterByTenant from "../../components-level-2/users/RoleTableFilterByTenant";

function RoleTableFilterByTenantPage () {
  return (
    <div className="role-table-select-for-tenant-page">
      <NavBar></NavBar>
      <RoleTableFilterByTenant></RoleTableFilterByTenant>
    </div>
  );
}

export default RoleTableFilterByTenantPage;
