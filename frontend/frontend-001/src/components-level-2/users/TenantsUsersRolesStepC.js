import React, { useState } from "react";
import { useHistory } from "react-router";
import i18n from "../../i18n/i18n";
import {
  handleFilterRequest,
  handleAddRequest,
  handleDeleteRequest
} from "../../actions/HandleManager";
import RoleGenericTable from "./generic/RoleGenericTable";
import enumTableColumnsToShow from "./../../models/system/enumTableColumnsToShow";
import CommonLoading from "../../components-level-1/CommonLoading";
import Card from "react-bootstrap/Card";

import "./../css/all-two-divs-side-by-side.css";

function TenantsUsersRolesStepC () {
  const tableSubTitle = i18n.roleTable.subTitleAdd;
  const tableSubTitleTwo = i18n.roleTable.subTitleDelete;
  const pageSize = 10;
  const numberPagesToShow = 10;
  const [isLoadingTableOne, setIsLoadingTableOne] = useState(false);
  const [isLoadingTableTwo, setIsLoadingTableTwo] = useState(false);

  const history = useHistory();

  const { userData, tenantData } = history.location.state.data;

  function handleGetData (activePage, filterBody, updateArrayData) {
    handleFilterRequest(`roles/filter/without-users-and-tenants?page=${activePage - 1}&size=${pageSize}&idUser=${userData.id}&tenant=${tenantData.shortName}`, filterBody, updateArrayData);
  }

  function handleGetSize (filterBody, setTotalPages) {
    handleFilterRequest(`roles/filter/without-users-and-tenants/size?pageSize=${pageSize}&idUser=${userData.id}&tenant=${tenantData.shortName}`, filterBody, setTotalPages);
  }

  function handleGetDataTwo (activePage, filterBody, updateArrayData) {
    handleFilterRequest(`roles/filter/with-users-and-tenants?page=${activePage - 1}&size=${pageSize}&idUser=${userData.id}&tenant=${tenantData.shortName}`, filterBody, updateArrayData);
  }

  function handleGetSizeTwo (filterBody, setTotalPages) {
    handleFilterRequest(`roles/filter/with-users-and-tenants/size?pageSize=${pageSize}&idUser=${userData.id}&tenant=${tenantData.shortName}`, filterBody, setTotalPages);
  }

  function afterApiCall () {
    setIsLoadingTableOne(false);
    setIsLoadingTableTwo(false);
  }

  const handleAdd = function (roleData) {
    setIsLoadingTableOne(true);
    setIsLoadingTableTwo(true);
    const tenantSelected = tenantData.shortName;
    const roleSelectedId = roleData.id;
    const userSelectedId = userData.id;
    const username = window.sessionStorage.getItem("username");
    const body = {
      idRole: roleSelectedId,
      idUser: userSelectedId,
      createdBy: username,
      tenant: tenantSelected
    };
    handleAddRequest("users-roles", body, afterApiCall);
  };

  function handleDelete (roleData) {
    setIsLoadingTableOne(true);
    setIsLoadingTableTwo(true);
    handleDeleteRequest(`tenants-users-roles/${roleData.id}`, afterApiCall);
  }

  const tableArrayCustomRowButtons = [
    {
      variant: "info",
      handleCustom: handleAdd,
      text: i18n.commonTable.addButton
    }
  ];

  const tableArrayCustomRowButtonsTwo = [
    {
      variant: "danger",
      handleCustom: handleDelete,
      text: i18n.commonTable.deleteButton
    }
  ];

  return (
    <>
      <Card>
        <Card.Header as='h4'>{i18n.tenantTable.subTitleSelected} : {tenantData?.name}</Card.Header>
        <Card.Header as='h4'>{i18n.userTable.subTitleSelected} : {userData?.username}</Card.Header>
      </Card>
      <div>
        <div className="puggysoft-two-divs-side-by-side-child">
          {isLoadingTableOne
            ? <CommonLoading />
            : <RoleGenericTable
              tableSubTitle={tableSubTitle}
              numberPagesToShow={numberPagesToShow}
              handleGetData={handleGetData}
              handleGetSize={handleGetSize}
              tableArrayCustomRowButtons={tableArrayCustomRowButtons}
              columnsToShow={enumTableColumnsToShow.MEDIUM}
            />
          }
        </div>
        <div className="puggysoft-two-divs-side-by-side-child">
          {isLoadingTableTwo
            ? <CommonLoading />
            : <RoleGenericTable
              tableSubTitle={tableSubTitleTwo}
              numberPagesToShow={numberPagesToShow}
              handleGetData={handleGetDataTwo}
              handleGetSize={handleGetSizeTwo}
              tableArrayCustomRowButtons={tableArrayCustomRowButtonsTwo}
              columnsToShow={enumTableColumnsToShow.MEDIUM}
            />
          }
        </div>
      </div>
    </>
  );
}

export default TenantsUsersRolesStepC;
