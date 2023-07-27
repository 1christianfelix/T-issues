import React, { useState } from "react";
import { GiHamburgerMenu } from "react-icons/gi";

import LoginModal from "./modals/LoginModal";

const Nav = () => {
  return (
    <nav className="bg-primary p-4">
      <div className="container mx-auto">
        <div className="flex items-center justify-between">
          <div className="text-white font-bold text-xl">T-issues</div>
          <div className="md:flex items-center hidden">
            <button
              className="ml-4 px-4 py-2 bg-accent rounded-md text-accent-content"
              onClick={() => window.my_modal_2.showModal()}
            >
              Login
            </button>
            <LoginModal />
          </div>
          <div className="md:hidden flex items-center">
            <div className="drawer">
              <input id="my-drawer" type="checkbox" className="drawer-toggle" />
              <div className="drawer-content">
                {/* Page content here */}
                <label
                  htmlFor="my-drawer"
                  className="btn btn-accent drawer-button"
                >
                  <GiHamburgerMenu></GiHamburgerMenu>
                </label>
              </div>
              <div className="drawer-side">
                <label htmlFor="my-drawer" className="drawer-overlay"></label>
                <ul className="menu p-4 w-80 h-full bg-base-200 text-base-content">
                  {/* Sidebar content here */}
                  <li>
                    <a>Login</a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </nav>
  );
};

export default Nav;
