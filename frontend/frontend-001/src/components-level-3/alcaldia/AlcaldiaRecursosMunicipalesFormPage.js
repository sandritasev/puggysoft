import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import AlcaldiaRecursosMunicipalesForm from "./../../components-level-2/alcaldia/AlcaldiaRecursosMunicipalesForm";

function AlcaldiaRecursosMunicipalesFormPage () {
  return (
    <div className="form-page">
      <NavBar></NavBar>
      <AlcaldiaRecursosMunicipalesForm></AlcaldiaRecursosMunicipalesForm>
    </div>
  );
}

export default AlcaldiaRecursosMunicipalesFormPage;
