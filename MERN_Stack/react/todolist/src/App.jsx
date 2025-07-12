import { useState } from 'react'
import  TodoItem  from '../components/todo_item_component/todo_item_component'
import './App.css'


function App() {
    const [items, setItems] = useState([{key:1, text:"todo item 1"},{key:2, text:"todo item 2"},{key:3, text:"todo item 3"}])

    function deletefunc (id) {return ()=> setItems(items.filter((i)=>i.key!=id))}
    function addfunc (e){
        setItems([...items,{key:items.length+1,text:e.get("text")}])
        console.log(items)
    }

    return (
        <>
            <form action={addfunc}><input type="text" name="text" id="text" placeholder='Add item' /><input type="submit" value="Add" /></form>
            {items.map((item)=><TodoItem text={item.text} deletefunc={deletefunc(item.key)}></TodoItem>)}
            
        </>
    )
}

export default App
