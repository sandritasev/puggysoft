import { configureStore } from "@reduxjs/toolkit";

import commonMessageReducer from "./../reducers/reducerCommonMessage";

export const store = configureStore({
  reducer: { commonMessage: commonMessageReducer }
});
