import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import UserTableFilterByTenants from "../../components-level-2/users/UserTableFilterByTenants";

function UserTableFilterByTenantPage () {
  return (
    <div className="users-table-filter-by-tenants-page">
      <NavBar></NavBar>
      <UserTableFilterByTenants></UserTableFilterByTenants>
    </div>
  );
}

export default UserTableFilterByTenantPage;
