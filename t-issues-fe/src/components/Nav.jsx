import React, { useState } from "react";
import { GiHamburgerMenu } from "react-icons/gi";

const Nav = () => {
  const [isMenuOpen, setIsMenuOpen] = useState(false);

  const toggleMenu = () => {
    setIsMenuOpen(!isMenuOpen);
  };

  return (
    <nav className="bg-gray-800 p-4">
      <div className="container mx-auto">
        <div className="flex items-center justify-between">
          <div className="text-white font-bold text-xl">Your Logo</div>
          <div className="md:flex items-center hidden">
            <button className="ml-4 px-4 py-2 bg-blue-600 text-white rounded-md">
              Login
            </button>
          </div>
          <div className="md:hidden flex items-center">
            <div className="drawer">
              <input id="my-drawer" type="checkbox" className="drawer-toggle" />
              <div className="drawer-content">
                {/* Page content here */}
                <label
                  htmlFor="my-drawer"
                  className="btn btn-primary drawer-button"
                >
                  <GiHamburgerMenu></GiHamburgerMenu>
                </label>
              </div>
              <div className="drawer-side">
                <label htmlFor="my-drawer" className="drawer-overlay"></label>
                <ul className="menu p-4 w-80 h-full bg-base-200 text-base-content">
                  {/* Sidebar content here */}
                  <li>
                    <a>Sidebar Item 1</a>
                  </li>
                  <li>
                    <a>Sidebar Item 2</a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
        {isMenuOpen && (
          <div className="md:hidden">
            <div className="px-2 pt-2 pb-4">
              <button className="block px-4 py-2 text-white">Login</button>
            </div>
          </div>
        )}
      </div>
    </nav>
  );
};

export default Nav;
