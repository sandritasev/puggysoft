import enumTableColumnsToShow from "../enumTableColumnsToShow";
import arrayDataFieldsImport from "./arrayUserDataFields";
import arrayColumnsLabelsImport from "./arrayUserColumns";
import columnsFilter from "./arrayUserColumnsFilter";

const usersTableModels = function (
  columnsToShow,
  /* ID */ criteriaId, criteriaOnChangeId, criteriaSetId, operatorId, operatorOnChangeId, operatorSetId,
  /* USERNAME */ criteriaUsername, criteriaOnChangeUsername, criteriaSetUsername, operatorUsername, operatorOnChangeUsername, operatorSetUsername,
  /* DNI */ criteriaDni, criteriaOnChangeDni, criteriaSetDni, operatorDni, operatorOnChangeDni, operatorSetDni,
  /* NAME */ criteriaName, criteriaOnChangeName, criteriaSetName, operatorName, operatorOnChangeName, operatorSetName,
  /* SECOND NAME */criteriaSecondName, criteriaOnChangeSecondName, criteriaSetSecondName, operatorSecondName, operatorOnChangeSecondName, operatorSetSecondName,
  /* LAST NAME */ criteriaLastName, criteriaOnChangeLastName, criteriaSetLastName, operatorLastName, operatorOnChangeLastName, operatorSetLastName,
  /* SECOND LAST NAME */criteriaSecondLastName, criteriaOnChangeSecondLastName, criteriaSetSecondLastName, operatorSecondLastName, operatorOnChangeSecondLastName, operatorSetSecondLastName,
  /* BIRTHDATE */criteriaBirthDate, criteriaOnChangeBirthDate, criteriaSetBirthDate, operatorBirthDate, operatorOnChangeBirthDate, operatorSetBirthDate,
  /* AGE */criteriaAge, criteriaOnChangeAge, criteriaSetAge, operatorAge, operatorOnChangeAge, operatorSetAge,
  /* SEX */criteriaSex, criteriaOnChangeSex, criteriaSetSex, operatorSex, operatorOnChangeSex, operatorSetSex,
  /* OCCUPATION */criteriaOccupation, criteriaOnChangeOccupation, criteriaSetOccupation, operatorOccupation, operatorOnChangeOccupation, operatorSetOccupation,
  /* TELEPHONE */criteriaTelephone, criteriaOnChangeTelephone, criteriaSetTelephone, operatorTelephone, operatorOnChangeTelephone, operatorSetTelephone,
  /* ADDRESS */criteriaAddress, criteriaOnChangeAddress, criteriaSetAddress, operatorAddress, operatorOnChangeAddress, operatorSetAddress,
  /* EMAIL */criteriaEmail, criteriaOnChangeEmail, criteriaSetEmail, operatorEmail, operatorOnChangeEmail, operatorSetEmail,
  /* STATUS */criteriaStatus, criteriaOnChangeStatus, criteriaSetStatus, operatorStatus, operatorOnChangeStatus, operatorSetStatus,
  /* EMAIL VERIFIED */criteriaEmailVerified, criteriaOnChangeEmailVerified, criteriaSetEmailVerified, operatorEmailVerified, operatorOnChangeEmailVerified, operatorSetEmailVerified,
  /* CREATED BY */criteriaCreatedBy, criteriaOnChangeCreatedBy, criteriaSetCreatedBy, operatorCreatedBy, operatorOnChangeCreatedBy, operatorSetCreatedBy,
  /* UPDATED BY */criteriaUpdatedBy, criteriaOnChangeUpdatedBy, criteriaSetUpdatedBy, operatorUpdatedBy, operatorOnChangeUpdatedBy, operatorSetUpdatedBy,
  /* CREATED DATE */criteriaCreatedDate, criteriaOnChangeCreatedDate, criteriaSetCreatedDate, operatorCreatedDate, operatorOnChangeCreatedDate, operatorSetCreatedDate,
  /* UPDATED DATE */criteriaUpdatedDate, criteriaOnChangeUpdatedDate, criteriaSetUpdatedDate, operatorUpdatedDate, operatorOnChangeUpdatedDate, operatorSetUpdatedDate
) {
  let arrayDataFields = arrayDataFieldsImport;
  let arrayColumnsLabels = arrayColumnsLabelsImport;
  let {
    arrayColumnsFilter,
    clearFilters,
    getFilterBody,
    setOperatorsDefaultValues
  } = columnsFilter(
    /* ID */ criteriaId, criteriaOnChangeId, criteriaSetId, operatorId, operatorOnChangeId, operatorSetId,
    /* USERNAME */ criteriaUsername, criteriaOnChangeUsername, criteriaSetUsername, operatorUsername, operatorOnChangeUsername, operatorSetUsername,
    /* DNI */ criteriaDni, criteriaOnChangeDni, criteriaSetDni, operatorDni, operatorOnChangeDni, operatorSetDni,
    /* NAME */ criteriaName, criteriaOnChangeName, criteriaSetName, operatorName, operatorOnChangeName, operatorSetName,
    /* SECOND NAME */criteriaSecondName, criteriaOnChangeSecondName, criteriaSetSecondName, operatorSecondName, operatorOnChangeSecondName, operatorSetSecondName,
    /* LAST NAME */ criteriaLastName, criteriaOnChangeLastName, criteriaSetLastName, operatorLastName, operatorOnChangeLastName, operatorSetLastName,
    /* SECOND LAST NAME */criteriaSecondLastName, criteriaOnChangeSecondLastName, criteriaSetSecondLastName, operatorSecondLastName, operatorOnChangeSecondLastName, operatorSetSecondLastName,
    /* BIRTHDATE */criteriaBirthDate, criteriaOnChangeBirthDate, criteriaSetBirthDate, operatorBirthDate, operatorOnChangeBirthDate, operatorSetBirthDate,
    /* AGE */criteriaAge, criteriaOnChangeAge, criteriaSetAge, operatorAge, operatorOnChangeAge, operatorSetAge,
    /* SEX */criteriaSex, criteriaOnChangeSex, criteriaSetSex, operatorSex, operatorOnChangeSex, operatorSetSex,
    /* OCCUPATION */criteriaOccupation, criteriaOnChangeOccupation, criteriaSetOccupation, operatorOccupation, operatorOnChangeOccupation, operatorSetOccupation,
    /* TELEPHONE */criteriaTelephone, criteriaOnChangeTelephone, criteriaSetTelephone, operatorTelephone, operatorOnChangeTelephone, operatorSetTelephone,
    /* ADDRESS */criteriaAddress, criteriaOnChangeAddress, criteriaSetAddress, operatorAddress, operatorOnChangeAddress, operatorSetAddress,
    /* EMAIL */criteriaEmail, criteriaOnChangeEmail, criteriaSetEmail, operatorEmail, operatorOnChangeEmail, operatorSetEmail,
    /* STATUS */criteriaStatus, criteriaOnChangeStatus, criteriaSetStatus, operatorStatus, operatorOnChangeStatus, operatorSetStatus,
    /* EMAIL VERIFIED */criteriaEmailVerified, criteriaOnChangeEmailVerified, criteriaSetEmailVerified, operatorEmailVerified, operatorOnChangeEmailVerified, operatorSetEmailVerified,
    /* CREATED BY */criteriaCreatedBy, criteriaOnChangeCreatedBy, criteriaSetCreatedBy, operatorCreatedBy, operatorOnChangeCreatedBy, operatorSetCreatedBy,
    /* UPDATED BY */criteriaUpdatedBy, criteriaOnChangeUpdatedBy, criteriaSetUpdatedBy, operatorUpdatedBy, operatorOnChangeUpdatedBy, operatorSetUpdatedBy,
    /* CREATED DATE */criteriaCreatedDate, criteriaOnChangeCreatedDate, criteriaSetCreatedDate, operatorCreatedDate, operatorOnChangeCreatedDate, operatorSetCreatedDate,
    /* UPDATED DATE */criteriaUpdatedDate, criteriaOnChangeUpdatedDate, criteriaSetUpdatedDate, operatorUpdatedDate, operatorOnChangeUpdatedDate, operatorSetUpdatedDate
  );

  const isMedium = columnsToShow === enumTableColumnsToShow.MEDIUM;
  const isMinimum = columnsToShow === enumTableColumnsToShow.MINIMUM;

  if (isMedium) {
    // Delete password.
    arrayColumnsFilter = arrayColumnsFilter.filter((element, index) => index !== 3);
    arrayColumnsLabels = arrayColumnsLabels.filter((element, index) => index !== 3);
    arrayDataFields = arrayDataFields.filter((element, index) => index !== 3);
    arrayColumnsFilter = arrayColumnsFilter.slice(0, arrayColumnsFilter.length - 6);
    arrayColumnsLabels = arrayColumnsLabels.slice(0, arrayColumnsLabels.length - 6);
    arrayDataFields = arrayDataFields.slice(0, arrayDataFields.length - 6);
  } else if (isMinimum) {
    // Delete password.
    arrayColumnsFilter = arrayColumnsFilter.filter((element, index) => index !== 3);
    arrayColumnsLabels = arrayColumnsLabels.filter((element, index) => index !== 3);
    arrayDataFields = arrayDataFields.filter((element, index) => index !== 3);
    arrayColumnsFilter = arrayColumnsFilter.slice(1, arrayColumnsFilter.length - 16);
    arrayColumnsLabels = arrayColumnsLabels.slice(1, arrayColumnsLabels.length - 16);
    arrayDataFields = arrayDataFields.slice(1, arrayDataFields.length - 16);
  }

  return {
    arrayColumnsFilter,
    clearFilters,
    getFilterBody,
    setOperatorsDefaultValues,
    arrayDataFields,
    arrayColumnsLabels
  };
};

export default usersTableModels;
