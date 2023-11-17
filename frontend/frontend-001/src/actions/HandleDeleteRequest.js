import requestManager from "./../api/RequestManager";
import messageManager from "./HandleErrorMessages";
import i18n from "./../i18n/i18n";

const handleDelete = (
  endpoint,
  callbakOnSuccess,
  callbakOnCancel,
  callbackOnFail,
  reloadOnSucess = false,
  showConfirmation = true,
  showOnDeleteMessage = true
) => {
  const message = i18n.errorMessages.confirmModal;
  let result = true;
  if (showConfirmation) {
    result = window.confirm(message);
  }
  if (result) {
    requestManager.remove(endpoint, (response) => {
      if (showOnDeleteMessage) {
        messageManager.deleteMessages(response);
      }
      if (response && response.status === 200) {
        if (callbakOnSuccess && typeof callbakOnSuccess === "function") {
          callbakOnSuccess(response.data);
        }
        if (reloadOnSucess) {
          window.location.reload();
        }
      } else {
        if (callbackOnFail && typeof callbackOnFail === "function") {
          const errorMessage = messageManager.getErrorMessage(response);
          callbackOnFail(response, errorMessage);
        }
      }
    });
  } else {
    if (callbakOnCancel) {
      callbakOnCancel();
    }
  }
};

export default handleDelete;
