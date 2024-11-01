import { useEffect, useState } from "react"
import { useBooks } from "../hooks/useBooks"
import { createLoan } from "../services/loanService"
import { useParams } from "react-router-dom"
import BookDetail from "../components/BookDetail"



function LoanPage() {

    const [bookSelected, setBookSelected] = useState()

    const {bookId} = useParams();

    const {
        getBookById
      } = useBooks()
    
    useEffect(() => {
        console.log(bookId)
        const getBook = async () => {
            try{
                const data = await getBookById(Number(bookId))
                setBookSelected(data)
            }catch(e){
                console.log(e)
            }
        }

        getBook()
      }, [bookId])

    const handlerLoan = (bookId: number, user: User) => {
        createLoan(bookId, user)
    }

  return (
    <div className="flex items-center justify-center">
        {
            bookSelected? (
                <BookDetail bookId={bookId} bookDetails={bookSelected} handlerLoan={handlerLoan}/> 
            ) : (
                <p>Cargando datos</p>
            )
        }
    </div>
  )
}


export default LoanPage