import React, { useEffect, useState } from 'react'
import BookList from '../components/BookList'
import { useBooks } from '../hooks/useBooks'
import { searchBook } from '../services/bookService'

interface Props{
  handlerBookSelected: (id: number) => void
}

interface Query {
  name: string,
  genres: number[]
}

const initialQuery: Query = {
  name: "",
  genres: []
}

function LibraryPage({handlerBookSelected}: Props) {
  
  const {
    books,
    handlerRemoveBook,
    getBooks
  } = useBooks()

  const [name, setName] = useState()
  const [genres, setGenres] = useState()
  const [query, setQuery] = useState(initialQuery)

  const onInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setQuery({...query, [e.target.name]: e.target.value})
}

const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
  e.preventDefault()
  console.log(query)
}

  useEffect(() => {
    getBooks()
    searchBook(name, genres)
  }, [])



  return (
    <>
      <div>
        <h2>Libreria</h2>
        <search>
          <label htmlFor="" >Nombre
            <input type="search" id='query' value={query.name} onChange={onInputChange} name='name'/>
            
          </label>Genres
          <label htmlFor="">
            <input type='number' name='genres' value={query.genres} onChange={onInputChange}/>
          </label>
          <button type='submit' >Buscar</button>
        </search>
        <div>
          {books.length === 0 ?
            <div>No hay libros en el sistema</div>: 
            <BookList books = {books} handlerRemoveBook={handlerRemoveBook} handlerBookSelected={handlerBookSelected}/>
          }
        </div>
      </div>
    </>
  )
}

export default LibraryPage
