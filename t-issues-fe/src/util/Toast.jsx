import React, { useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { clearToastWithDelay } from "../store/toastSlice";
import { AiOutlineCheckCircle } from "react-icons/ai";

const Toast = () => {
  const toast = useSelector((state) => state.toast);
  const dispatch = useDispatch();

  if (!toast) {
    return null;
  }

  let toastContent;

  switch (toast.type) {
    case "success":
      toastContent = (
        <div className="toast">
          <div className="alert alert-success flex">
            <span className="text-base">
              <div className="flex items-center">
                <AiOutlineCheckCircle color="green" size="2rem" /> &nbsp;{" "}
                {toast.message}
              </div>
            </span>
          </div>
        </div>
      );
      dispatch(clearToastWithDelay(3000));
      break;
    case "error":
      toastContent = (
        <div className="toast">
          <div className="alert alert-error flex">
            <span className="text-base">
              <div className="flex items-center">
                <AiOutlineCheckCircle color="red" size="2rem" /> &nbsp;{" "}
                {toast.message}
              </div>
            </span>
          </div>
        </div>
      );
      dispatch(clearToastWithDelay(3000));
      break;
    default:
      toastContent = null;
  }

  return toastContent;
};

export default Toast;
