import React, { useState, useContext, useEffect } from "react";
import { View, Text, Image, StyleSheet } from 'react-native';
import { ScrollView } from "react-native";
import { useWindowDimensions } from "react-native";
import { useNavigation } from "@react-navigation/native";
import { AuthContext } from "../../soccer/auth-context";
import AsyncStorage from '@react-native-async-storage/async-storage';
import CustomInput from "../../components/CustomInput";
import CustomButton from "../../components/CustomButton";
import Logo from '../../assets/Logo.png';

const SignInScreen = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [errorMessage, setErrorMessage] = useState("");

  const { height } = useWindowDimensions();

  const navigation = useNavigation();
  const authCtx = useContext(AuthContext);

  const onSignInPress = async () => {
    try {
      const response = await fetch("http://192.168.31.241:8080/auth/signin", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          email: email,
          password: password,
        }),
      });

      if (response.ok) {
        const data = await response.json();
        console.log(data);

        await AsyncStorage.setItem('authToken', data.token);
        const storedToken = await AsyncStorage.getItem('authToken');
        console.log('Token almacenado en AsyncStorage:', storedToken);

        authCtx.authenticate(storedToken);
      
        
      } else {
        const errorData = await response.json();
        setErrorMessage(errorData.message);
      }
    } catch (error) {
      console.error("Error al realizar la solicitud:", error);
    }
  };

  const onSignUpPress = () => {
    navigation.navigate("SignUp");
  }

  return (
    <ScrollView 
      showsVerticalScrollIndicator={false}
      style={styles.all}
      contentContainerStyle={styles.scrollViewContent}>
      <View style={styles.root}>
        <Image source={Logo}
          style={[styles.logo, { height: height * 0.3 }]}
          resizeMode="contain"
        />

        <CustomInput
          placeholder="Email"
          value={email}
          setValue={setEmail}
          secureTextEntry={false}
        />
        <CustomInput
          placeholder="Password"
          value={password}
          setValue={setPassword}
          secureTextEntry={true}
        />
        <CustomButton
          text="Sign In"
          onPress={onSignInPress}
          type="PRIMARY"
          bgColor="#1E90FF"
          fgColor="#FFFFFF"
        />
        <CustomButton
          text="Sign Up"
          onPress={onSignUpPress}
          type="TERTIARY"
          bgColor="#FF0000"
          fgColor="#FFFFFF"
        />

        {errorMessage !== "" && (
          <Text style={styles.errorText}>{errorMessage}</Text>
        )}
      </View>
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  all: {
    backgroundColor: "#f6f2d5",
  },
  root: {
    alignItems: 'center',
    padding: 20,
    justifyContent: 'center', // Añadido para centrar verticalmente
  },

  scrollViewContent: {
    flex: 1,
    justifyContent: 'center', // Centra el contenido verticalmente
  },

  logo: {
    width: '70%',
    maxWidth: 300,
    maxHeight: 200,
  },

  errorText: {
    color: "#FF0000",
    marginTop: 10,
  }
});

export default SignInScreen;
