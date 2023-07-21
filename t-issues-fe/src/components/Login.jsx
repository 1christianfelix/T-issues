import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { AiOutlineCheckCircle } from "react-icons/ai";
import { useSelector, useDispatch } from "react-redux";
import {
  toastLoginSuccess,
  toastLoginFail,
  toastClear,
} from "../store/toastSlice";

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
      // setToastLoginMsg(
      //   <div className="toast">
      //     <div className="alert alert-success flex">
      //       <span className="text-base">
      //         <div className="flex items-center">
      //           <AiOutlineCheckCircle color="green" size="2rem" /> &nbsp; Login
      //           Successful!
      //         </div>
      //       </span>
      //     </div>
      //   </div>
      // );
      navigate("/");
    } else {
      dispatch(toastLoginFail());

      // setToastLoginMsg(
      //   <div className="toast">
      //     <div className="alert alert-error flex">
      //       <span className="text-base">
      //         <div className="flex items-center">
      //           <AiOutlineCheckCircle color="red" size="2rem" /> &nbsp; Login
      //           Failed!
      //         </div>
      //       </span>
      //     </div>
      //   </div>
      // );
    }
  };

  return (
    <div className="Login h-screen w-screen">
      {toastLoginMsg}
      <form
        className="flex flex-col items-center justify-center gap-4 m-40"
        onSubmit={handleSubmit}
      >
        <div className="text-xl text-center">
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
      </form>
    </div>
  );
};

export default Login;
