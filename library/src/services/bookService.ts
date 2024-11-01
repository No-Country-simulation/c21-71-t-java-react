import axios from "axios"

export const findAll = async () => {
    try{
        const response = await axios.get('http://localhost:8080/api/v1/books')
        return response
    }catch (error){
        console.log(error)
    }
    return null
    
}