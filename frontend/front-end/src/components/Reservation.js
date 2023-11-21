import React, { useState } from "react";
import "./styles.scss";
import { IoMdHome } from "react-icons/io";
import { MdOutlineSportsSoccer } from "react-icons/md";
import { IoPerson } from "react-icons/io5";
import { Link } from "react-router-dom";
import CustomNav from "./CustomNav";

export function Reservation(){
  return (
    <div>
      <CustomNav
        items={[
          [<IoMdHome />, "Home", "/home"],
          [<MdOutlineSportsSoccer /> ,"Reservation", "/reservation"],
          [<IoPerson /> , "Profile", "/profile"],
        ]}
      />
    </div>
  );
}

export default Reservation;