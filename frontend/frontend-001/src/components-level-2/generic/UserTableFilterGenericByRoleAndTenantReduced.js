import React, { useState, useEffect } from "react";
import PropTypes from "prop-types";
import UserTableFilterGenericReduced from "./../users/UserTableFilterGenericReduced";
import CommonLoading from "../../components-level-1/CommonLoading";
import { handleFilterRequest, handleGetRequest } from "../../actions/HandleManager";

import "./../css/table-center.css";

function UserTableFilterGenericByRoleReduced (props) {
  const pageSize = 10;
  const numberPagesToShow = 10;
  const [role, setRole] = useState(null);

  // roleName should be instance of enumRoles
  const { tableArrayCustomRowButtons, roleName, tableTitle } = props;

  useEffect(() => {
    handleGetRequest(`role?roleName=${roleName}`, setRole);
  }, []);

  function handleGetData (activePage, filterBody, updateArrayData) {
    const tenant = window.sessionStorage.getItem("tenant");
    handleFilterRequest(`users/filter/with-roles-and-tenants?page=${activePage - 1}&size=${pageSize}&idRole=${role.id}&tenant=${tenant}`, filterBody, updateArrayData);
  }

  function handleGetSize (filterBody, setTotalPages) {
    const tenant = window.sessionStorage.getItem("tenant");
    handleFilterRequest(`users/filter/with-roles-and-tenants/size?pageSize=${pageSize}&idRole=${role.id}&tenant=${tenant}`, filterBody, setTotalPages);
  }

  if (role === null) {
    return <CommonLoading></CommonLoading>;
  }

  return (
    <div className='puggysoft-center-reduced-table'>
      <UserTableFilterGenericReduced
        handleGetData={handleGetData}
        handleGetSize={handleGetSize}
        tableTitle={tableTitle}
        tableArrayCustomRowButtons={tableArrayCustomRowButtons}
        pageSize={pageSize}
        numberPagesToShow={numberPagesToShow}
      >
      </UserTableFilterGenericReduced>
    </div>
  );
}

export default UserTableFilterGenericByRoleReduced;

UserTableFilterGenericByRoleReduced.propTypes = {
  roleName: PropTypes.string,
  tableTitle: PropTypes.string,
  tableArrayCustomRowButtons: PropTypes.array
};

UserTableFilterGenericByRoleReduced.defaultProps = {
  roleName: "",
  tableTitle: "",
  tableArrayCustomRowButtons: []
};
