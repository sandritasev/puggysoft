import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import TenantTableEditDelete from "./../../components-level-2/system/TenantTableEditDelete";

function TenantTableFilterEditDeletePage () {
  return (
    <div className="tenants-table-page">
      <NavBar></NavBar>
      <TenantTableEditDelete></TenantTableEditDelete>
    </div>
  );
}

export default TenantTableFilterEditDeletePage;
