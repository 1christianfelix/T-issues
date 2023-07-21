import React from "react";
import { Route, Routes } from "react-router-dom";

import Login from "./Login";
import Welcome from "./Welcome";

export const TodoApp = () => {
  return (
    <div className="TodoApp h-screen w-screen">
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/" element={<Welcome />} />
      </Routes>
    </div>
  );
};
