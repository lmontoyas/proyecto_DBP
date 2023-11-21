import React from "react";
import {View, Text, StyleSheet} from 'react-native'
import { useState, useContext } from "react";
import CustomInput from "../../components/CustomInput";
import CustomButton from "../../components/CustomButton";
import { ScrollView } from "react-native"
import { useNavigation } from "@react-navigation/native";
import { AuthContext } from "../../soccer/auth-context";



const SignUpScreen = () => {
  const [email, setEmail] = useState('');
  const [phone, setPhone] = useState('');
  const [password, setPassword] = useState('');

  const navigation = useNavigation();
  
  const [errorMessage, setErrorMessage] = useState("");

  const authCtx = useContext(AuthContext);

  
  const onSignInPress = () => {
    navigation.navigate("SignIn")
  }

  const onSignUpPress = async () => {
    try {
        //CAMBIAR CUANDO SE SUBA A LA NUBE
      const response = await fetch("http://192.168.31.241:8080/auth/signup", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          email: email,
          phone: phone,
          password: password,
        }),
      });

      if (response.ok) {
        const data = await response.json();
        authCtx.authenticate(response.token)
        navigation.navigate("SignIn");
      } else {
        const errorData = await response.json();
        setErrorMessage(errorData.message);
        console.log("No se creo");
      }
    } catch (error) {
      console.error("Error al realizar la solicitud:", error);
    }
  };

  return (
    <ScrollView showsVerticalScrollIndicator={false}>
    <View style={styles.root}>
      
      <Text style = {styles.title}> Create an Account </Text>

      <CustomInput 
        placeholder="Email *" 
        value={email} 
        setValue={setEmail}  
        secureTextEntry={false}
      />

      <CustomInput 
        placeholder="Phone" 
        value={phone} 
        setValue={setPhone} 
        secureTextEntry={false}
      />
      <CustomInput 
        placeholder= "Password *" 
        value={password} 
        setValue={setPassword}
        secureTextEntry={true}
      />
      <CustomButton 
        text = "Sign Up"
        onPress={onSignUpPress}
        type = "PRIMARY"
        bgColor= "#1E90FF"
        fgColor= "#FFFFFF"
      />
      <CustomButton 
        text = "Sign In"
        onPress={onSignInPress}
        type = "TERTIARY"
        bgColor= "#FF0000"
        fgColor= "#FFFFFF"
      />

    {errorMessage !== "" && (
      <Text style={styles.errorText}>{errorMessage}</Text>
    )}
    </View>
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  root: {
    alignItems : 'center',
    padding: 20,
  },

  logo: {
    width: '70%',
    maxWidth: 300,
    maxHeight: 200,
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    color : "#000",
    margin: 10,  
  },
  errorText: {
    color: "#FF0000",
    marginTop: 10,
    fontSize : 20
  }
});

export default SignUpScreen;