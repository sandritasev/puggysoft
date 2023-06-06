import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import AlcaldiaRecursosMunicipalesVentasTable from "../../components-level-2/alcaldia/AlcaldiaRecursosMunicipalesVentasTableEditDelete";

function AlcaldiaRecursosMunicipalesVentasTablePage () {
  return (
    <div className="table-page">
      <NavBar></NavBar>
      <AlcaldiaRecursosMunicipalesVentasTable/>
    </div>
  );
}

export default AlcaldiaRecursosMunicipalesVentasTablePage;
