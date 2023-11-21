import React from 'react';
import { Link } from 'react-router-dom';
import { FaSearch } from 'react-icons/fa';

const ExploreHeader = () => {
  return (
    <div style={styles.container}>
      <div style={styles.actionRow}>
        <Link to="/search" style={styles.searchButton}>
          <div style={styles.buttonContent}>
            <FaSearch name="magnify" size={24} color="black" />
            <div style={styles.textContainer}>
              <div style={styles.text}>Where to?</div>
              <div style={styles.subText}>Anywhere</div>
            </div>
          </div>
        </Link>
        <div style={styles.rightContainer}>
          <img src={"img/Logo.jpg"} alt="Logo" style={styles.image} />
        </div>
      </div>
    </div>
  );
};

const styles = {
  container: {
    marginTop: '5px',
    borderBottom: '1px solid #e0e0e0',
  },
  actionRow: {
    display: 'flex',
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    padding: '0 16px 4px',
    gap: '10px',
  },
  searchButton: {
    display: 'flex',
    flexDirection: 'row',
    alignItems: 'center',
    gap: '8px',
    border: '1px solid #c2c2c2',
    padding: '10px 450px', 
    borderRadius: '30px',
    backgroundColor: '#fff',
    boxShadow: '0 2px 5px rgba(0, 0, 0, 0.12)',
    paddingRight: '10px',
    textDecoration: 'none',
  },
  buttonContent: {
    display: 'flex',
    flexDirection: 'row',
    alignItems: 'center', 
  },
  textContainer: {
    marginLeft: '6px',
    display: "flex",
    flexDirection: "column", 
    alignItems: "flex-start", 
  },
  text: {
    fontWeight: 'bold',
    fontSize: '18px',
    color: 'black',
  },
  subText: {
    fontSize: '14px',
    color: 'gray',
  },
  rightContainer: {
    flex: 1,
    textAlign: 'right',
  },
  image: {
    width: '120px',
    height: '120px',
  },
};

export default ExploreHeader;
