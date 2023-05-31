import enumFilterType from "../enumFilterType";
import enumStatus from "./enumStatus";
import i18n from "../../i18n/i18n";

const tenantsColumnsFilter = function (
  /* ID */ criteriaId, criteriaOnChangeId, operatorId, operatorOnChangeId,
  /* NAME */ criteriaName, criteriaOnChangeName, operatorName, operatorOnChangeName,
  /* SHORT NAME */ criteriaShortName, criteriaOnChangeShortName, operatorShortName, operatorOnChangeShortName,
  /* STATUS */criteriaStatus, criteriaOnChangeStatus, operatorStatus, operatorOnChangeStatus,
  /* DESCRIPTION */ criteriaDescription, criteriaOnChangeDescription, operatorDescription, operatorOnChangeDescription,
  /* TELEPHONE */criteriaTelephone, criteriaOnChangeTelephone, operatorTelephone, operatorOnChangeTelephone,
  /* ADDRESS */criteriaAddress, criteriaOnChangeAddress, operatorAddress, operatorOnChangeAddress,
  /* IMAGE */criteriaImage, criteriaOnChangeImage, operatorImage, operatorOnChangeImage,
  /* CREATED BY */criteriaCreatedBy, criteriaOnChangeCreatedBy, operatorCreatedBy, operatorOnChangeCreatedBy,
  /* UPDATED BY */criteriaUpdatedBy, criteriaOnChangeUpdatedBy, operatorUpdatedBy, operatorOnChangeUpdatedBy,
  /* CREATED DATE */criteriaCreatedDate, criteriaOnChangeCreatedDate, operatorCreatedDate, operatorOnChangeCreatedDate,
  /* UPDATED DATE */criteriaUpdatedDate, criteriaOnChangeUpdatedDate, operatorUpdatedDate, operatorOnChangeUpdatedDate
) {
  const arrayColumnsFilter = [
    {
      type: enumFilterType.NONE
    },
    {
      type: enumFilterType.TEXTBOX,
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
      criteriaValue: criteriaStatus,
      criteriaOnchange: criteriaOnChangeStatus,
      operatorValue: operatorStatus,
      operatorOnchange: operatorOnChangeStatus,
      dropdownValues: [
        { value: "", text: i18n.tenantStatusText.all },
        { value: enumStatus.ACTIVE, text: i18n.tenantStatusText.active },
        { value: enumStatus.INACTIVE, text: i18n.tenantStatusText.inactive }
      ]
    },
    {
      type: enumFilterType.TEXTBOX,
      criteriaValue: criteriaDescription,
      criteriaOnchange: criteriaOnChangeDescription,
      operatorValue: operatorDescription,
      operatorOnchange: operatorOnChangeDescription
    },
    {
      type: enumFilterType.TEXTBOX,
      criteriaValue: criteriaTelephone,
      criteriaOnchange: criteriaOnChangeTelephone,
      operatorValue: operatorTelephone,
      operatorOnchange: operatorOnChangeTelephone
    },
    {
      type: enumFilterType.TEXTBOX,
      criteriaValue: criteriaAddress,
      criteriaOnchange: criteriaOnChangeAddress,
      operatorValue: operatorAddress,
      operatorOnchange: operatorOnChangeAddress
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

export default tenantsColumnsFilter;
