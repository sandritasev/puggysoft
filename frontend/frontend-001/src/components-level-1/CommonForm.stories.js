import React from "react";
import CommonForm from "./CommonForm";
import enumInputType from "./../models/enumInputType";
import enumBootstrapVariant from "./../models/enumBootstrapVariant";

export default {
  title: "CommonForm",
  component: CommonForm
};

const Template = (args) => <CommonForm {...args} />;

export const commonForm1 = Template.bind({});

commonForm1.args = {
  title: "Formulario de Ejemplo",
  handleAction: () => { },
  buttonText: "Registrar",
  buttonVariant: enumBootstrapVariant.SUCCESS,
  schema: [
    {
      key: "username",
      inputType: enumInputType.TEXT,
      label: "Nombre de usuario",
      inputValue: "",
      suggestionText: "Ingrese su nombre de usuario",
      suggestionTextClassName: "puggysoft-red-text",
      onChange: () => { },
      isDisabledEdit: false,
      inputSelectOption: undefined
    },
    {
      key: "password",
      inputType: enumInputType.PASSWORD,
      label: "Contrasena",
      inputValue: "",
      suggestionText: "Ingrese su contrasena",
      suggestionTextClassName: "puggysoft-red-text",
      onChange: () => { },
      isDisabledEdit: false,
      inputSelectOption: undefined
    },
    {
      key: "email",
      inputType: enumInputType.EMAIL,
      label: "Correo electronico",
      inputValue: "",
      suggestionText: "Ingrese su email",
      suggestionTextClassName: "puggysoft-red-text",
      onChange: () => { },
      isDisabledEdit: false,
      inputSelectOption: undefined
    },
    {
      key: "age",
      inputType: enumInputType.NUMBER,
      label: "Edad",
      inputValue: "",
      suggestionText: "Ingrese su edad",
      suggestionTextClassName: "puggysoft-red-text",
      onChange: () => { },
      isDisabledEdit: false,
      inputSelectOption: undefined
    },
    {
      key: "date",
      inputType: enumInputType.DATE,
      label: "Fecha nacimeinto",
      inputValue: "",
      suggestionText: "Ingrese su fecha de nacimiento",
      suggestionTextClassName: "puggysoft-red-text",
      onChange: () => { },
      isDisabledEdit: false,
      inputSelectOption: undefined
    },
    {
      key: "type",
      inputType: enumInputType.SELECT,
      label: "Tipo",
      inputValue: "STUDENT",
      suggestionText: "Seleccione el tipo de usuario",
      suggestionTextClassName: "puggysoft-red-text",
      onChange: () => { },
      isDisabledEdit: false,
      inputSelectOption: [
        {
          key: "admin",
          value: "ADMIN",
          label: "ADMINISTRADOR"
        },
        {
          key: "student",
          value: "STUDENT",
          label: "ESTUDIANTE"
        },
        {
          key: "teacher",
          value: "TEACHER",
          label: "PROFRESOR"
        }
      ]
    }
  ]
};
