import React, { useState, useEffect } from "react";
import { View, Text, StyleSheet, Image, ScrollView, FlatList } from 'react-native';

// Components
import Header from '../../components/header/Header';
import ComplexDetail from "../../api/ComplexDetail";

const Detail = ({ route }) => {
  const { complexId } = route.params;
  const [complexDetails, setComplexDetails] = useState(null);

  useEffect(() => {
    const loadComplexDetail = async () => {
      try {
        const detailData = await ComplexDetail(complexId);

        const complexData = {
          nombre: detailData.nombre,
          imagen: detailData.imagen,
          direccion: detailData.direccion,
          servicios: detailData.servicios,
          latitud: detailData.latitud,
          longitud: detailData.longitud,
          canchas: detailData.canchas,
        };

        setComplexDetails(complexData);

      } catch (error) {
        console.error("Error cargando detalles del complejo:", error);
        setComplexDetails(null);
      }
    };

    loadComplexDetail();
  }, [complexId]);

  return (
    <View style={styles.container}>
      <Header />

      {/* Mostrar detalles del complejo */}
      {complexDetails ? (
        <ScrollView>
          <View style={styles.imageContainer}>
            <Image source={{ uri: complexDetails.imagen }} style={styles.banner} />
            <Text style={styles.title}>{complexDetails.nombre}</Text>
            <Text style={styles.address}>{complexDetails.direccion}</Text>
          </View>
          <View>
            <Text style={styles.turno}>Listado Canchas</Text>
            <FlatList
                data={complexDetails.canchas}
                keyExtractor={(item) => item.id.toString()}
                renderItem={({ item }) => (
                <View style={styles.servicioItem}>
                    <Text style={styles.servicioText}>{item.nombre}</Text>
                    <Text>Precio por hora: ${item.precioHora}</Text>
                    <Text>Estado: {item.esActivo ? 'Activa' : 'Inactiva'}</Text>
                </View>
                )}
            />
          </View>
        </ScrollView>
      ) : (
        <Text>Cargando detalles...</Text>
      )}
    </View>
  );
};

const styles = StyleSheet.create({
imageContainer: {
    position: 'relative',
    },
    banner: {
    width: '100%',
    height: 200,
    resizeMode: 'cover',
    },
    title: {
    fontSize: 36,
    fontWeight: 'bold',
    position: 'absolute',
    top: '50%', // Ajusta según sea necesario
    left: 12, // Ajusta según sea necesario
    color: 'white', // Cambia el color del texto según sea necesario
    textShadowColor: 'rgba(0, 0, 0, 0.7)', // Color de la sombra
    textShadowOffset: { width: 2, height: 2 }, // Desplazamiento de la sombra
    textShadowRadius: 5, // Radio de la sombra
    },
    address: {
    fontSize: 18,
    color: 'white', // Cambia el color del texto según sea necesario
    position: 'absolute',
    textShadowColor: 'rgba(0, 0, 0, 0.7)', // Color de la sombra
    textShadowOffset: { width: 2, height: 2 }, // Desplazamiento de la sombra
    textShadowRadius: 5, // Radio de la sombra
    top: '75%', // Ajusta según sea necesario
    left: 16, // Ajusta según sea necesario
    },
  turno: {
    fontSize: 26,
    color: 'black',
    textShadowColor: 'rgba(0, 0, 0, 0.4)',
    textShadowOffset: { width: 1, height: 1 },
    textShadowRadius: 3,
    padding: 10,
  },
  servicioItem: {
    borderBottomWidth: 1,
    borderBottomColor: 'gray',
    padding: 10,
  },
  servicioText: {
    fontSize: 18,
    color: 'black',
  },
  container: {
    flex: 1,
  },
});

export default Detail;


