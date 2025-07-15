import { useState, useEffect } from 'react';
import { useParams, Link } from 'react-router-dom';
import Error from './Error';

const Planet = () => {
    const [planet, setPlanet] = useState(null);
    const [error, setError] = useState(false);
    const { id } = useParams();

    useEffect(() => {
        fetch(`https://swapi.tech/api/planets/${id}`)
            .then(response => {
                if (!response.ok) throw new Error('Planet not found');
                return response.json();
            })
            .then(data => {
                setPlanet(data.result.properties);
                setError(false);
            })
            .catch(err => {
                console.error('Error:', err);
                setError(true);
            });
    }, [id]);

    if (error) return <Error />;
    if (!planet) return <div>Loading...</div>;

    return (
        <div className="resource-details">
            <h2>{planet.name}</h2>
            <div className="details">
                <p><strong>Climate:</strong> {planet.climate}</p>
                <p><strong>Terrain:</strong> {planet.terrain}</p>
                <p><strong>Surface Water:</strong> {planet.surface_water}</p>
                <p><strong>Population:</strong> {planet.population}</p>
            </div>
            <Link to="/" className="back-link">Back to Search</Link>
        </div>
    );
};

export default Planet;
