const initialState = () => ({
  isMessageModalVisible: false,
  messageModalTitle: "",
  messageModalBody: "",
  messageModalVariant: "success"
});

const reducer = (state = initialState(), action) => {
  switch (action.type) {
  case "OPEN":
    return {
      isMessageModalVisible: action.payload.isMessageModalVisible,
      messageModalTitle: action.payload.messageModalTitle,
      messageModalBody: action.payload.messageModalBody,
      messageModalVariant: action.payload.messageModalVariant
    };
  case "CLOSE":
    return {
      ...state,
      isMessageModalVisible: false
    };
  default:
    return state;
  }
};

const reducerMessages = {
  reducer,
  initialState
};

export default reducerMessages;
