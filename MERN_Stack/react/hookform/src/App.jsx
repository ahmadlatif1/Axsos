import { useState } from 'react'

import './App.css'
import HomeComponent from '../components/homeComponent/homeComponent'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <HomeComponent></HomeComponent>
        
    </>
  )
}

export default App
