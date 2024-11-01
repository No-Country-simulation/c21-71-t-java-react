import { Book } from "../types"
import BookRow from "./BookRow"


interface Props {
    books: Book[],
    handlerRemoveBook: (id: number) => void
    handlerBookSelected: (id: number) => void
}

function BookList({books, handlerRemoveBook, handlerBookSelected}: Props) {

  return (
    <div className="relative overflow-x-auto shadow-md sm:rounded-lg">
    <table  className="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
        <thead className="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
            <th className="px-6 py-3">Titulo</th>
            <th className="px-6 py-3">Autor</th>
            <th className="px-6 py-3">Año</th>
            <th className="px-6 py-3">Unidades Disponibles</th>
            <th className="px-6 py-3">En prestamo</th>
        </thead>
        <tbody>
            {
                books.map( book => {
                    return(
                        <BookRow key={book.id} book={book} handlerRemoveBook = {handlerRemoveBook} handlerBookSelected={handlerBookSelected}/>
                    ) 
                })
            }
        </tbody>
    </table>
    </div>
  )
}

export default BookList