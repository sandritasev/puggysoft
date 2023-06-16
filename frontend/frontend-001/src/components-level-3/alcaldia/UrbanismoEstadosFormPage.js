import React from "react";
import NavBar from "../../components-level-2/navbar/NavBar";
import UrbanismoEstadosForm from "../../components-level-2/alcaldia/UrbanismoEstadosForm";

function UrbanismoEstadosFormPage () {
  return (
    <div className="form-page">
      <NavBar></NavBar>
      <UrbanismoEstadosForm></UrbanismoEstadosForm>
    </div>
  );
}

export default UrbanismoEstadosFormPage;
