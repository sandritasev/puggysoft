import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import UserTableFilterEditDeleteOnlyTenant from "../../components-level-2/users/UserTableFilterEditDeleteOnlyTenant";

function UserTableFilterEditDeleteOnlyTenantPage () {
  return (
    <div className="users-table-filter-by-tenants-page">
      <NavBar></NavBar>
      <UserTableFilterEditDeleteOnlyTenant />
    </div>
  );
}

export default UserTableFilterEditDeleteOnlyTenantPage;
