import requestManager from "./../api/RequestManager";
import messageManager from "./HandleErrorMessages";

const handleEdit = (endpoint, body, id, callbakOnSuccess, callbackOnFail, showAlert = true) => {
  const url = endpoint.concat(id);
  requestManager.put(url, body, (response) => {
    if (response && response.status === 200) {
      if (callbakOnSuccess && typeof callbakOnSuccess === "function") {
        callbakOnSuccess(response.data);
      }
      if (showAlert) {
        messageManager.editMessages(response);
      }
    } else {
      if (callbackOnFail && typeof callbackOnFail === "function") {
        const errorMessage = messageManager.getErrorMessage(response);
        callbackOnFail(response, errorMessage);
      }
      if (showAlert) {
        messageManager.editMessages(response);
      }
    }
  });
};

export default handleEdit;
