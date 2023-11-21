import React from "react";
import { View, Text, Image, StyleSheet } from "react-native";

const Header = () => {
    return(
        <View style = {styles.container}>
            <View style = {styles.leftContainer}>
                <Image source = {require('../../assets/Logo.png')} style = {styles.image}/>
            </View>
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        marginTop: 25,
        flexDirection: 'row',
        alignItems: 'center',
    },
    leftContainer: {
        flex: 1,
        alignItems: 'flex-start',
    },
    image: {
        width: 70,
        height: 70,
    }
});

export default Header;