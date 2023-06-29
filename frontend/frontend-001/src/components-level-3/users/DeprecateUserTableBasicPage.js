import React from "react";
import NavBar from "./../../components-level-2/navbar/NavBar";
import DeprecateUserTableBasic from "./../../components-level-2/users/DeprecateUserTableBasic";
/** @deprecated */
function UserTableBasicPage () {
  return (
    <div className="users-table-page">
      <NavBar></NavBar>
      <DeprecateUserTableBasic></DeprecateUserTableBasic>
    </div>
  );
}

export default UserTableBasicPage;
