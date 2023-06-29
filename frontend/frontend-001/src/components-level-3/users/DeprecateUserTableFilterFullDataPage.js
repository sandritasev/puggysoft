import React from "react";
import NavBar from "./../../components-level-2/navbar/NavBar";
import DeprecateUserTableFilterFullData from "./../../components-level-2/users/DeprecateUserTableFilterFullData";
/** @deprecated */
function UserTableFilterFullDataPage () {
  return (
    <div className="users-table-page">
      <NavBar></NavBar>
      <DeprecateUserTableFilterFullData />
    </div>
  );
}

export default UserTableFilterFullDataPage;
