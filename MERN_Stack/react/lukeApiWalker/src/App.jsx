import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import Search from './components/Search'
import People from './components/People'
import Planet from './components/Planet'
import './App.css'

function App() {
  return (
    <Router>
      <div className="App">
        <h1>Star Wars API Walker</h1>
        <Search />
        <Routes>
          <Route path="/people/:id" element={<People />} />
          <Route path="/planets/:id" element={<Planet />} />
        </Routes>
      </div>
    </Router>
  )
}

export default App

