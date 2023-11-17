const classNameRed = "puggysoft-red-text";

const classNameFormTextNew = {
  name: classNameRed,
  shortName: classNameRed
};

const handleValidation = (data, setClassNameFormText) => {
  let isValid = true;
  // NAME VALIDATION
  if (!(data.name.length >= 3 && data.name.length <= 60)) {
    isValid = false;
    classNameFormTextNew.name = classNameRed;
  } else {
    classNameFormTextNew.name = "";
  }
  // SHORT NAME VALIDATION
  if (!(data.shortName.length >= 3 &&
    data.shortName.length <= 30) ||
    data.shortName.includes(" ")
  ) {
    isValid = false;
    classNameFormTextNew.shortName = classNameRed;
  } else {
    classNameFormTextNew.shortName = "";
  }
  setClassNameFormText({ ...classNameFormTextNew });
  return isValid;
};

export { handleValidation, classNameFormTextNew };
