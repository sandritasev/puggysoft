import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import AlcaldiaRecursosMunicipalesVentasForm from "../../components-level-2/alcaldia/AlcaldiaRecursosMunicipalesVentasForm";

function AlcaldiaRecursosMunicipalesVentasFormPage () {
  return (
    <div className="form-page">
      <NavBar></NavBar>
      <AlcaldiaRecursosMunicipalesVentasForm/>
    </div>
  );
}

export default AlcaldiaRecursosMunicipalesVentasFormPage;
