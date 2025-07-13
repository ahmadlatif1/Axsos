import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from '../utils/axios';
import '../styles/ProductManager.css';

interface Product {
    _id: string;
    title: string;
    description: string;
    price: number;
}

const ProductList = () => {
    const [products, setProducts] = useState<Product[]>([]);
    const [formData, setFormData] = useState({
        title: '',
        description: '',
        price: ''
    });

    const fetchProducts = async () => {
        try {
            const response = await axios.get('/products');
            setProducts(response.data);
        } catch (error) {
            console.error('Error fetching products:', error);
        }
    };

    useEffect(() => {
        fetchProducts();
    }, []);

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            await axios.post('/products', {
                ...formData,
                price: Number(formData.price)
            });
            setFormData({ title: '', description: '', price: '' });
            fetchProducts(); // Refresh the list
        } catch (error) {
            console.error('Error creating product:', error);
        }
    };

    const handleDelete = async (id: string) => {
        if (window.confirm('Are you sure you want to delete this product?')) {
            try {
                await axios.delete(`/products/${id}`);
                setProducts(products.filter(product => product._id !== id));
            } catch (error) {
                console.error('Error deleting product:', error);
            }
        }
    };

    const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
        setFormData(prev => ({
            ...prev,
            [e.target.name]: e.target.value
        }));
    };

    return (
        <div className="container">
            <h1 className="page-title">Product Manager</h1>
            
            <div className="card card-form">
                <h2 className="section-title">Add a New Product</h2>
                <form onSubmit={handleSubmit}>
                    <div className="form-group">
                        <label className="form-label">Title:</label>
                        <input
                            type="text"
                            name="title"
                            value={formData.title}
                            onChange={handleChange}
                            className="form-input"
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label className="form-label">Description:</label>
                        <textarea
                            name="description"
                            value={formData.description}
                            onChange={handleChange}
                            className="form-input"
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label className="form-label">Price:</label>
                        <input
                            type="number"
                            name="price"
                            value={formData.price}
                            onChange={handleChange}
                            className="form-input"
                            required
                        />
                    </div>
                    <button type="submit" className="btn btn-primary">
                        Create Product
                    </button>
                </form>
            </div>

            <h2 className="section-title">All Products</h2>
            <div className="product-grid">
                {products.map(product => (
                    <div key={product._id} className="card product-item">
                        <div className="product-info">
                            <Link to={`/products/${product._id}`} className="link">
                                <h3>{product.title}</h3>
                            </Link>
                            <p>Price: ${product.price}</p>
                        </div>
                        <div className="product-actions">
                            <Link 
                                to={`/products/${product._id}/edit`}
                                className="btn btn-small btn-primary link-btn"
                            >
                                Edit
                            </Link>
                            <button 
                                onClick={() => handleDelete(product._id)}
                                className="btn btn-small btn-danger"
                            >
                                Delete
                            </button>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default ProductList;
