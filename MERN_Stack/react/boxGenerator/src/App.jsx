import { useState } from 'react'

import './App.css'


function Box({ color = 'red', size = 100 }) {
	return (
		<div
			style={{
				width: size + 'px',
				height: size + 'px',
				backgroundColor: color,
				margin:'5px',
				borderRadius:'15%',
				order:-size
				
			}}
		/>
	);
}

function App() {
	const [boxes, setBoxes] = useState([]);
	const [color, setColor] = useState('');
	const [size, setSize] = useState(100);

	const createBox = () => {
		if (color) {
			setBoxes([...boxes, { color, size, id: Date.now() }]);
			setColor('');
		}
	}

	return (
		<div>
			<div className="stuff">
				<span>color</span>
				<input
					type="text"
					value={color}
					onChange={(e) => setColor(e.target.value)}
				/>
				<span>size</span>
				<input
					type="number"
					value={size}
					onChange={(e) => setSize((e.target.value))}
				/>
				<button onClick={createBox}>add</button>
			</div>
			<div className='boxes'>
				{boxes.map(box => (<Box key={box.id} color={box.color} size={box.size} />))}
			</div>
		</div>
	)
}

export default App
