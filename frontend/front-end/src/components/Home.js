import React from "react";
import "./styles.scss";
import { IoMdHome } from "react-icons/io";
import { MdOutlineSportsSoccer } from "react-icons/md";
import { IoPerson } from "react-icons/io5";
import CustomNav from "./CustomNav";
import ListComplexes from "./ListComplexes";
import ExploreHeader from './ExploreHeader';

export function Home () {
  return (
    <div style={styles.container}>
      <CustomNav
        items={[
          [<IoMdHome />, "Home", "/home"],
          [<MdOutlineSportsSoccer />, "Reservation", "/reservation"],
          [<IoPerson />, "Profile", "/profile"],
        ]}
      />
      <div style={styles.contentContainer}>
        <ExploreHeader />
        <ListComplexes />
      </div>
    </div>
  );
};

const styles = {
  container: {
    display: "flex",
  },
  contentContainer: {
    flex: 1,
    marginLeft: "2px",
    padding: "10px",
  },
  
  headerContainer: {
    display: "flex",
    flexDirection: "row",
    justifyContent: "space-between",
    alignItems: "center",
    padding: "10px",
    borderBottom: "1px solid #e0e0e0",
  },
};

export default Home;
