import { BookDetails, User } from '../types'

interface Props {
    bookDetails: BookDetails,
    bookId: number,
    handlerLoan: (bookId: number, user: User) => void
}

function BookDetail({bookDetails, bookId, handlerLoan}: Props) {

    const user = sessionStorage.getItem('login')
  return (
    

<div className="text-center w-full flex-row max-w-sm p-4 bg-white border border-gray-200 rounded-lg shadow sm:p-6 dark:bg-gray-800 dark:border-gray-700">
<h5 className="mb-3 text-base font-semibold text-gray-900 md:text-xl dark:text-white">
Detalle libro
</h5>

<ul className="my-4 space-y-3">
<li>
<a href="#" className="flex items-center p-3 text-base font-bold text-gray-900 rounded-lg bg-gray-50 hover:bg-gray-100 group hover:shadow dark:bg-gray-600 dark:hover:bg-gray-500 dark:text-white">
    <p>Titulo:</p>
<span className="flex-1 ms-3 whitespace-nowrap">{bookDetails.title}</span>
</a>
</li>
<li>
<a href="#" className="flex items-center p-3 text-base font-bold text-gray-900 rounded-lg bg-gray-50 hover:bg-gray-100 group hover:shadow dark:bg-gray-600 dark:hover:bg-gray-500 dark:text-white">
<p>Género:</p>
<span className="flex-1 ms-3 whitespace-nowrap">{bookDetails.genre}</span>
</a>
</li>
<li>
<a href="#" className="flex items-center p-3 text-base font-bold text-gray-900 rounded-lg bg-gray-50 hover:bg-gray-100 group hover:shadow dark:bg-gray-600 dark:hover:bg-gray-500 dark:text-white">
<p>Descripción:</p>
<span className="flex-1 ms-3 whitespace-nowrap text-wrap">{bookDetails.description}</span>
</a>
</li>
<li>
<a href="#" className="flex items-center p-3 text-base font-bold text-gray-900 rounded-lg bg-gray-50 hover:bg-gray-100 group hover:shadow dark:bg-gray-600 dark:hover:bg-gray-500 dark:text-white">
<p>Año:</p>
<span className="flex-1 ms-3 whitespace-nowrap">{bookDetails.year}</span>
</a>
</li>
<li>
<a href="#" className="flex items-center p-3 text-base font-bold text-gray-900 rounded-lg bg-gray-50 hover:bg-gray-100 group hover:shadow dark:bg-gray-600 dark:hover:bg-gray-500 dark:text-white">
<p>Páginas:</p>
<span className="flex-1 ms-3 whitespace-nowrap">{bookDetails.pages}</span>
</a>
</li>
<li>
<a href="#" className="flex items-center p-3 text-base font-bold text-gray-900 rounded-lg bg-gray-50 hover:bg-gray-100 group hover:shadow dark:bg-gray-600 dark:hover:bg-gray-500 dark:text-white">

<button onClick={() => handlerLoan(bookId, )} className="w-full flex justify-center py-2 px-4 border border-transparent rounded-md shadow-sm text-sm font-medium text-white bg-botonLogin hover:bg-opacity-90 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">
        Rentar
      </button>
</a>
</li>
</ul>

<div>
</div>
</div>

  )
}

export default BookDetail