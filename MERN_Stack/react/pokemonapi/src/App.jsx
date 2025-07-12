import { useState } from 'react'
import axios from 'axios';
import './App.css'

function App() {
    const [pokemon, setPokemon] = useState([]);
    const [bokemon, setBokemon] = useState([]);
    //   (async ()=> setPokemon(fetch("https://pokeapi.co/api/v2/pokemon/").results))();

    function normalfetch() {
        fetch("https://pokeapi.co/api/v2/pokemon/")
            .then(response => response.json())
            .then(text => setPokemon(text.results.map((x) => x.name)))
    }
    function axiosfetch() {
        axios.get("https://pokeapi.co/api/v2/pokemon/")
            .then(response => setBokemon(response.data.results.map((x) => x.name)))
            // .then(text => setBokemon(text.results.map((x) => x.name)))
    }


    return (
        <div style={{display:'flex'}}>
            <div>
                <button onClick={normalfetch}>fetch</button>
                <ul>{pokemon.map((x) => <li>{x}</li>)}</ul>
            </div>
            <div>
                <button onClick={axiosfetch}>fetch axios</button>
                <ul>{bokemon.map((x) => <li>{x}</li>)}</ul>
            </div>
        </div>
    )
}

export default App
