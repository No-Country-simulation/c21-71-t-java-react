import { LoginForm } from "../../types"

export const loginUser = (userLogin: LoginForm) => {
    return (userLogin.email === 'admin@email.com' && userLogin.password === 'segura456')
}