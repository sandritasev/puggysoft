import React, { useState } from "react";
import { useHistory } from "react-router";
import i18n from "../../i18n/i18n";
import {
  handleFilterRequest,
  handleAddRequest,
  handleDeleteRequest
} from "../../actions/HandleManager";
import UserGenericTable from "./generic/UserGenericTable";
import enumTableColumnsToShow from "./../../models/system/enumTableColumnsToShow";
import CommonLoading from "../../components-level-1/CommonLoading";
import Card from "react-bootstrap/Card";

import "./../css/all-two-divs-side-by-side.css";

// TODO
function RolesUsersStepTwo () {
  const tableSubTitle = i18n.userTable.subTitleAdd;
  const tableSubTitleTwo = i18n.userTable.subTitleDelete;
  const pageSize = 10;
  const numberPagesToShow = 10;
  const [isLoadingTableOne, setIsLoadingTableOne] = useState(false);
  const [isLoadingTableTwo, setIsLoadingTableTwo] = useState(false);
  const history = useHistory();
  const roleData = history.location.state.data;
  const tenant = window.sessionStorage.getItem("tenant");

  function handleGetData (activePage, filterBody, updateArrayData) {
    handleFilterRequest(`users/filter/without-roles-and-tenants?page=${activePage - 1}&size=${pageSize}&idRol=${roleData.id}&tenant=${tenant}`, filterBody, updateArrayData);
  }

  function handleGetSize (filterBody, setTotalPages) {
    handleFilterRequest(`users/filter/without-roles-and-tenants/size?pageSize=${pageSize}&idRol=${roleData.id}&tenant=${tenant}`, filterBody, setTotalPages);
  }

  function handleGetDataTwo (activePage, filterBody, updateArrayData) {
    handleFilterRequest(`users/filter/with-roles-and-tenants-fake-id?page=${activePage - 1}&size=${pageSize}&idRole=${roleData.id}&tenant=${tenant}`, filterBody, updateArrayData);
  }

  function handleGetSizeTwo (filterBody, setTotalPages) {
    handleFilterRequest(`users/filter/with-roles-and-tenants/size?pageSize=${pageSize}&idRole=${roleData.id}&tenant=${tenant}`, filterBody, setTotalPages);
  }

  function afterApiCall () {
    setIsLoadingTableOne(false);
    setIsLoadingTableTwo(false);
  }

  const handleAdd = function (userData) {
    setIsLoadingTableOne(true);
    setIsLoadingTableTwo(true);
    const roleSelectedId = roleData.id;
    const userSelectedId = userData.id;
    const username = window.sessionStorage.getItem("username");
    const body = {
      idRole: roleSelectedId,
      idUser: userSelectedId,
      createdBy: username,
      tenant
    };
    handleAddRequest("users-roles", body, afterApiCall);
  };

  function handleDelete (userData) {
    setIsLoadingTableOne(true);
    setIsLoadingTableTwo(true);
    handleDeleteRequest(`tenants-users-roles/${userData.id}`, afterApiCall);
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
        <Card.Header as='h4'>{i18n.roleTable.subTitleSelected} : {roleData?.name}</Card.Header>
      </Card>
      <div>
        <div className="puggysoft-two-divs-side-by-side-child">
          {isLoadingTableOne
            ? <CommonLoading />
            : <UserGenericTable
              tableSubTitle={tableSubTitle}
              numberPagesToShow={numberPagesToShow}
              handleGetData={handleGetData}
              handleGetSize={handleGetSize}
              tableArrayCustomRowButtons={tableArrayCustomRowButtons}
              columnsToShow={enumTableColumnsToShow.MINIMUM}
            />
          }
        </div>
        <div className="puggysoft-two-divs-side-by-side-child">
          {isLoadingTableTwo
            ? <CommonLoading />
            : <UserGenericTable
              tableSubTitle={tableSubTitleTwo}
              numberPagesToShow={numberPagesToShow}
              handleGetData={handleGetDataTwo}
              handleGetSize={handleGetSizeTwo}
              tableArrayCustomRowButtons={tableArrayCustomRowButtonsTwo}
              columnsToShow={enumTableColumnsToShow.MINIMUM}
            />
          }
        </div>
      </div>
    </>
  );
}

export default RolesUsersStepTwo;
