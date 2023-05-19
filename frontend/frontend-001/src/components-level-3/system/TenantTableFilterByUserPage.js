import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import TenantTableFilterByUsers from "../../components-level-2/system/TenantTableFilterByUsers";

function TenantTableFilterByUserPage () {
  return (
    <div className="tenants-table-filter-by-users-page">
      <NavBar></NavBar>
      <TenantTableFilterByUsers></TenantTableFilterByUsers>
    </div>
  );
}

export default TenantTableFilterByUserPage;
