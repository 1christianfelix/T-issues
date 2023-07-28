import React, { useState } from "react";
import Login from "./Login";
import Toast from "../../util/Toast";
import { useNavigate } from "react-router-dom";
import { useSelector, useDispatch } from "react-redux";
import {
  toastLoginSuccess,
  toastLoginFail,
  toastClear,
} from "../../store/toastSlice";

const LoginModal = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [toastLoginMsg, setToastLoginMsg] = useState("");

  const navigate = useNavigate();

  const toast = useSelector((state) => state.toast.toast);

  const dispatch = useDispatch();

  const handleUsernameChange = (e) => {
    setUsername(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (username.length && password.length) {
      window.login_modal.close();
      dispatch(toastLoginSuccess());
      window.login_modal.close();
      // navigate("/");
    } else {
      dispatch(toastLoginFail());
    }
  };
  return (
    <dialog id="login_modal" className="modal -z-30">
      <Toast></Toast>
      <Login />
      <form method="dialog" className="modal-backdrop">
        <button>close</button>
      </form>
    </dialog>
  );
};

export default LoginModal;
