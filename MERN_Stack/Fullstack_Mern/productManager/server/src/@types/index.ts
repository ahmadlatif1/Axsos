
export interface Account {
  username: string
  password: string
  role: 'user' | 'admin'
}
export interface Product {
    title: string
    description: string
    price: number
}
