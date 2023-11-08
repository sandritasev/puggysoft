import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import StorageFieldForm from "../../components-level-2/datastorage/StorageFieldForm";

function StorageFieldFormPage () {
  return (
    <div className="form-page">
      <NavBar></NavBar>
      <StorageFieldForm />
    </div>
  );
}

export default StorageFieldFormPage;
