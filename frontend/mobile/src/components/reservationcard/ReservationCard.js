import React from 'react';
import { View, Text, StyleSheet } from 'react-native';

const ReservationCard = ({ reserva }) => {

  const isActive = reserva.activo;

  const cardStyle = isActive ? styles.activeCard : styles.inactiveCard;
  const textStyle = isActive ? styles.activeText : styles.inactiveText;

  return (
    <View style={[styles.cardContainer, cardStyle]}>
      <Text style={textStyle}>{`Cancha: ${reserva.cancha}`}</Text>
      <Text style={textStyle}>{`Fecha: 04/11/23`}</Text>
      <Text style={textStyle}>{`Hora: ${reserva.hora}`}</Text>
    </View>
  );
};

const styles = StyleSheet.create({
  cardContainer: {
    borderWidth: 1,
    borderRadius: 5,
    padding: 10,
    margin: 6,
    marginStart: 10,
  },
  activeCard: {
    borderColor: '#333', 
  },
  inactiveCard: {
    borderColor: 'red', 
    textDecorationLine: 'line-through',
  },
  activeText: {
    color: '#333',
  },
  inactiveText: {
    color: 'red',
  },
});

export default ReservationCard;