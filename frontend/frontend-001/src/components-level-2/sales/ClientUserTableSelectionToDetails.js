import React from "react";
import UserTableFilterGenericByRoleAndTenantToDetails from "./../generic/UserTableFilterGenericByRoleAndTenantToDetails";
import enumRoles from "./../../models/users/enumRoles";
import i18n from "../../i18n/i18n";

function ClientUserTableSelectionToDetails () {
  const tableTitle = i18n.clientTable.titleSelectionToDetails;
  const roleName = enumRoles.SALES_CLIENT;

  return (
    <UserTableFilterGenericByRoleAndTenantToDetails
      roleName={roleName}
      tableTitle={tableTitle}
    >
    </UserTableFilterGenericByRoleAndTenantToDetails>
  );
}

export default ClientUserTableSelectionToDetails;
