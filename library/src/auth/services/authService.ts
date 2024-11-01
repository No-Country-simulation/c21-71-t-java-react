import axios from "axios"
import { LoginForm } from "../../types"

export const loginUser = async (userLogin: LoginForm) => {
    try{
        console.log(userLogin)
        return await axios.post('http://localhost:8080/api/v1/auth/login',{
            email: userLogin.email,
            password: userLogin.password
        })
    }catch(error){
        console.log(error)
    }


}