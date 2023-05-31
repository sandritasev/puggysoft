const hidden = "visually-hidden";
const classNameFormTextNew = {
  name: hidden,
  shortName: hidden,
  description: hidden,
  telephone: hidden,
  address: hidden
};

const handleValidation = (data, setClassNameFormText) => {
  let isValid = true;
  if ((data.name.length >= 3 && data.name.length <= 60)) {
    classNameFormTextNew.name = hidden;
  } else {
    isValid = false;
    classNameFormTextNew.name = "";
  } if ((data.shortName.length >= 3 && data.shortName.length <= 30)) {
    classNameFormTextNew.shortName = hidden;
  } else {
    isValid = false;
    classNameFormTextNew.shortName = "";
  } if ((data.description.length >= 3)) {
    classNameFormTextNew.description = hidden;
  } else {
    isValid = false;
    classNameFormTextNew.description = "";
  } if ((data.telephone.length >= 3 && data.telephone.length <= 30 && (/^[0-9]+$/.test(data.telephone)))) {
    classNameFormTextNew.telephone = hidden;
  } else {
    isValid = false;
    classNameFormTextNew.telephone = "";
  } if ((data.address.length >= 3 && data.address.length <= 60)) {
    classNameFormTextNew.address = hidden;
  } else {
    isValid = false;
    classNameFormTextNew.address = "";
  }
  setClassNameFormText({ ...classNameFormTextNew });
  return isValid;
};

export { handleValidation, classNameFormTextNew };
