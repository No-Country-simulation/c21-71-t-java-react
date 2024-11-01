import { Book } from "../types";

type ActionType = 
   | {type: 'addBook', payload: Book}
   | {type: 'deleteBook', payload: number}
   | {type: 'updateBoo'}
   | {type: 'loadingBooks', payload: Book[]}


export const bookReducer = (state: Book[], action: ActionType) => {

    switch (action.type) {
        case 'addBook':
            return [
                ...state, 
                {
                    ...action.payload,
                    id: new Date().getTime()
                }
            ]

        case 'deleteBook':
            return state.filter(book => book.id != action.payload)
            
        case 'loadingBooks':
            return action.payload
        default:
            return state;
    }
}