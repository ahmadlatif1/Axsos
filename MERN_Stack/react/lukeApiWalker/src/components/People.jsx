import { useState, useEffect } from 'react';
import { useParams, Link } from 'react-router-dom';
import Error from './Error';

const People = () => {
    const [person, setPerson] = useState(null);
    const [error, setError] = useState(false);
    const { id } = useParams();

    useEffect(() => {
        fetch(`https://swapi.tech/api/people/${id}`)
            .then(response => {
                if (!response.ok) throw new Error('Person not found');
                return response.json();
            })
            .then(data => {
                setPerson(data.result.properties);
                setError(false);
            })
            .catch(err => {
                console.error('Error:', err);
                setError(true);
            });
    }, [id]);

    if (error) return <Error />;
    if (!person) return <div>Loading...</div>;

    console.log(person)

    return (
        <div className="resource-details">
            <h2>{person.name}</h2>
            <div className="details">
                <p><strong>Height:</strong> {person.height} cm</p>
                <p><strong>Mass:</strong> {person.mass} kg</p>
                <p><strong>Hair Color:</strong> {person.hair_color}</p>
                <p><strong>Skin Color:</strong> {person.skin_color}</p>
            </div>
            <Link to="/" className="back-link">Back to Search</Link>
        </div>
    );
};

export default People;
