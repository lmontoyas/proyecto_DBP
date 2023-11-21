function Validation(values){
    alert("")
    let error = {}
    const email_pattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/
    const password_pattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{8,}$/


    if (values.phone === "") {
        error.phone = "Phone should not be empty";
      } else {
        error.phone = "";
      }

    if(values.email === ""){
        error.email = "Name should not be empty"
    }
    else if(!email_pattern.test(values.email)){
        error.email = "Email incorrect"
    }else{
        error.email = ""
    }

    if(values.password === ""){
        error.password = "Password should not be empty"
    }
    else if(!password_pattern.test(values.password)){
        error.password = "Password incorrect (use a-z, A-Z, 0-9 y 8 digitos)"
    } else{
        error.password = ""
    }

    return error;


}   

export default Validation