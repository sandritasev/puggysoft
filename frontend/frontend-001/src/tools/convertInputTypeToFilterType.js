import enumFilterType from "../models/enumFilterType";
import enumInputType from "../models/enumInputType";

/**
 *
 * @param {*} inputType is enumInputType
 */
function convertInputTypeToFilterType (inputType) {
  if (inputType === enumInputType.TEXT ||
        inputType === enumInputType.TEXT_AREA ||
        inputType === enumInputType.EMAIL
  ) {
    return enumFilterType.TEXTBOX;
  } else if (inputType === enumInputType.NUMBER) {
    return enumFilterType.NUMBER;
  } else if (inputType === enumInputType.DATE) {
    return enumFilterType.DATE;
  } else if (inputType === enumInputType.SELECT) {
    return enumFilterType.DROPDOWN;
  } else if (inputType === enumInputType.PASSWORD ||
        inputType === enumInputType.FILE
  ) {
    return enumFilterType.NONE;
  } else {
    return enumFilterType.NONE;
  }
}
export default convertInputTypeToFilterType;
