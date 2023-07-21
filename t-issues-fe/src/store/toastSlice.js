import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  type: null,
  message: "",
};

export const toastSlice = createSlice({
  name: "toastMsg",
  initialState,
  reducers: {
    toastLoginSuccess: (state) => {
      state.type = "success";
      state.message = "Login Successful!";
    },
    toastLoginFail: (state) => {
      state.type = "error";
      state.message = "Login Failed!";
    },
    toastClear: (state) => {
      state.type = null;
      state.message = "";
    },
  },
});

export const clearToastWithDelay = (delay) => (dispatch) => {
  setTimeout(() => {
    dispatch(toastClear());
  }, delay);
};

export const { toastLoginSuccess, toastLoginFail, toastClear } =
  toastSlice.actions;
export default toastSlice.reducer;
