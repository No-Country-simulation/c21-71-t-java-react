export interface Book {
    id: number,
    title: string,
    author: string,
    year: number,
    stock: number
}

export interface LoginForm {
    email: string,
    password: string
}

export interface Login {
    auth: boolean,
    user?: User
}

export interface User {
    id: number,
    name: string,
    email: string,
}

export interface Register {
    name: string,
    lastName: string,
    email: string,
    password: string
}