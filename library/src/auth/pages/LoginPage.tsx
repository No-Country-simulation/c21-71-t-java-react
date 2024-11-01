import React, { useState } from "react"
import { LoginForm } from "../../types"
import { useNavigate } from "react-router-dom"

const initialLoginForm: LoginForm = {
    email: "",
    password: ""
}

interface Props {
    handlerLogin: (userLogin: LoginForm) => void
}

function LoginPage({ handlerLogin }: Props) {

    const [loginForm, setLoginForm] = useState(initialLoginForm)
    const navigate = useNavigate()

    const onInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const {name, value} = e.target
        setLoginForm({
            ...loginForm,
            [ name ]: value
        })
    }

    const toRegister = () => {
      navigate('/register')
    }

    const onSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault()
        if (!email || !password){
            alert("Debes completar los campos")
            return
        }

        //aca se implementa el login
        handlerLogin({email, password})
       

        setLoginForm(initialLoginForm)
    }

    const {email, password} = loginForm
  return (
    // <div className="min-h-screen flex items-center justify-center w-full dark:bg-gray-950">
	// <div className="bg-cafeOscuro dark:bg-gray-900 shadow-md rounded-lg px-8 py-6 max-w-md">
	// 	<h1 className="text-2xl text-brown font-bold text-center mb-4 dark:text-gray-200">Welcome Back!</h1>
	// 	<form onSubmit={ onSubmit }>
	// 		<div className="mb-4">
	// 			<label  className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">Email Address</label>
	// 			<input 
    //             type="email" 
    //             id="email" 
    //             name="email"
    //             className="shadow-sm rounded-md w-full px-3 py-2 border border-gray-300 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" 
    //             placeholder="your@email.com"
    //             value={email}
    //             onChange={  onInputChange }
    //             required />
	// 		</div>
	// 		<div className="mb-4">
	// 			<label  className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">Password</label>
	// 			<input 
    //             type="password" 
    //             id="password" 
    //             name="password"
    //             className="shadow-sm rounded-md w-full px-3 py-2 border border-gray-300 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" 
    //             placeholder="Enter your password" 
    //             value={password}
    //             onChange={  onInputChange }
    //             required />
	// 			<a href="#"
	// 				className="text-xs text-gray-600 hover:text-indigo-500 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Forgot
	// 				Password?</a>
	// 		</div>
	// 		<div className="flex items-center justify-between mb-4">
	// 			{/* <div className="flex items-center">
	// 				<input type="checkbox" id="remember" className="h-4 w-4 rounded border-gray-300 text-indigo-600 focus:ring-indigo-500 focus:outline-none" checked />
	// 				<label className="ml-2 block text-sm text-gray-700 dark:text-gray-300">Remember me</label>
	// 			</div> */}
	// 			<a href="#"
	// 				className="text-xs text-indigo-500 hover:text-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Create
	// 				Account</a>
	// 		</div>
	// 		<button  type="submit" className="w-full flex justify-center py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Login</button>
	// 	</form>
	//     </div>
    // </div>
    <div className="min-h-screen flex items-center justify-center w-full bg-claro dark:bg-gray-950">
  <div className="bg-cafeOscuro dark:bg-gray-900 shadow-md rounded-lg px-8 py-6 max-w-md">
    <h1 className="text-2xl font-bold text-center mb-4 text-textoClaro dark:text-gray-200">Ingresa aqui!</h1>
    <form onSubmit={onSubmit}>
      <div className="mb-4">
        <label className="block text-sm font-medium text-textoClaro dark:text-gray-300 mb-2">Email Address</label>
        <input 
          type="email" 
          id="email" 
          name="email"
          className="shadow-sm rounded-md w-full px-3 py-2 border border-gray-300 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" 
          placeholder="your@email.com"
          value={email}
          onChange={onInputChange}
          required 
        />
      </div>
      <div className="mb-4">
        <label className="block text-sm font-medium text-textoClaro dark:text-gray-300 mb-2">Password</label>
        <input 
          type="password" 
          id="password" 
          name="password"
          className="shadow-sm rounded-md w-full px-3 py-2 border border-gray-300 focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" 
          placeholder="Enter your password" 
          value={password}
          onChange={onInputChange}
          required 
        />
        <a href="#" className="text-xs text-textoClaro hover:text-indigo-500 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Forgot Password?</a>
      </div>
      <div className="flex items-center justify-between mb-4">
        <a href="/register" onClick={toRegister} className="text-xs text-indigo-500 hover:text-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">Create Account</a>
      </div>
      <button type="submit" className="w-full flex justify-center py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-botonLogin hover:bg-opacity-90 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">
        Iniciar Sesion
      </button>
    </form>
  </div>
</div>

  )
}

export default LoginPage