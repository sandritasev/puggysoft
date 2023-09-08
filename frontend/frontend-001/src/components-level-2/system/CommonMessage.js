import React, { useReducer } from "react";
import CommonMessage from "./../../components-level-1/CommonMessage";
import reducerMessages from "./../../redux/reducers/reducerMessages";

function CommonMessagePage () {
  const [state, dispath] = useReducer(reducerMessages.reducer, reducerMessages.initialState());
  const closeCommonMessage = () => {
    dispath({ type: "CLOSE" });
  };

  return (
    <CommonMessage
      isVisible={state.isMessageModalVisible}
      setIsVisible={closeCommonMessage}
      titleText={state.messageModalTitle}
      bodyText={state.messageModalBody}
      variant={state.messageModalVariant}
    />
  );
}

export default CommonMessagePage;
