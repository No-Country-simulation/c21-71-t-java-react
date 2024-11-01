import './App.css'
import LoginPage from './auth/pages/LoginPage'
import { useAuth } from './auth/hooks/useAuth'
import { Navigate, Route, Routes } from 'react-router-dom'
import UserRoutes from './routes/UserRoutes'
import Header from './components/layout/Header'
import RegisterPage from './pages/RegisterPage'

function App() {

  const {
    login,
    handlerLogin,
    handlerLogout
  } = useAuth()

 

  return (
    <>
    <Header />
    <Routes>
      {
        login.auth?
        ( <Route path='/*' element= {<UserRoutes login={login} handlerLogout={handlerLogout}/>}/>):
        <>
        <Route path='/login' element={<LoginPage handlerLogin={handlerLogin}/>}/>
        <Route path='/*' element={ <Navigate to={"/login"}/>}/>
        </>
      }
      <Route path='/register' element={ <RegisterPage />}/>
    </Routes>
    </>
  )
}

export default App
