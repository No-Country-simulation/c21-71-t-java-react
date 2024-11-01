import { useReducer, useState } from "react"
import { bookReducer } from "../reducers/booksReducer"
import { Book } from "../types"
import { findAll, findBookById } from "../services/bookService"

const initialBooks: Book[] = [
    {
        id: 1,
        title: "Nose algo",
        author: "Maria",
        year: 1996,
        stock: 3
    },
    {
      id: 2,
      title: "Marcelino ",
      author: "Cris",
      year: 2000,
      stock: 5
    },
    {
      id: 3,
      title: "La ultima leyenda",
      author: "Miguel",
      year: 2005,
      stock: 2
    }
  ]

  const initialBook: Book = {
    id: 0,
    title: "",
    author: "",
    year: 0,
    stock: 0,
}
  
export const useBooks = () => {
    const [books, dispatch] = useReducer(bookReducer, initialBooks)
    const [bookSelected, setBookSelected] = useState(1)

    const getBooks = async () => {
      const result = await findAll();
      console.log(result)
      dispatch({
        type: 'loadingBooks',
        payload: result.data.content
      })
    }

    const getBookById = async (id: number) => {
      const result = await findBookById(id)
      console.log(result)
      return result?.data
    }

    const handlerAddBook = (book: Book) => {
        console.log(book)
        dispatch({
        type: 'addBook',
        payload: book,
        })
    }

    const handlerRemoveBook = (id: number) => {
        console.log(id)
        dispatch({
        type: 'deleteBook',
        payload: id
        })
    }

    const handlerBookSelected = (id: number) => {
      console.log(id)
      setBookSelected(id)
    }

    return {
        books,
        initialBook,
        bookSelected,
        handlerAddBook,
        handlerRemoveBook,
        handlerBookSelected,
        getBooks,
        getBookById
    }
}