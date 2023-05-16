import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import TenantTableFilter from "./../../components-level-2/system/TenantTableFilter";

function TenantTableFilterPage () {
  return (
    <div className="tenants-table-page">
      <NavBar></NavBar>
      <TenantTableFilter></TenantTableFilter>
    </div>
  );
}

export default TenantTableFilterPage;
