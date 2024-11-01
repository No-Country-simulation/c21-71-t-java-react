import { useReducer } from "react"
import { bookReducer } from "../reducers/booksReducer"
import { Book } from "../types"
import { findAll } from "../services/bookService"

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

    const getBooks = async () => {
      const result = await findAll();
      console.log(result)
      dispatch({
        type: 'loadingBooks',
        payload: result.data
      })
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

    return {
        books,
        initialBook,
        handlerAddBook,
        handlerRemoveBook,
        getBooks
    }
}