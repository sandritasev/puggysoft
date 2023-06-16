import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import UrbanismoRequisitosTable from "../../components-level-2/alcaldia/UrbanismoRequisitosTableEditDelete";

function UrbanismoRequisitosTablePage () {
  return (
    <div className="table-page">
      <NavBar></NavBar>
      <UrbanismoRequisitosTable></UrbanismoRequisitosTable>
    </div>
  );
}

export default UrbanismoRequisitosTablePage;
