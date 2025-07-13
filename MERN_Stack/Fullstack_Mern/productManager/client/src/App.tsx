import React from 'react'
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom'
import ProductList from 'components/ProductList'
import ProductDetail from 'components/ProductDetail'
import ProductEdit from 'components/ProductEdit'
import './styles/ProductManager.css'

const App = () => {
  return (
    <Router>
      <div className='App'>
        <Routes>
          <Route path='/products' element={<ProductList />} />
          <Route path='/products/:id' element={<ProductDetail />} />
          <Route path='/products/:id/edit' element={<ProductEdit />} />
          <Route path='/' element={<Navigate to='/products' replace />} />
        </Routes>
      </div>
    </Router>
  )
}

export default App
