import React from "react";
import { Route, Routes } from "react-router-dom";

import Login from "./modals/Login";
import Welcome from "./Welcome";
import IssueDashboard from "./IssueDashboard";

const TissuesApp = () => {
  return (
    <div className="TodoApp h-screen w-screen">
      <Routes>
        <Route path="/" element={<IssueDashboard />} />
      </Routes>
    </div>
  );
};

export default TissuesApp;
