import React, { useState } from "react";
import { Link } from "react-router-dom";
import "./styles.scss";

const CustomNav = ({ items }) => {
    const [window, setWindow] = useState(false);

  return (
    <nav className="navbar-menu" style={{ width: window === false ? 250 : 60 }}>
      <div className="burger">
        <img src="img/menu.svg" alt="burger" />
      </div>
      <ul className="navbar__list">
        <div
          className="profile"
          style={{
            alignItems: "center",
            display: "flex",
            justifyContent: "left",
            paddingTop: 10
          }}
        >
          <img
            src="img/profile.jpg"
            alt="profile"
            style={{
              width: "180px",
              height: "180px"
            }}
          />
        </div>
        {items.map((item, i) => (
          <Link to={item[2]} key={i} className="navbar__li-box">
            <div>
              {item[0]}
              <li
                className="navbar__li"
                style={{
                  display: window === false ? "inline-block" : "none",
                  paddingLeft: window === false ? 27 : 17
                }}
              >
                {item[1] }
              </li>
            </div>
          </Link>
        ))}
      </ul>
    </nav>
  );
};

export default CustomNav;
