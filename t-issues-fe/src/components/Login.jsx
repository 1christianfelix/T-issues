import React, { useState } from "react";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleUsernameChange = (e) => {
    setUsername(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleLogin = () => {
    // Do your login logic here using the 'username' and 'password' state values
    console.log("Username:", username);
    console.log("Password:", password);
  };

  return (
    <div className="Login h-screen w-screen">
      <div className="flex flex-col items-center justify-center gap-4 m-40">
        <div className="text-xl text-center">
          <div>Login</div>
        </div>
        <div className="LoginForm">
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
            type="button"
            name="login"
            className="btn btn-sm btn-info text-white"
            onClick={handleLogin}
          >
            Login
          </button>
        </div>
      </div>
    </div>
  );
};

export default Login;
