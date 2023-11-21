import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";  // Cambiado a useNavigate
import Complex from './api/Complex';

const ListComplexes = () => {
  const navigate = useNavigate();  
  
  const [complexes, setComplexes] = useState([]);

  useEffect(() => {
    const loadComplexes = async () => {
      try {
        const loadComplexesResponse = await Complex();
        const responseData = loadComplexesResponse.content;

        const complexData = responseData.map((item) => ({
          id: item.id,
          nombre: item.nombre,
          direccion: item.direccion,
          imagen: item.imagen,
        }));

        setComplexes(complexData);
      } catch (error) {
        console.error("Error loading complexes", error);
        setComplexes([]);
      }
    };

    loadComplexes();
  }, []);

  const renderComplexes = () => {
    return complexes.map((complex) => (
      <div key={complex.id} style={styles.card} onClick={() => navigate(`/detail/${complex.id}`)}>
        <div style={styles.imageContainer}>
          <img src={complex.imagen} alt={complex.nombre} style={styles.image} />
        </div>
        <div style={styles.cardDetails}>
          <div style={styles.title}>{complex.nombre}</div>
          <div style={styles.direction}>{complex.direccion}</div>
        </div>
      </div>
    ));
  };

  return <div style={styles.scrollViewContent}>{renderComplexes()}</div>;
};

const styles = {
  scrollViewContent: {
    display: "flex",
    flexDirection: "row",
    flexWrap: "wrap",
    justifyContent: "center",
    alignItems: "center",
  },
  card: {
    flexDirection: "column",
    alignItems: "flex-start",
    padding: 8,
    borderRadius: 20,
    margin: 10,
    cursor: "pointer",
    boxShadow: "0 2px 5px rgba(0, 0, 0, 0.1)",
    transition: "box-shadow 0.3s ease-in-out",
    ":hover": {
      boxShadow: "0 4px 8px rgba(0, 0, 0, 0.2)",
    },
  },
  imageContainer: {
    overflow: "hidden",
    borderRadius: 15,
  },
  image: {
    width: 320,
    height: 250,
    borderRadius: 15,
    objectFit: "cover",
  },
  cardDetails: {
    alignItems: "flex-start",
    marginTop: 8,
  },
  title: {
    fontWeight: "bold",
    alignSelf: "flex-start",
    fontSize: 18,
  },
  direction: {
    alignSelf: "flex-start",
    color: "gray",
  },
};

export default ListComplexes;
