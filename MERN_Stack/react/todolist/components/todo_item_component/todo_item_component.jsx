import { useState } from 'react'

import './todo_item_component.css';


export default function todo_item_component({ text, deletefunc }) {

const [checked, setChecked] = useState(false)

    return <div>
        <span style={{textDecoration: checked && 'line-through'}} ><b>todo:</b> {text} </span>
        <input type="checkbox" checked={checked} onChange={e=>setChecked(e.target.checked)} />
        <button onClick={deletefunc}>delete</button>
    </div>;
}
