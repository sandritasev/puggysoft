import React from "react";
import NavBar from "./../../components-level-2/navbar/NavBar";
import UserForm from "./../../components-level-2/users/UserForm";

function UserFormPage () {
  return (
    <div className="user-form-page">
      <NavBar></NavBar>
      <UserForm></UserForm>
    </div>
  );
}

export default UserFormPage;
