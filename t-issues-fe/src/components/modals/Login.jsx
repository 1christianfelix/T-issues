import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { AiOutlineCheckCircle } from "react-icons/ai";
import { useSelector, useDispatch } from "react-redux";
import {
  toastLoginSuccess,
  toastLoginFail,
  toastClear,
} from "../../store/toastSlice";

const Login = () => {
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
      dispatch(toastLoginSuccess());
      window.login_modal.close();
      // navigate("/");
    } else {
      dispatch(toastLoginFail());
    }
  };

  return (
    <form method="dialog" className="modal-box" onSubmit={handleSubmit}>
      <div className="Login">
        {/* {toastLoginMsg} */}
        <div className="flex flex-col items-center justify-center gap-4">
          <div className="text-3xl text-center">
            <div>Login</div>
          </div>
          <div>
            <label className="label">
              <span className="label-text text-base">Username</span>
            </label>
            <input
              type="text"
              placeholder="Username"
              className="input input-bordered input-info input-sm w-full max-w-xs"
              value={username}
              onChange={handleUsernameChange}
            />
          </div>
          <div>
            <label className="label">
              <span className="label-text text-base">Password</span>
            </label>
            <input
              type="password"
              placeholder="Password"
              className="input input-bordered input-info input-sm w-full max-w-xs"
              value={password}
              onChange={handlePasswordChange}
            />
          </div>
          <div>
            <button
              type="submit"
              name="login"
              className="btn btn-sm btn-info text-white"
            >
              Login
            </button>
          </div>
        </div>
      </div>
    </form>
  );
};

export default Login;
