import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import StorageRecordTableStepOne from "../../components-level-2/datastorage/StorageRecordTableStepOne";

function StorageRecordTableStepOnePage () {
  return (
    <div className="table-page">
      <NavBar></NavBar>
      <StorageRecordTableStepOne />
    </div>
  );
}

export default StorageRecordTableStepOnePage;
