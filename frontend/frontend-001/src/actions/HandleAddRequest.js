import requestManager from "./../api/RequestManager";
import messageManager from "./HandleErrorMessages";

const handleAddRequest = (endpoint, body, callbakOnSuccess, showAlert = true, callbackOnFail) => {
  requestManager.post(endpoint, body, (response) => {
    if (response && response.status === 201) {
      if (callbakOnSuccess && typeof callbakOnSuccess === "function") {
        callbakOnSuccess(response.data);
      }
      if (showAlert) {
        messageManager.addMessages(response);
      }
    } else {
      if (showAlert) {
        messageManager.commonMessages(response);
      }
      if (callbackOnFail) {
        const errorMessage = messageManager.getErrorMessage(response);
        callbackOnFail(response, errorMessage);
      }
    }
  });
};

export default handleAddRequest;
