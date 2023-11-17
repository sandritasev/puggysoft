import enumFilterType from "../enumFilterType";
import i18n from "../../i18n/i18n";
import enumInputType from "../../models/enumInputType";

const schemaTableFilter = function (
  /* ID */ criteriaId, criteriaOnChangeId, operatorId, operatorOnChangeId,
  /* NAME */criteriaName, criteriaOnChangeName, operatorName, operatorOnChangeName,
  /* SHORT NAME */criteriaShortName, criteriaOnChangeShortName, operatorShortName, operatorOnChangeShortName,
  /* TYPE */criteriaType, criteriaOnChangeType, operatorType, operatorOnChangeType,
  /* CREATED BY */criteriaCreatedBy, criteriaOnChangeCreatedBy, operatorCreatedBy, operatorOnChangeCreatedBy,
  /* UPDATED BY */criteriaUpdatedBy, criteriaOnChangeUpdatedBy, operatorUpdatedBy, operatorOnChangeUpdatedBy,
  /* CREATED DATE */criteriaCreatedDate, criteriaOnChangeCreatedDate, operatorCreatedDate, operatorOnChangeCreatedDate,
  /* UPDATED DATE */criteriaUpdatedDate, criteriaOnChangeUpdatedDate, operatorUpdatedDate, operatorOnChangeUpdatedDate
) {
  const arrayColumnsFilter = [
    {
      type: enumFilterType.NUMBER,
      criteriaValue: criteriaId,
      criteriaOnchange: criteriaOnChangeId,
      operatorValue: operatorId,
      operatorOnchange: operatorOnChangeId
    },
    {
      type: enumFilterType.TEXTBOX,
      criteriaValue: criteriaName,
      criteriaOnchange: criteriaOnChangeName,
      operatorValue: operatorName,
      operatorOnchange: operatorOnChangeName
    },
    {
      type: enumFilterType.TEXTBOX,
      criteriaValue: criteriaShortName,
      criteriaOnchange: criteriaOnChangeShortName,
      operatorValue: operatorShortName,
      operatorOnchange: operatorOnChangeShortName
    },
    {
      type: enumFilterType.DROPDOWN,
      criteriaValue: criteriaType,
      criteriaOnchange: criteriaOnChangeType,
      operatorValue: operatorType,
      operatorOnchange: operatorOnChangeType,
      dropdownValues: [
        { value: "", text: "*" },
        { value: enumInputType.TEXT, text: i18n.commonInputTypes.text },
        { value: enumInputType.TEXT_AREA, text: i18n.commonInputTypes.textarea },
        { value: enumInputType.NUMBER, text: i18n.commonInputTypes.number },
        { value: enumInputType.EMAIL, text: i18n.commonInputTypes.email },
        { value: enumInputType.DATE, text: i18n.commonInputTypes.date },
        { value: enumInputType.PASSWORD, text: i18n.commonInputTypes.password },
        { value: enumInputType.FILE, text: i18n.commonInputTypes.file },
        { value: enumInputType.SELECT, text: i18n.commonInputTypes.select }
      ]
    },
    {
      type: enumFilterType.NONE
    },
    {
      type: enumFilterType.TEXTBOX,
      criteriaValue: criteriaCreatedBy,
      criteriaOnchange: criteriaOnChangeCreatedBy,
      operatorValue: operatorCreatedBy,
      operatorOnchange: operatorOnChangeCreatedBy
    },
    {
      type: enumFilterType.TEXTBOX,
      criteriaValue: criteriaUpdatedBy,
      criteriaOnchange: criteriaOnChangeUpdatedBy,
      operatorValue: operatorUpdatedBy,
      operatorOnchange: operatorOnChangeUpdatedBy
    },
    {
      type: enumFilterType.DATE,
      criteriaValue: criteriaCreatedDate,
      criteriaOnchange: criteriaOnChangeCreatedDate,
      operatorValue: operatorCreatedDate,
      operatorOnchange: operatorOnChangeCreatedDate
    },
    {
      type: enumFilterType.DATE,
      criteriaValue: criteriaUpdatedDate,
      criteriaOnchange: criteriaOnChangeUpdatedDate,
      operatorValue: operatorUpdatedDate,
      operatorOnchange: operatorOnChangeUpdatedDate
    }
  ];

  return arrayColumnsFilter;
};

export default schemaTableFilter;
