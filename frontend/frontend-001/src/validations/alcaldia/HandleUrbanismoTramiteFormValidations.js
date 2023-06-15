const classNameRed = "puggysoft-red-text";

const classNameFormTextNew = {
  nombre: classNameRed,
  nombreCorto: classNameRed,
  tenant: classNameRed
};

const handleValidation = (data, setClassNameFormText) => {
  let isValid = true;
  if (!(data.nombre.length >= 3 && data.nombre.length <= 30)) {
    isValid = false;
    classNameFormTextNew.nombre = classNameRed;
  } else {
    classNameFormTextNew.nombre = "";
  }
  if (!(data.nombreCorto.length >= 3 && data.nombreCorto.length <= 120)) {
    isValid = false;
    classNameFormTextNew.nombreCorto = classNameRed;
  } else {
    classNameFormTextNew.nombreCorto = "";
  }
  setClassNameFormText({ ...classNameFormTextNew });
  return isValid;
};

export { handleValidation, classNameFormTextNew };
