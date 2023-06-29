import React from "react";
import NavBar from "./../../components-level-2/navbar/NavBar";
import UserFormGenericByTenant from "./../../components-level-2/users/UserFormGenericByTenant";

function UserFormPage () {
  return (
    <div className="user-tenant-form-page">
      <NavBar />
      <UserFormGenericByTenant />
    </div>
  );
}

export default UserFormPage;
