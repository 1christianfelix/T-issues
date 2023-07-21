import React from "react";
import { useSelector, useDispatch } from "react-redux";
import { clearToastWithDelay } from "../store/toastSlice";

const Toast = () => {
  const toast = useSelector((state) => state.toast);
  const dispatch = useDispatch();

  switch (toast.type) {
    case "loginSuccess":
      dispatch(clearToastWithDelay(3000));
      break;
    case "loginError":
      dispatch(clearToastWithDelay(3000));
      break;
    default:
      break;
  }

  return (
    toast.type && (
      <div className="toast">
        <div className={`alert ${toast.alert} flex`}>
          <span className="text-base">
            <div className="flex items-center">{toast.message}</div>
          </span>
        </div>
      </div>
    )
  );
};

export default Toast;
