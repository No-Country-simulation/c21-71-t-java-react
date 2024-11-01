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

    const handlerLogin = (userLogin: LoginForm) => {
        const isLogin = loginUser(userLogin)
        if (isLogin){
            const user: User = {
                email: 'admin@email.com',
                name: 'Raul',
                id: 1
            }
        
            dispatch({
                type: 'login',
                payload: user
            })
            sessionStorage.setItem('login', JSON.stringify({
                auth: true,
                user: user
            }))
            navigate('/books')
        } else{
            alert("Error login")
        }
      }
    
      const handlerLogout = () => {
        dispatch({
          type: 'logout',
        })
        sessionStorage.removeItem('login')
      }
    
    return {
        login,
        handlerLogin,
        handlerLogout
    }
}