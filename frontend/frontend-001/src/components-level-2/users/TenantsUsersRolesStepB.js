import React from "react";
import { useHistory } from "react-router";
import i18n from "../../i18n/i18n";
import enumPaths from "./../../models/enumPaths";
import { handleFilterRequest } from "../../actions/HandleManager";
import UserGenericTable from "./generic/UserGenericTable";
import enumTableColumnsToShow from "./../../models/system/enumTableColumnsToShow";
import Card from "react-bootstrap/Card";

function TenantsUsersRolesStepB () {
  const tableTitle = i18n.userTable.title;
  const tableSubTitle = i18n.userTable.subTitleSelect;
  const pageSize = 10;
  const numberPagesToShow = 10;

  const history = useHistory();

  const tenantData = history.location.state.data;

  function handleGetData (activePage, filterBody, updateArrayData) {
    handleFilterRequest(`users/filter/with-tenants?page=${activePage - 1}&size=${pageSize}&tenant=${tenantData.shortName}`, filterBody, updateArrayData);
  }

  function handleGetSize (filterBody, setTotalPages) {
    handleFilterRequest(`users/filter/with-tenants/size?pageSize=${pageSize}&tenant=${tenantData.shortName}`, filterBody, setTotalPages);
  }

  function handleSelection (userData) {
    history.push({
      pathname: enumPaths.TENANTS_USERS_ROLES_STEP_THREE,
      state: {
        data: { userData, tenantData }
      }
    });
  }

  const tableArrayCustomRowButtons = [
    {
      variant: "info",
      handleCustom: handleSelection,
      text: i18n.roleTable.selectButton
    }
  ];

  return (
    <>
      <Card>
        <Card.Header as='h4'>{ i18n.tenantTable.subTitleSelected} : {tenantData?.name}</Card.Header>
      </Card>
      <UserGenericTable
        tableTitle={tableTitle}
        tableSubTitle={tableSubTitle}
        numberPagesToShow={numberPagesToShow}
        handleGetData={handleGetData}
        handleGetSize={handleGetSize}
        tableArrayCustomRowButtons={tableArrayCustomRowButtons}
        columnsToShow={enumTableColumnsToShow.MINIMUM}
      />
    </>
  );
}

export default TenantsUsersRolesStepB;
