import React, { useState, useEffect } from "react";
import PropTypes from "prop-types";
import CommonLoading from "../../components-level-1/CommonLoading";
import UserForm from "./UserForm";
import { handleGetRequest, handleAddRequest } from "../../actions/HandleManager";

function UserFormGenericByRole (props) {
  const { title, roleName, detailsUrl } = props;
  const [role, setRole] = useState(null);
  const [isUserDetailsLoading, setIsDetailsLoading] = useState(false);
  const [isUserRolesLoading, setIsUserRolesLoading] = useState(false);

  useEffect(() => {
    handleGetRequest(`role?roleName=${roleName}`, setRole);
  }, []);

  function afterAddUser (userData) {
    handleAddUserRole(userData);
    handleAddUserTenant(userData);
    handleAddDetails(userData);
  }

  const handleAddDetails = function (userData) {
    if (detailsUrl) {
      setIsDetailsLoading(true);
      const body = {
        idUser: userData.id
      };
      handleAddRequest(detailsUrl, body, afterAddDetails, false);
    }
  };

  const afterAddDetails = function (userDetailsData) {
    setIsDetailsLoading(false);
  };

  const handleAddUserRole = function (userData) {
    setIsUserRolesLoading(true);
    const username = window.sessionStorage.getItem("username");
    const tenant = window.sessionStorage.getItem("tenant");
    const body = {
      idUser: userData.id,
      idRole: role.id,
      createdBy: username,
      tenant
    };
    handleAddRequest("users-roles", body, afterAddUserRole, false);
  };

  const handleAddUserTenant = function (userData) {
    setIsUserRolesLoading(true);
    const username = window.sessionStorage.getItem("username");
    const tenant = window.sessionStorage.getItem("tenant");
    const body = {
      username: userData.username,
      tenant,
      createdBy: username
    };
    handleAddRequest("tenants-users", body, afterAddUserRole, false);
  };

  const afterAddUserRole = function (userRoleData) {
    setIsUserRolesLoading(false);
  };

  if (role === null || isUserDetailsLoading || isUserRolesLoading) {
    return <CommonLoading></CommonLoading>;
  }

  return (
    <UserForm
      title={title}
      afterAdd={afterAddUser}
    >
    </UserForm>
  );
}

export default UserFormGenericByRole;

UserFormGenericByRole.propTypes = {
  title: PropTypes.string,
  roleName: PropTypes.string,
  detailsUrl: PropTypes.string
};

UserFormGenericByRole.defaultProps = {
  title: "",
  roleName: "",
  detailsUrl: ""
};
