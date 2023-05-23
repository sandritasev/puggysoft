import React from "react";
import UserTableFilterGenericByRoleAndTenantToDetails from "./../generic/UserTableFilterGenericByRoleAndTenantToDetails";
import enumRoles from "./../../models/users/enumRoles";
import i18n from "../../i18n/i18n";

function PatientUserTableSelectionToDetails () {
  const tableTitle = i18n.patientTable.titleSelectionToDetails;
  const roleName = enumRoles.HOSPITAL_PATIENT;

  return (
    <UserTableFilterGenericByRoleAndTenantToDetails
      roleName={roleName}
      tableTitle={tableTitle}
    >
    </UserTableFilterGenericByRoleAndTenantToDetails>
  );
}

export default PatientUserTableSelectionToDetails;
