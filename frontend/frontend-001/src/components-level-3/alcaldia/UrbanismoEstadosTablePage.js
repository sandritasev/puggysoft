import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import UrbanismoEstadosTable from "../../components-level-2/alcaldia/UrbanismoEstadosTableEditDelete";

function UrbanismoEstadosTablePage () {
  return (
    <div className="table-page">
      <NavBar></NavBar>
      <UrbanismoEstadosTable></UrbanismoEstadosTable>
    </div>
  );
}

export default UrbanismoEstadosTablePage;
