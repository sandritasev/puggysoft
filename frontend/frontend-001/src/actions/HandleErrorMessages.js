import i18n from "./../i18n/i18n";

const unknownError = () => {
  alert(i18n.errorMessages.unknownError);
};
const successfullyCreated = () => {
  alert(i18n.errorMessages.successfullyCreated);
};
const successfullyEdited = () => {
  alert(i18n.errorMessages.successfullyEdited);
};
const successfullyDeleted = () => {
  alert(i18n.errorMessages.successfullyDeleted);
};
const errorStaus400 = () => {
  alert(i18n.errorMessages.errorStaus400);
};
const errorStaus403 = () => {
  alert(i18n.errorMessages.errorStaus403);
};
const errorStaus409 = () => {
  alert(i18n.errorMessages.errorStaus409);
};
const errorStaus409EntityHasRelation = () => {
  alert(i18n.errorMessages.errorStaus409EntityHasRelation);
};
const customMessage = (message) => {
  alert(message);
};

const findMessages = (errors) => {
  let meessage = "";
  errors.forEach(error => {
    const objectName = error.objectName;
    const field = error.field;
    const defaultMessage = error.defaultMessage;
    meessage = meessage.concat("******* ERROR *******");
    meessage = meessage.concat("\n");
    meessage = meessage.concat("ObjectName: " + objectName + "\n");
    meessage = meessage.concat("field: " + field + "\n");
    meessage = meessage.concat("defaultMessage: " + defaultMessage + "\n");
    meessage = meessage.concat("\n");
  });
  return meessage;
};

const commonMessages = (response) => {
  if (response && response.status === 400) {
    errorStaus400();
    if (response.data && response.data.errors) {
      const meessage = findMessages(response.data.errors);
      customMessage(meessage);
    }
    if (response.data && response.data.message) {
      customMessage(response.data.message);
    }
  } else if (response && response.status === 403) {
    errorStaus403();
  } else if (response && response.status === 409) {
    errorStaus409();
    if (response.data &&
      response.data.includes &&
      response.data.includes("Cannot delete or update a parent row: a foreign key constraint fails")
    ) {
      errorStaus409EntityHasRelation();
    }
    if (response.data && response.data.message) {
      const meessage = response.data.message;
      customMessage(meessage);
    }
  } else {
    unknownError();
  }
};

const getErrorMessage = (response) => {
  if (response && response.status === 400) {
    if (response.data && response.data.errors) {
      const meessage = findMessages(response.data.errors);
      return meessage;
    }
    if (response.data && response.data.message) {
      return response.data.message;
    }
    return i18n.errorMessages.errorStaus403;
  } else if (response && response.status === 403) {
    return i18n.errorMessages.errorStaus403;
  } else if (response && response.status === 409) {
    if (response.data && response.data.message) {
      const meessage = response.data.message;
      return meessage;
    }
    if (response.data &&
      response.data.includes &&
      response.data.includes("Cannot delete or update a parent row: a foreign key constraint fails")
    ) {
      return i18n.errorMessages.errorStaus409EntityHasRelation;
    }
    return i18n.errorMessages.errorStaus409;
  } else {
    return i18n.errorMessages.unknownError;
  }
};

const addMessages = (response) => {
  response && response.status === 201 ? successfullyCreated() : commonMessages(response);
};

const editMessages = (response) => {
  response && response.status === 200 ? successfullyEdited() : commonMessages(response);
};

const deleteMessages = (response) => {
  response && response.status === 200 ? successfullyDeleted() : commonMessages(response);
};

const messageManager = {
  addMessages,
  editMessages,
  deleteMessages,
  commonMessages,
  getErrorMessage
};

export default messageManager;
