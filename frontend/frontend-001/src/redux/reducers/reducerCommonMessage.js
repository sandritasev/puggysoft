import { createSlice } from "@reduxjs/toolkit";

const initialState = () => ({
  isMessageModalVisible: false,
  messageModalTitle: "",
  messageModalBody: "",
  messageModalVariant: "success"
});

const messageSlice = createSlice({
  name: "commonMessage",
  initialState,
  reducers: {
    openCommonMessage: (state, action) => {
      state.push(action.payload);
    },
    closeCommonMessage: (state, action) => {
      state.push(
        {
          ...state,
          isMessageModalVisible: false
        });
    }
  }
});

export const { openCommonMessage, closeCommonMessage } = messageSlice.actions;
export default messageSlice.reducer;
