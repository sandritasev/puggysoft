import isValidStringJson from "./../../tools/isValidStringJson";

const classNameRed = "puggysoft-red-text";

const classNameFormTextNew = {
  name: classNameRed,
  shortName: classNameRed,
  textboxOption: classNameRed
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
  // DROPDOWN OPTIONS
  console.log("aaaa");
  console.log(isValidStringJson(data.textboxOption));
  if (!(isValidStringJson(data.textboxOption) &&
    Object.prototype.toString.call(JSON.parse(data.textboxOption)) === "[object Array]")
  ) {
    isValid = false;
    classNameFormTextNew.textboxOption = classNameRed;
  } else {
    classNameFormTextNew.textboxOption = "";
  }
  setClassNameFormText({ ...classNameFormTextNew });
  return isValid;
};

export { handleValidation, classNameFormTextNew };
