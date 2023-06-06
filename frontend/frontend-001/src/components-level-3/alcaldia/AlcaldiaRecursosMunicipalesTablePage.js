import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import AlcaldiaRecursosMunicipalesTable from "../../components-level-2/alcaldia/AlcaldiaRecursosMunicipalesTableEditDelete";

function AlcaldiaRecursosMunicipalesTablePage () {
  return (
    <div className="table-page">
      <NavBar></NavBar>
      <AlcaldiaRecursosMunicipalesTable></AlcaldiaRecursosMunicipalesTable>
    </div>
  );
}

export default AlcaldiaRecursosMunicipalesTablePage;
