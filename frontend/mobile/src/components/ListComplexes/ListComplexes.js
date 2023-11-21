import React, { useState, useEffect } from "react";
import { View, Text, ScrollView, Image, StyleSheet, TouchableOpacity } from "react-native";
import { useNavigation } from "@react-navigation/native";
import Complex from '../../api/Complex'


const ListComplexes = () => {

    const navigation = useNavigation();
    
    const [complexes, setComplexes] = useState([]);

    useEffect(() => {
        const loadComplexes = async () => {
            try {
                const loadComplexesResponse = await Complex( '', '', '' );

                const responseData = loadComplexesResponse.content;

                const complexData = responseData.map((item) => {
                    return {
                        id: item.id,
                        nombre: item.nombre,
                        direccion: item.direccion,
                        imagen: item.imagen,
                    };
                });
            setComplexes(complexData);
            
        } catch (error) {
                console.error(error);
                setComplexes([]);
            }
        };
        loadComplexes();
    }, []);

    const renderComplexes = () => {
        return complexes.map((complex, index) => (
            <TouchableOpacity key={index} style={styles.card} onPress={() => navigation.navigate('DetailScreen', { complexId: complex.id })}>
            <View style={styles.card}>
                <View style={styles.imageContainer}>
                    <Image source={{ uri: complex.imagen }} style={styles.image} />
                </View>
                <View style={styles.cardDetails}>
                <Text style={styles.title}>{complex.nombre}</Text>
                <Text style={styles.direction}>{complex.direccion}</Text>
                </View>
            </View>
            </TouchableOpacity>
        ));
      };
    
      return (
        <ScrollView contentContainerStyle={styles.scrollViewContent}>
        {renderComplexes()}
     </ScrollView>
      );
    };
    
const styles = StyleSheet.create({
    scrollViewContent: {
        flexGrow: 1,
        justifyContent: 'center',
        alignItems: 'center',
    },
    card: {
        flexDirection: 'column', 
        alignItems: 'flex-start', 
        padding: 8,
        borderRadius: 20,
    },
    imageContainer: {
        shadowColor: '#000',
        shadowOffset: { width: 0, height: 2 },
        shadowOpacity: 0.5,
        shadowRadius: 5,
        overflow: 'hidden',
    },
    image: {
        width: 320,
        height: 250,
        borderRadius: 15,
        resizeMode: 'cover',
    },
    cardDetails: {
        alignItems: 'flex-start', 
    },
    title: {
        fontWeight: 'bold',
        alignSelf: 'flex-start',
    },
    direction: {
        alignSelf: 'flex-start',
        color: 'gray',
    },
});
    
    export default ListComplexes;

