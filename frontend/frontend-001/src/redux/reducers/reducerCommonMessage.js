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
      state = { ...state, ...action.payload };
      return state;
    },
    closeCommonMessage: (state, action) => {
      state = { ...state, isMessageModalVisible: false };
      return state;
    }
  }
});

export const { openCommonMessage, closeCommonMessage } = messageSlice.actions;
export default messageSlice.reducer;
