import { Navigate, Route, Routes } from 'react-router-dom'
import LibraryPage from '../pages/LibraryPage'
import Navbar from '../components/layout/Navbar'
import { Login } from '../types'
import { BookProvider } from '../context/BookProvider'

interface Props {
    login: Login,
    handlerLogout: () => void
}

function UserRoutes({login, handlerLogout}: Props) {
  
  return (
    <BookProvider>
    <div>
        <Navbar login={login} handlerLogout={handlerLogout}/>
        <Routes>
            <Route path='books' element={<LibraryPage />}/>
            <Route path='/' element={<Navigate to="/books"/>}/>
        </Routes>
    </div>
    </BookProvider>
  )
}

export default UserRoutes