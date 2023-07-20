import React from "react";

const Login = () => {
  return (
    <div className="Login">
      <div className="LoginForm">
        <label>User Name</label>
        <input type="text" name="username" />
      </div>
      <div>
        <label>Password</label>
        <input type="password" name="password" />
      </div>
      <div>
        <button type="button" name="login">
          Login
        </button>
      </div>
    </div>
  );
};

export default Login;
