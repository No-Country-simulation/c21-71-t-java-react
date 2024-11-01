import { Book } from "../types"

interface Props {
    book: Book,
    handlerRemoveBook: (id: number) => void
}

function BookRow({book, handlerRemoveBook}: Props) {
  return (
    <tr key={book.id}
    className="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600"
    >
        <td className="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">{book.title}</td>
        <td className="px-6 py-4">{book.author}</td>
        <td className="px-6 py-4">{book.year}</td>
        <td className="px-6 py-4">{book.stock}</td>    
        <td className="px-6 py-4">
          <button type="button" onClick={() => handlerRemoveBook(book.id)}>
            eliminar
          </button>  
        </td>           
    </tr>
  )
}

export default BookRow