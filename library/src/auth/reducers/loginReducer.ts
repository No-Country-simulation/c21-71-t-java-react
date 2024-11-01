import { Login, User } from "../../types";

type ActionType = 
    | {type: 'login', payload: User}
    | {type: 'logout'}

export const loginReducer = (state: Login, action: ActionType) => {

    switch (action.type) {
        case 'login':
            return {
                auth: true,
                user: action.payload
            };

        case 'logout':
            return {
                auth: false,
            }
    
        default:
            return state;
    }
}