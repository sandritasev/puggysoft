import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import TenantTableFilterByRole from "../../components-level-2/system/TenantTableFilterByRole";

function TenantTableFilterByRolePage () {
  return (
    <div className="tenants-table-page">
      <NavBar></NavBar>
      <TenantTableFilterByRole></TenantTableFilterByRole>
    </div>
  );
}

export default TenantTableFilterByRolePage;
