const base_path = 'http://192.168.31.241:8080/reserva'
import AsyncStorage from '@react-native-async-storage/async-storage';

export default async ( id ) => {
    try {
        const response = await fetch(`${base_path}?id=${id}`, {
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