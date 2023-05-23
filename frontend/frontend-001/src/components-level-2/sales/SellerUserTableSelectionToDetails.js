import React from "react";
import UserTableFilterGenericByRoleAndTenantToDetails from "./../generic/UserTableFilterGenericByRoleAndTenantToDetails";
import enumRoles from "./../../models/users/enumRoles";
import i18n from "../../i18n/i18n";

function SellerUserTableSelectionToDetails () {
  const tableTitle = i18n.sellerTable.titleSelectionToDetails;
  const roleName = enumRoles.SALES_SELLER;

  return (
    <UserTableFilterGenericByRoleAndTenantToDetails
      roleName={roleName}
      tableTitle={tableTitle}
    >
    </UserTableFilterGenericByRoleAndTenantToDetails>
  );
}

export default SellerUserTableSelectionToDetails;
