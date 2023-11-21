import React, {useState} from "react";
import { Link } from 'react-router-dom'; 
import './Signup.css';

export function Signup (){

    const [values, setValues] = useState({
        email: "",
        password: "",
        phone: ""
    });

    const [errors, setErrors] = useState({});
    const [errorMessage, setErrorMessage] = useState(""); 

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await fetch("http://127.0.0.1:8080/auth/signup", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(values),
            });

            console.log(response);

            if (response.status === 200) {
                const data = await response.json();
                console.log(data.message);
                setErrorMessage(data.message);
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
        <div className="signup-page d-flex justify-content-center align-items-center bg-primary vh-100">
            <div className="bg-white p-3 rounded w-25">
                <h2>Sign-Up</h2>
                <form action="" onSubmit={handleSubmit}>
                    <div className="mb-3">
                        <label htmlFor = "email"> <strong>Email* </strong></label>
                        <input type="email" placeholder="Enter Email" name='email'
                        onChange={handleInput} className="form-control rounded-0"/>
                        {errors.email && <span className='text-danger'>{errors.email}</span>}
                    </div>

                    <div className="mb-3">
                        <label htmlFor = "number"> <strong>Phone </strong></label>
                        <input type="phone" placeholder="Enter Phone" name = 'phone'
                        onChange={handleInput} className="form-control rounded-0"/>
                        {errors.phone && <span className='text-danger'>{errors.phone}</span>}
                    </div>

                    <div className="mb-3">
                        <label htmlFor = "password"><strong>Password* </strong></label>
                        <input type="password" placeholder="Enter Password" name= 'password'
                        onChange={handleInput} className="form-control rounded-0"/>
                        {errors.password && <span className='text-danger'>{errors.password}</span>}
                    </div>

                    {errorMessage && ( 
                        <div className="mb-3 text-danger">
                            {errorMessage}
                        </div>
                    )}

                    <div>
                        <button type='submit' className="btn btn-success w-100"> Signup </button>
                        <p></p>
                        <Link to ="/" className="btn btn-default border w-100 bg-light text-decoration-none"> Login </Link>
                    </div>
                </form>
            </div>
        </div>
    )
}
export default Signup;