import { BookContext } from "./BookContext"

export const BookProvider = ({children}) => {
    return (
        <BookContext.Provider value={
            {
                
            }
        }>
            {children}
        </BookContext.Provider>
    )
}