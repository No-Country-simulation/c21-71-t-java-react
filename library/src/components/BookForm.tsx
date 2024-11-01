import React from "react"
import { Book } from "../types"



interface Props {
    initialBookForm: Book,
    handlerAddBook: (book: Book) => void
}

function BookForm({ handlerAddBook, initialBookForm }: Props) {
    const [bookForm, setBookForm] = React.useState<Book>(initialBookForm)

    const onInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
            setBookForm({...bookForm, [e.target.name]: e.target.value})
    }

    const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault()
        if(!bookForm.title || !bookForm.author || !bookForm.year || !bookForm.stock){
            alert('Debe completar los campos')
            return;
        }
        // console.log(bookForm)

        //guardar el book
        handlerAddBook(bookForm)
        setBookForm(initialBookForm)
    }

  return (
    <form onSubmit={ handleSubmit }>
        <input type="text" value={bookForm.title} name="title" placeholder="title" onChange={ onInputChange }/>
        <input type="text" value={bookForm.author} name="author" placeholder="author" onChange={ onInputChange }/>
        <input type="text" value={bookForm.year} name="year" placeholder="year" onChange={ onInputChange }/>
        <input type="number" value={bookForm.stock} name="stock" placeholder="stock" onChange={ onInputChange }/>
        <button type="submit">
            Crear
        </button>
    </form>
  )
}

export default BookForm