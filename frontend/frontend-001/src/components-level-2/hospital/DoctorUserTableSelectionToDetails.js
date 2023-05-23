import React from "react";
import UserTableFilterGenericByRoleAndTenantToDetails from "./../generic/UserTableFilterGenericByRoleAndTenantToDetails";
import enumRoles from "./../../models/users/enumRoles";
import i18n from "../../i18n/i18n";

function DoctorUserTableSelectionToDetails () {
  const tableTitle = i18n.doctorTable.titleSelectionToDetails;
  const roleName = enumRoles.HOSPITAL_DOCTOR;

  return (
    <UserTableFilterGenericByRoleAndTenantToDetails
      roleName={roleName}
      tableTitle={tableTitle}
    >
    </UserTableFilterGenericByRoleAndTenantToDetails>
  );
}

export default DoctorUserTableSelectionToDetails;
