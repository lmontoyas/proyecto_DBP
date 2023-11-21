import { View, Text, StyleSheet, SafeAreaView, TouchableOpacity, Image } from 'react-native';
import React from 'react';
import MaterialCommunityIcons from 'react-native-vector-icons/MaterialCommunityIcons';

const ExploreHeader = () => {
    return (
        <SafeAreaView style={styles.container}>
            <View style={styles.actionRow}>
                <View leftContainer>
                    <Image source = {require('../../assets/Logo.png')} style = {styles.image}/>
                </View>
                <TouchableOpacity style={styles.searchButton} onPress={() => {}}>
                    <View style={styles.buttonContent}>
                        <MaterialCommunityIcons name='magnify' size={24} color= 'black'/>
                        <View style={styles.textContainer}>
                            <Text style={styles.text}>Where to?</Text>
                            <Text style={styles.subText}>Anywhere</Text>
                        </View>
                    </View>
                </TouchableOpacity>
            </View>
        </SafeAreaView>
    );
}

const styles = StyleSheet.create ({
    container: {
        marginTop: 40,
        borderBottomWidth: 1, // Añadir una línea inferior de grosor 1
        borderBottomColor: '#e0e0e0', // Color de la línea
        
    },
    actionRow : {
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'space-between',
        paddingHorizontal: 16,
        paddingBottom: 4,
        gap: 10,
    },
    searchButton: {
        flexDirection: 'row',
        alignItems: 'center',
        gap: 8,
        borderColor: '#c2c2c2',
        borderWidth: StyleSheet.hairlineWidth,
        flex: 1,
        paddingVertical: 8,
        paddingHorizontal: 12,
        borderRadius: 30,
        backgroundColor: '#fff',

        elevation: 2,
        shadowColor: '#000',
        shadowOpacity: 0.12,
        shadowRadius: 8,
        shadowOffset: {
            width: 1,
            height: 1,
        },
        paddingRight: 10,
    },
    buttonContent: {
        flexDirection: 'row',
        alignItems: 'center',
    },
    textContainer: {
        marginLeft: 6,
    },
    text: {
        fontWeight: 'bold',
        fontSize: 12,
        color: 'black',
    },
    subText: {
        fontSize: 8,
        color: 'gray',
    },
    leftContainer: {
        flex: 1,
        alignItems: 'flex-start',
    },
    image: {
        width: 70,
        height: 70,
    }
})


export default ExploreHeader;