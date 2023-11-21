import React  from "react";
import { View, Text, StyleSheet, FlatList} from 'react-native';

//Components
import Header from '../../components/header/Header'
import ReservationCard from '../../components/reservationcard/ReservationCard'


const Reservation = () => {

    const reservasData = [
        { id: '1', cancha: 'Estadio Nacional', hora: '10:00 AM', activo: true },
        { id: '2', cancha: 'Parque locuto', hora: '11:30 AM', activo: false},
        { id: '3', cancha: 'Parque las Aguas', hora: '11:30 AM', activo: false},
        { id: '4', cancha: 'Praque locuto', hora: '11:30 AM', activo: false},
        { id: '5', cancha: 'Praque locuto', hora: '11:30 AM', activo: false},
        { id: '6', cancha: 'Praque locuto', hora: '11:30 AM', activo: false},
        { id: '7', cancha: 'Praque locuto', hora: '11:30 AM', activo: false},
        { id: '8', cancha: 'Praque locuto', hora: '11:30 AM', activo: false},
        { id: '9', cancha: 'Praque locuto', hora: '11:30 AM', activo: false},
        { id: '10', cancha: 'Praque locuto', hora: '11:30 AM', activo: false},
        { id: '11', cancha: 'Praque locuto', hora: '11:30 AM', activo: false},
    ];

    const renderReserveItem = ({ item }) => (
        <ReservationCard reserva = {item}/>
    );

    return (
        <View style = {styles.container}>
            <Header />
            <Text style = {styles.title}>My Reservations</Text>
            <FlatList data={reservasData} keyExtractor={(item) => item.id} renderItem={renderReserveItem} style = {styles.flatList}/>
        </View>
    );
}

export default Reservation;

const styles = StyleSheet.create({
    container: {
        flex: 1,
    },
    title: {
        fontSize: 30,
        fontWeight: 'bold',
        textAlign: 'center',
        padding: 6,
    },
    flatList: {
        flex: 0,
      }
    });