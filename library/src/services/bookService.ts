import axios from "axios"

export const findAll = async () => {
    try{
        const response = await axios.get('http://localhost:8080/api/v1/books/test')
        return response
    }catch (error){
        console.log(error)
    }
    return null
    
}

export const findBookById = async (id: number) => {
    try{
        console.log(id)
        const response = await axios.get(`http://localhost:8080/api/v1/books/${id}`)
        return response
    }catch (error){
        console.log(error)
    }
    return null
}

export const searchBook = async (name: string, genres: number[] ) => {
    try{
        const response = await axios.get("http://localhost:8080/api/v1/books/search", {
            params: {
                term: name,
                genresIds: genres
            }
        })
        return response
    }catch(e){
        console.log(e)
    }
}