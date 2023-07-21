import { createSlice } from "@reduxjs/toolkit";
import { AiOutlineCheckCircle } from "react-icons/ai";
import { AiOutlineCloseCircle } from "react-icons/ai";

{
  /* <div className="toast">
          <div className="alert alert-success flex">
            <span className="text-base">
              <div className="flex items-center">
                <AiOutlineCheckCircle color="green" size="2rem" /> &nbsp;{" "}
                {toast.message}
              </div>
            </span>
          </div>
        </div> */
}

const initialState = {
  type: null,
  alert: "",
  message: "",
};

export const toastSlice = createSlice({
  name: "toastMsg",
  initialState,
  reducers: {
    toastLoginSuccess: (state) => {
      state.type = "loginSuccess";
      state.alert = "alert-success";
      state.message = (
        <>
          <AiOutlineCheckCircle color="green" size="2rem" /> &nbsp; Login
          Successful
        </>
      );
    },
    toastLoginFail: (state) => {
      state.type = "loginError";
      state.alert = "alert-error";
      state.message = (
        <>
          <AiOutlineCloseCircle color="red" size="2rem" /> &nbsp; Login Failed
        </>
      );
    },
    toastClear: (state) => {
      state.type = null;
      state.alert = "";
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
