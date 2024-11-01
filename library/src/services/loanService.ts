import axios from "axios"
import { User } from "../types"

export const findLoansByUser = async (user: User) => {
    try{
        const response = await axios.get(`localhost:8080/api/v1/loans/${user.email}`)
        return response
    }catch(e){
        console.log(e)
    }
    return null
}

export const createLoan = async (book_id: number, user: User) => {
    try{
        const response = await axios.post("localhost:8080/api/v1/loans", {
            bookId: book_id,
            email: user.email
        })
        return response
    }catch(e){
        console.log(e)
    }
}

export const returnLoan = async (loanId: number) => {
    try{
        const response = await axios.post(`localhost:8080/api/v1/loans/${loanId}/return`)
        return response
    }catch(e){
        console.log(e)
    }
}