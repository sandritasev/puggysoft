import React, { useState } from "react";
import PropTypes from "prop-types";
import CommonLoading from "../../components-level-1/CommonLoading";
import UserForm from "./UserForm";
import { handleAddRequest } from "../../actions/HandleManager";
import i18n from "../../i18n/i18n";

function UserFormGenericByTenant (props) {
  const { detailsUrl } = props;
  const title = i18n.userForm.title;
  const [isUserDetailsLoading, setIsDetailsLoading] = useState(false);
  const [isUserTenantLoading, setIsUserTenantLoading] = useState(false);

  function afterAddUser (userData) {
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

  const handleAddUserTenant = function (userData) {
    setIsUserTenantLoading(true);
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
    setIsUserTenantLoading(false);
  };

  if (isUserDetailsLoading || isUserTenantLoading) {
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

export default UserFormGenericByTenant;

UserFormGenericByTenant.propTypes = {
  detailsUrl: PropTypes.string
};

UserFormGenericByTenant.defaultProps = {
  detailsUrl: ""
};
