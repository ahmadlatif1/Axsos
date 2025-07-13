import React, { useState, useEffect } from 'react';
import { useParams, Link, useNavigate } from 'react-router-dom';
import axios from '../utils/axios';
import '../styles/ProductManager.css';

interface Product {
    _id: string;
    title: string;
    description: string;
    price: number;
}

const ProductDetail = () => {
    const [product, setProduct] = useState<Product | null>(null);
    const { id } = useParams<{ id: string }>();
    const navigate = useNavigate();

    useEffect(() => {
        const fetchProduct = async () => {
            try {
                const response = await axios.get(`/products/${id}`);
                setProduct(response.data);
            } catch (error) {
                console.error('Error fetching product:', error);
            }
        };

        fetchProduct();
    }, [id]);

    const handleDelete = async () => {
        if (window.confirm('Are you sure you want to delete this product?')) {
            try {
                await axios.delete(`/products/${id}`);
                navigate('/products');
            } catch (error) {
                console.error('Error deleting product:', error);
            }
        }
    };

    if (!product) {
        return <div>Loading...</div>;
    }

    return (
        <div className="container">
            <Link to="/products" className="link back-link">
                ← Back to Products
            </Link>
            
            <div className="card">
                <h1>{product.title}</h1>
                <p>Description: {product.description}</p>
                <p>Price: ${product.price}</p>
                
                <div className="product-actions">
                    <Link 
                        to={`/products/${id}/edit`}
                        className="btn btn-primary link-btn"
                    >
                        Edit
                    </Link>
                    <button 
                        onClick={handleDelete}
                        className="btn btn-danger"
                    >
                        Delete
                    </button>
                </div>
            </div>
        </div>
    );
};

export default ProductDetail;
