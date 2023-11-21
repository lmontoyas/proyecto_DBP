import React, { useState } from "react";
import { Link , useNavigate } from 'react-router-dom'; 
import Validation from "./LoginValidation";
import './Login.css';


export function Login(){
    const [values, setValues] = useState({
        email: "",
        password: ""
    });

    const [errorMessage, setErrorMessage] = useState(""); 
    const navigate = useNavigate();

    const [errors, setErrors] = useState({});
    const [isAuthenticated, setIsAuthenticated] = useState(false); // Nuevo estado de autenticación

    const handleSubmit = async (event) => {
        event.preventDefault();

        try {
            const response = await fetch("http://127.0.0.1:8080/auth/signin", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(values),
            });

            console.log(response);

            if (response.status === 200) {
                const data = await response.json();

                if (data.token) {
                    setIsAuthenticated(true);
                    navigate('/home');
                }

                console.log(data.token);
            } else if (response.status === 400) {
                const data = await response.json();
                console.log(data.message);
                setErrorMessage(data.message);
            } else {
            }
        } catch (error) {
            console.error(error);
        }
    }

    const handleInput = (event) => {
        setValues((prev) => ({ ...prev, [event.target.name]: event.target.value }));
    }

    return(
        <div className="login-page d-flex justify-content-center align-items-center bg-primary vh-100">
            <div className="bg-white p-3 rounded w-25"> 

                <h2>Sign-In</h2>
                <form action="" onSubmit={handleSubmit}>
                    <div className="mb-3">
                        <label htmlFor = "email"> <strong>Email </strong></label>
                        <input type="email" placeholder="Enter Email" name = 'email'
                        onChange={handleInput} className="form-control rounded-0"/>
                        {errors.email && <span className='text-danger'>{errors.email}</span>}
                    </div>
                    <div className="mb-3">
                        <label htmlFor = "password"><strong>Password</strong></label>
                        <input type="password" placeholder="Enter Password" name = 'password'
                        onChange={handleInput} className="form-control rounded-0"/>
                        {errors.password && <span className='text-danger'>{errors.password}</span>}
                    </div>

                    {errorMessage && (
                        <div className="mb-3 text-danger">
                            {errorMessage}
                        </div>
                    )}

                    <div>
                        <button type='submit' className="btn btn-success w-100"> Login </button>
                        <p></p>
                        <Link to ="/signup" className="btn btn-default border w-100 bg-light text-decoration-none"> Create Account </Link>
                    </div>
                </form>
            </div> 
        </div>
    )
}

export default Login;