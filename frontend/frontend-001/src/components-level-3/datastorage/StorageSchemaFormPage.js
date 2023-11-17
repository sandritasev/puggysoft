import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import StorageSchemaForm from "../../components-level-2/datastorage/StorageSchemaForm";

function StorageSchemaFormPage () {
  return (
    <div className="form-page">
      <NavBar></NavBar>
      <StorageSchemaForm />
    </div>
  );
}

export default StorageSchemaFormPage;
