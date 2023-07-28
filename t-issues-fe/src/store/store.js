import { configureStore } from "@reduxjs/toolkit";
import toastSlice from "./toastSlice";
import { authApi } from "./authApi";

export const store = configureStore({
  reducer: {
    toast: toastSlice,
    [authApi.reducerPath]: authApi.reducer,
  },
});

export default store;
