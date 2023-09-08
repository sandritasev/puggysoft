const classNameRed = "puggysoft-red-text";

const classNameFormTextNew = {
  file: classNameRed
};

const handleValidation = (data, setClassNameFormText) => {
  let isValid = true;
  if (!(data.fileType === "application/pdf")) {
    isValid = false;
    classNameFormTextNew.file = classNameRed;
  } else {
    classNameFormTextNew.file = "";
  }
  setClassNameFormText({ ...classNameFormTextNew });
  return isValid;
};

export { handleValidation, classNameFormTextNew };
