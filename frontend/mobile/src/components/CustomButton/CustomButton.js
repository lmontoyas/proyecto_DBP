import React from "react"
import {View, Text, StyleSheet, Pressable} from 'react-native'


const CustomButton = ({onPress, text, type = "PRIMARY", bgColor, fgColor}) => {
    return (
        <Pressable 
        onPress={onPress} 
        style = {[
            styles.container, 
            styles[`conatiner_${type}`],
            bgColor ? {backgroundColor: bgColor} : {}

        ]}>
        <Text 
            style = {[
                styles.text, 
                styles[`text_${type}`],
                fgColor ? {color: fgColor} : {}
            ]}
        >
            {text}
        </Text>
        </Pressable>
    );
};

const styles = StyleSheet.create({

    container:{
        width: '100%',

        padding : 15,
        marginVertical: 5,

        alignItems: 'center',
        borderRadius :5
    },

    container_PRIMARY: {
        backgroundColor : '#0000ff',
    },

    container_TERTIARY: {},

    text : {
        fontWeight : 'bold',
        color : '#000',
    },

    text_TERTIARY : {
        color: '#808080'
    }

});

export default CustomButton;