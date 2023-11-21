import React  from "react";
import { View, Text, StyleSheet, SafeAreaView} from 'react-native';
import AsyncStorage from '@react-native-async-storage/async-storage';

//Components
import ListComplexes from '../../components/ListComplexes/ListComplexes';
import ExploreHeader from '../../components/exploreHeader/ExploreHeader';


const Home = () => {
    return (
        <View>
            <View>
                <ExploreHeader />
            </View>
            <ListComplexes />
        </View>
    );
}


export default Home;