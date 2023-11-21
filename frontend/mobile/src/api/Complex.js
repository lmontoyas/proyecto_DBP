const base_path = 'http://192.168.31.241:8080/complejo'
import AsyncStorage from '@react-native-async-storage/async-storage';

export default async (  pais, provincia, distrito ) => {
    try {
        const response = await fetch(`${base_path}?pais=${pais}&provincia=${provincia}&distrito=${distrito}`, {
            headers: {
                Authorization: "Bearer " + await AsyncStorage.getItem('authToken'),
            }
        });
        
        const data = await response.json()

        return Promise.resolve(data);
    } catch(err) {
        console.error("fetch error", err);
        return Promise.reject(err);
    }
}