import { useReducer} from "react"
import { loginReducer } from "../reducers/loginReducer"
import { Login, LoginForm, User } from "../../types";
import { loginUser } from "../services/authService";
import { useNavigate } from "react-router-dom";

const initialLogin: Login = JSON.parse(sessionStorage.getItem('login') || 'null') || {
    auth: false,
  };

export const useAuth = () => {
    
    const [login, dispatch] = useReducer(loginReducer, initialLogin)
    const navigate = useNavigate()

    const handlerLogin = async (userLogin: LoginForm) => {
        const response = await loginUser(userLogin)
        console.log(response)
        const token = response?.data
        const claims = JSON.parse(window.atob(token.split(".")[1]))
        console.log(claims)
        const user: User = {
          email: claims.sub
        }
        dispatch({
            type: 'login',
            payload: user
        })
        sessionStorage.setItem('login', JSON.stringify({
            auth: true,
            user: user
        }))
        sessionStorage.setItem('token', `Bearer ${token}`)
        navigate('/books')           
        
      }
    
      const handlerLogout = () => {
        dispatch({
          type: 'logout',
        })
        sessionStorage.removeItem('login')
        sessionStorage.removeItem('token')
      }
    
    return {
        login,
        handlerLogin,
        handlerLogout
    }
}