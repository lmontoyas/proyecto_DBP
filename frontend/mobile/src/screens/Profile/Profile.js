import React  from "react";
import { View, Text, StyleSheet} from 'react-native';
import AsyncStorage from '@react-native-async-storage/async-storage';
import CustomButton from "../../components/CustomButton";

//Components
import Header from '../../components/header/Header'

import { useNavigation } from '@react-navigation/native';

const Profile = () => {
    const navigation = useNavigation();
    
    const clearAsyncStorage = async () => {
        try {
          await AsyncStorage.clear();
          console.log('AsyncStorage limpiado.');
        } catch (error) {
          console.error("Error al limpiar AsyncStorage:", error);
        }
    };

    return (
        <View>
            <Header />
            <Text style = {styles.title}>Profile</Text>
            <CustomButton
                text="Logout"
                onPress={clearAsyncStorage}
                type="TERTIARY"
                bgColor="#FF0000"
                fgColor="#FFFFFF"
                />
        </View>
    );
}

const styles = StyleSheet.create({ 
    root: {
        flex: 1,
        backgroundColor: "#FFFFFF",
        padding: 20,
        alignItems: "center",
        justifyContent: "center",
    },
    title: {
        fontSize: 24,
        fontWeight: "bold",
        marginBottom: 20,
    },
});

export default Profile;