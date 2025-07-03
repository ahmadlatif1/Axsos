// Custom App.jsx Content
import { PersonCard } from '../components/PersonCard/PersonCard';
import './App.css';

function App() {

const people = [
	{ firstName: "John", lastName: "Doe", age: 30, hairColor: "Brown" },
	{ firstName: "Jane", lastName: "Smith", age: 25, hairColor: "Blonde" },
	{ firstName: "Bob", lastName: "Johnson", age: 35, hairColor: "Black" },
	{ firstName: "garf", lastName: "ield", age: 20, hairColor: "orange" }
];

return (
	<>
	<h2>items</h2>
	{people.map((person, index) => (
		<PersonCard key={index} {...person} />
	))}
	</>
	);
}

export default App;