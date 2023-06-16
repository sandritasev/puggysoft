import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import UserTableFilterToDetailsOnlyTenant from "../../components-level-2/users/UserTableFilterToDetailsOnlyTenant";

function UserTableFilterToDetailsOnlyTenantPage () {
  return (
    <div className="users-table-filter-by-tenants-page">
      <NavBar></NavBar>
      <UserTableFilterToDetailsOnlyTenant />
    </div>
  );
}

export default UserTableFilterToDetailsOnlyTenantPage;
