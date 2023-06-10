import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import TenantTableSelectForRole from "../../components-level-2/system/TenantTableSelectForRole";

function TenantTableSelectForRolePage () {
  return (
    <div className="tenants-table-page">
      <NavBar></NavBar>
      <TenantTableSelectForRole></TenantTableSelectForRole>
    </div>
  );
}

export default TenantTableSelectForRolePage;
