import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import StorageRecordFormStepOne from "../../components-level-2/datastorage/StorageRecordFormStepOne";

function StorageRecordFormStepOnePage () {
  return (
    <div className="form-page">
      <NavBar></NavBar>
      <StorageRecordFormStepOne />
    </div>
  );
}

export default StorageRecordFormStepOnePage;
