import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import UrbanismoTramiteTable from "../../components-level-2/alcaldia/UrbanismoTramiteTableEditDelete";

function UrbanismoTramiteTablePage () {
  return (
    <div className="table-page">
      <NavBar></NavBar>
      <UrbanismoTramiteTable></UrbanismoTramiteTable>
    </div>
  );
}

export default UrbanismoTramiteTablePage;
