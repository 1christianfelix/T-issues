import React, { useState } from "react";
import { AiOutlineCheckCircle } from "react-icons/ai";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [toastLoginMsg, setToastLoginMsg] = useState("");

  const handleUsernameChange = (e) => {
    setUsername(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (username.length && password.length) {
      setToastLoginMsg(
        <div className="toast">
          <div className="alert alert-success flex">
            <span className="text-base">
              <div className="flex items-center">
                <AiOutlineCheckCircle color="green" size="2rem" /> &nbsp; Login
                Successful!
              </div>
            </span>
          </div>
        </div>
      );
    } else {
      setToastLoginMsg(
        <div className="toast">
          <div className="alert alert-error flex">
            <span className="text-base">
              <div className="flex items-center">
                <AiOutlineCheckCircle color="red" size="2rem" /> &nbsp; Login
                Failed!
              </div>
            </span>
          </div>
        </div>
      );
    }
    setTimeout(() => {
      setToastLoginMsg(null);
    }, 3000);
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
