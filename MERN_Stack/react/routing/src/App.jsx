import { useState } from 'react'
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom'
import { useParams } from 'react-router-dom'
import './App.css'

const Home = () => {
  return <h1>Welcome</h1>
}

const Number = () => {
  const { number } = useParams()
  if (isNaN(number)) {
    return <Navigate to={`/word/${number}`} />
  }
  return <h1>The number is: {number}</h1>
}

const Word = () => {
  const { word } = useParams()
  if (!isNaN(word)) {
    return <Navigate to={`/${word}`} />
  }
  return <h1>The word is: {word}</h1>
}

const StyledWord = () => {
  const { word, textColor, bgColor } = useParams()
  return (
    <h1 style={{ 
      color: textColor, 
      backgroundColor: bgColor,
      padding: '20px',
      borderRadius: '5px'
    }}>
      {word}
    </h1>
  )
}

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/home" element={<Home />} />
        <Route path="/:number" element={<Number />} />
        <Route path="/word/:word" element={<Word />} />
        <Route path="/:word/:textColor/:bgColor" element={<StyledWord />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
