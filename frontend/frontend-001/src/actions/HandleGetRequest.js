import requestManager from "./../api/RequestManager";
import messageManager from "./HandleErrorMessages";

const handleGetRequest = (endpoint, callbakOnSuccess, callbackOnFail, showAlertOnError = true) => {
  requestManager.get(endpoint, (response) => {
    if (response && response.status === 200) {
      if (callbakOnSuccess && typeof callbakOnSuccess === "function") {
        callbakOnSuccess(response.data);
      }
    } else {
      const errorMessage = messageManager.getErrorMessage();
      if (showAlertOnError) {
        messageManager.commonMessages(response);
      }
      if (callbackOnFail && typeof callbackOnFail === "function") {
        callbackOnFail(response, errorMessage);
      }
    }
  });
};

export default handleGetRequest;
