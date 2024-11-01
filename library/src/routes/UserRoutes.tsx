import { Navigate, Route, Routes } from 'react-router-dom'
import LibraryPage from '../pages/LibraryPage'
import Navbar from '../components/layout/Navbar'
import { Login } from '../types'
import { BookProvider } from '../context/BookProvider'
import LoanPage from '../pages/LoanPage'
import { useBooks } from '../hooks/useBooks'

interface Props {
    login: Login,
    handlerLogout: () => void
}

function UserRoutes({login, handlerLogout}: Props) {
  
  const {
    books,
    bookSelected,
    handlerBookSelected
  } = useBooks()
  
  return (
    <BookProvider>
    <div>
        <Navbar login={login} handlerLogout={handlerLogout}/>
        <Routes>
            <Route path='books' element={<LibraryPage handlerBookSelected={handlerBookSelected}/>}/>
            <Route path='/' element={<Navigate to="/books"/>}/>
            <Route path='/loan/:bookId' element={ <LoanPage />}/>
        </Routes>
    </div>
    </BookProvider>
  )
}

export default UserRoutes