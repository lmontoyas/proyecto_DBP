import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import Routes from '../mobile/src/routes/Routes'
import AuthContextProvider from './src/soccer/auth-context';

export default function App() {
  return (
    <AuthContextProvider>
      <Routes />          
    </AuthContextProvider>
          
  );
}

