const classNameRed = "puggysoft-red-text";

const classNameFormTextNew = {
  codigo: classNameRed,
  name: classNameRed,
  precio: classNameRed,
  tenant: classNameRed
};

const handleValidation = (data, setClassNameFormText) => {
  let isValid = true;
  console.log(data);
  if (!(data.codigo.length >= 3 && data.codigo.length <= 30)) {
    isValid = false;
    classNameFormTextNew.codigo = classNameRed;
  } else {
    classNameFormTextNew.codigo = "";
  }
  if (!(data.name.length >= 3 && data.name.length <= 120)) {
    isValid = false;
    classNameFormTextNew.name = classNameRed;
  } else {
    classNameFormTextNew.name = "";
  }
  if (!(data.precio.length > 0 && data.precio.length <= 11)) {
    isValid = false;
    classNameFormTextNew.precio = classNameRed;
  } else if (!/^[0-9]+$/.test(data.precio)) {
    isValid = false;
    classNameFormTextNew.precio = classNameRed;
  } else {
    classNameFormTextNew.precio = "";
  }
  setClassNameFormText({ ...classNameFormTextNew });
  return isValid;
};

export { handleValidation, classNameFormTextNew };
