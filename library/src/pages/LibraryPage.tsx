import { useEffect } from 'react'
import BookList from '../components/BookList'
import { useBooks } from '../hooks/useBooks'



function LibraryPage() {
  
  const {
    books,
    handlerRemoveBook,
    getBooks
  } = useBooks()

  useEffect(() => {
    getBooks()
  }, [])

  return (
    <>
      <div>
        <h2>Libreria</h2>
        <div>
          {books.length === 0 ?
            <div>No hay libros en el sistema</div>: 
            <BookList books = {books} handlerRemoveBook={handlerRemoveBook}/>
          }
        </div>
      </div>
    </>
  )
}

export default LibraryPage
