import { Login } from "./components/Login"
import  { Home } from "./components/Home"
import React from 'react';
import { BrowserRouter, Routes, Route, Navigate} from 'react-router-dom'
import { Signup } from './components/Signup'
import { Barra } from './components/Navegacion/Barra'
import { Reservation } from './components/Reservation'
import './App.css';


const isAuthenticated = false; 

function PrivateRoute({ element }) {
  return isAuthenticated ? element : <Navigate to="/login" />;
}

function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path = "/" element= {<Login />}></Route>
        <Route path= "/signup" element={<Signup />}></Route>
        <Route path= "/home" element={<Home />}></Route>
        <Route path= "/reservation" element={<Reservation />}></Route>
      </Routes>
    </BrowserRouter>
    
  )
}

export default App;
