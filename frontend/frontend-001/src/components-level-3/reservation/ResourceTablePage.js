import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import ResourceTable from "../../components-level-2/reservation/ResourceTableEditDelete";

function ResourceTablePage () {
  return (
    <div className="table-page">
      <NavBar></NavBar>
      <ResourceTable></ResourceTable>
    </div>
  );
}

export default ResourceTablePage;
