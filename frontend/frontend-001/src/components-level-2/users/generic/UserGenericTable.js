import React from "react";
import PropTypes from "prop-types";
import TableFilterGeneric from "../../generic/TableFilterGeneric";
import useInput from "./../../../hooks/useInput";
import enumCompareOperators from "./../../../models/enumCompareOperators";
import enumTableColumnsToShow from "../../../models/system/enumTableColumnsToShow";
import getTableModels from "../../../models/users/usersTableModels";
import fixArrayDataUsers from "../../../tools/users/fixArrayData";

function UserGenericTable ({
  numberPagesToShow,
  tableTitle,
  tableSubTitle,
  handleGetData,
  handleGetSize,
  tableArrayCustomRowButtons,
  columnsToShow
}) {
  // CRITERIA OF SEARCH OR FILTER
  const { value: criteriaId, onChange: criteriaOnChangeId, setValue: criteriaSetId } = useInput("");
  const { value: criteriaUsername, onChange: criteriaOnChangeUsername, setValue: criteriaSetUsername } = useInput("");
  const { value: criteriaDni, onChange: criteriaOnChangeDni, setValue: criteriaSetDni } = useInput("");
  const { value: criteriaName, onChange: criteriaOnChangeName, setValue: criteriaSetName } = useInput("");
  const { value: criteriaSecondName, onChange: criteriaOnChangeSecondName, setValue: criteriaSetSecondName } = useInput("");
  const { value: criteriaLastName, onChange: criteriaOnChangeLastName, setValue: criteriaSetLastName } = useInput("");
  const { value: criteriaSecondLastName, onChange: criteriaOnChangeSecondLastName, setValue: criteriaSetSecondLastName } = useInput("");
  const { value: criteriaBirthDate, onChange: criteriaOnChangeBirthDate, setValue: criteriaSetBirthDate } = useInput("");
  const { value: criteriaAge, onChange: criteriaOnChangeAge, setValue: criteriaSetAge } = useInput("");
  const { value: criteriaSex, onChange: criteriaOnChangeSex, setValue: criteriaSetSex } = useInput("");
  const { value: criteriaOccupation, onChange: criteriaOnChangeOccupation, setValue: criteriaSetOccupation } = useInput("");
  const { value: criteriaTelephone, onChange: criteriaOnChangeTelephone, setValue: criteriaSetTelephone } = useInput("");
  const { value: criteriaAddress, onChange: criteriaOnChangeAddress, setValue: criteriaSetAddress } = useInput("");
  const { value: criteriaEmail, onChange: criteriaOnChangeEmail, setValue: criteriaSetEmail } = useInput("");
  const { value: criteriaStatus, onChange: criteriaOnChangeStatus, setValue: criteriaSetStatus } = useInput("");
  const { value: criteriaEmailVerified, onChange: criteriaOnChangeEmailVerified, setValue: criteriaSetEmailVerified } = useInput("");
  const { value: criteriaCreatedBy, onChange: criteriaOnChangeCreatedBy, setValue: criteriaSetCreatedBy } = useInput("");
  const { value: criteriaUpdatedBy, onChange: criteriaOnChangeUpdatedBy, setValue: criteriaSetUpdatedBy } = useInput("");
  const { value: criteriaCreatedDate, onChange: criteriaOnChangeCreatedDate, setValue: criteriaSetCreatedDate } = useInput("");
  const { value: criteriaUpdatedDate, onChange: criteriaOnChangeUpdatedDate, setValue: criteriaSetUpdatedDate } = useInput("");
  // FILTER OPERATORS
  const { value: operatorId, onChange: operatorOnChangeId, setValue: operatorSetId } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorUsername, onChange: operatorOnChangeUsername, setValue: operatorSetUsername } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorDni, onChange: operatorOnChangeDni, setValue: operatorSetDni } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorName, onChange: operatorOnChangeName, setValue: operatorSetName } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorSecondName, onChange: operatorOnChangeSecondName, setValue: operatorSetSecondName } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorLastName, onChange: operatorOnChangeLastName, setValue: operatorSetLastName } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorSecondLastName, onChange: operatorOnChangeSecondLastName, setValue: operatorSetSecondLastName } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorBirthDate, onChange: operatorOnChangeBirthDate, setValue: operatorSetBirthDate } = useInput(enumCompareOperators.DATE_EQUALS);
  const { value: operatorAge, onChange: operatorOnChangeAge, setValue: operatorSetAge } = useInput(enumCompareOperators.NUMBER_EQUALS);
  const { value: operatorSex, onChange: operatorOnChangeSex, setValue: operatorSetSex } = useInput(enumCompareOperators.TEXT_EQUALS);
  const { value: operatorOccupation, onChange: operatorOnChangeOccupation, setValue: operatorSetOccupation } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorTelephone, onChange: operatorOnChangeTelephone, setValue: operatorSetTelephone } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorAddress, onChange: operatorOnChangeAddress, setValue: operatorSetAddress } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorEmail, onChange: operatorOnChangeEmail, setValue: operatorSetEmail } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorStatus, onChange: operatorOnChangeStatus, setValue: operatorSetStatus } = useInput(enumCompareOperators.BOOLEAN_EQUALS);
  const { value: operatorEmailVerified, onChange: operatorOnChangeEmailVerified, setValue: operatorSetEmailVerified } = useInput(enumCompareOperators.BOOLEAN_EQUALS);
  const { value: operatorCreatedBy, onChange: operatorOnChangeCreatedBy, setValue: operatorSetCreatedBy } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorUpdatedBy, onChange: operatorOnChangeUpdatedBy, setValue: operatorSetUpdatedBy } = useInput(enumCompareOperators.TEXT_CONTAINS);
  const { value: operatorCreatedDate, onChange: operatorOnChangeCreatedDate, setValue: operatorSetCreatedDate } = useInput(enumCompareOperators.DATE_EQUALS);
  const { value: operatorUpdatedDate, onChange: operatorOnChangeUpdatedDate, setValue: operatorSetUpdatedDate } = useInput(enumCompareOperators.DATE_EQUALS);

  const { arrayDataFields, arrayColumnsFilter, clearFilters, getFilterBody, arrayColumnsLabels } = getTableModels(
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
  );

  function fixArrayData (arrayData) {
    const arrayFixed = fixArrayDataUsers(arrayData);
    return arrayFixed;
  }

  return (
    <TableFilterGeneric
      arrayColumns={arrayColumnsLabels}
      arrayDataFields={arrayDataFields}
      handleGetData={handleGetData}
      handleGetSize={handleGetSize}
      tableTitle={tableTitle}
      tableSubTitle={tableSubTitle}
      tableArrayCustomRowButtons={tableArrayCustomRowButtons}
      numberPagesToShow={numberPagesToShow}
      arrayColumnsFilter={arrayColumnsFilter}
      clearFilters={clearFilters}
      getFilterBody={getFilterBody}
      fixArrayData={fixArrayData}
    ></TableFilterGeneric>
  );
}

export default UserGenericTable;

UserGenericTable.propTypes = {
  numberPagesToShow: PropTypes.number,
  tableTitle: PropTypes.string,
  tableSubTitle: PropTypes.string,
  handleGetData: PropTypes.func,
  handleGetSize: PropTypes.func,
  tableArrayCustomRowButtons: PropTypes.array,
  columnsToShow: PropTypes.oneOf([
    enumTableColumnsToShow.FULL,
    enumTableColumnsToShow.MEDIUM,
    enumTableColumnsToShow.MINIMUM
  ]),
  fixArrayData: PropTypes.func
};

UserGenericTable.defaultProps = {
  numberPagesToShow: 0,
  tableTitle: "",
  tableSubTitle: undefined,
  handleGetData: () => { },
  handleGetSize: () => { },
  tableArrayCustomRowButtons: [],
  columnsToShow: enumTableColumnsToShow.FULL,
  fixArrayData: () => { }
};
