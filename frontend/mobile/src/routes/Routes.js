import React , {useContext}from "react";
import { View, Text, StyleSheet } from 'react-native';
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createNativeStackNativation, createNativeStackNavigator} from '@react-navigation/native-stack';
import { NavigationContainer, useNavigation } from "@react-navigation/native";
import MaterialCommunityIcons from 'react-native-vector-icons/MaterialCommunityIcons';
import AuthContextProvider, { AuthContext } from '../soccer/auth-context';
import { useEffect } from "react";
import AsyncStorage from '@react-native-async-storage/async-storage';

// Screens
import Home from '../screens/Home/Home'
import Profile from '../screens/Profile/Profile'
import Reservation from '../screens/Reservation/Reservation'
import Detail from '../screens/Detail/Detail'
import SignInScreen from "../screens/SignInScreen";
import SignUpScreen from "../screens/SignUpScreen";



const HomeNavigation = createNativeStackNavigator();

function MyDetails() {
    return (
        <HomeNavigation.Navigator

        >
            <HomeNavigation.Screen 
                name = 'HomeScreen'
                component = {Home}
                options={{headerShown: false,}}
            />
            <HomeNavigation.Screen 
                name = 'DetailScreen'
                component = {Detail}
                options={{headerShown: false,}}
            />
        </HomeNavigation.Navigator>
    )
}



const Tab = createBottomTabNavigator();

function MyTabs() {
    return (
        <Tab.Navigator
            initialRouteName="Home"
            screenOptions={{
                tabBarActiveTintColor: 'green',
            }}
        >
            <Tab.Screen 
                name = 'Home' 
                component={MyDetails}
                options={{
                    tabBarIcon: ({color,size}) => (
                        <MaterialCommunityIcons name = 'home' color={color} size = {size}/>
                    ),
                    headerShown: false,
                }}
            />
            <Tab.Screen 
                name = 'Reservation' 
                component={Reservation}
                options={{
                    tabBarLabel: 'My Reservations',
                    tabBarIcon: ({color,size}) => (
                        <MaterialCommunityIcons name = 'soccer' color={color} size = {size} />
                    ),
                    headerShown: false,
                }}  
            />
            <Tab.Screen 
                name = 'Profile' 
                component={Profile}
                options={{
                    tabBarIcon: ({color,size}) => (
                        <MaterialCommunityIcons name = 'account-circle' color={color} size = {size} />
                    ),
                    headerShown: false,
                }}
            />
        </Tab.Navigator>
    );
}


const Stack = createNativeStackNavigator();
  
function AuthStack(){
    return (
      <Stack.Navigator screenOptions={{headerShown: false}}>
        <Stack.Screen name = "SignIn" component = {SignInScreen} />
        <Stack.Screen name = "SignUp" component = {SignUpScreen} />
        <Stack.Screen name = "Tabs" component = {MyTabs} />
      </Stack.Navigator>
    );

};

export default function Routes() {
    const authCtx = useContext(AuthContext);
    
    useEffect(() => {
        const checkStoredToken = async () => {
          try {
            const storedToken = await AsyncStorage.getItem('authToken');
            if (storedToken) {
              authCtx.authenticate(storedToken);
            }
          } catch (error) {
            console.error("Error al recuperar el token:", error);
          }
        };
    
        checkStoredToken();
      }, [authCtx, useNavigation]);

    return (   
        <NavigationContainer>
          { !authCtx.isAuthenticated && <AuthStack />}
          { authCtx.isAuthenticated && <MyTabs />}
        </NavigationContainer>
    );
  }


