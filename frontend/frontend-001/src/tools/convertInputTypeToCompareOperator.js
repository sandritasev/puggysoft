import enumCompareOperators from "../models/enumCompareOperators";
import enumInputType from "../models/enumInputType";

/**
 *
 * @param {*} inputType is enumInputType
 */
function convertInputTypeToCompareOperator (inputType) {
  if (inputType === enumInputType.TEXT ||
        inputType === enumInputType.TEXT_AREA ||
        inputType === enumInputType.EMAIL
  ) {
    return enumCompareOperators.TEXT_CONTAINS;
  } else if (inputType === enumInputType.NUMBER) {
    return enumCompareOperators.NUMBER_EQUALS;
  } else if (inputType === enumInputType.DATE) {
    return enumCompareOperators.DATE_EQUALS;
  } else if (inputType === enumInputType.SELECT) {
    return enumCompareOperators.TEXT_EQUALS;
  } else if (inputType === enumInputType.PASSWORD ||
        inputType === enumInputType.FILE
  ) {
    return enumCompareOperators.NONE;
  } else {
    return enumCompareOperators.NONE;
  }
}
export default convertInputTypeToCompareOperator;
