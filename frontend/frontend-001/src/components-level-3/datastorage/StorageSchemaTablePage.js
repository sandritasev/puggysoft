import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import StorageSchemaTable from "../../components-level-2/datastorage/StorageSchemaTable";

function StorageSchemaTablePage () {
  return (
    <div className="table-page">
      <NavBar></NavBar>
      <StorageSchemaTable />
    </div>
  );
}

export default StorageSchemaTablePage;
