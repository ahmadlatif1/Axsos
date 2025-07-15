import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Search = () => {
    const [selectedResource, setSelectedResource] = useState('people');
    const [id, setId] = useState('');
    const navigate = useNavigate();

    const handleSubmit = (e) => {
        e.preventDefault();
        navigate(`/${selectedResource}/${id}`);
    };

    return (
        <form onSubmit={handleSubmit} className="search-form">
            <div className="search-controls">
                <div className="form-group">
                    <label htmlFor="resource">Search for: </label>
                    <select 
                        id="resource"
                        value={selectedResource}
                        onChange={(e) => setSelectedResource(e.target.value)}
                    >
                        <option value="people">People</option>
                        <option value="planets">Planets</option>
                    </select>
                </div>
                <div className="form-group">
                    <label htmlFor="id">ID: </label>
                    <input
                        type="number"
                        id="id"
                        value={id}
                        onChange={(e) => setId(e.target.value)}
                        required
                        min="1"
                    />
                </div>
                <button type="submit">Search</button>
            </div>
        </form>
    );
};

export default Search;
