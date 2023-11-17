import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import StorageFieldTable from "../../components-level-2/datastorage/StorageFieldTable";

function StorageFieldTablePage () {
  return (
    <div className="table-page">
      <NavBar></NavBar>
      <StorageFieldTable />
    </div>
  );
}

export default StorageFieldTablePage;
