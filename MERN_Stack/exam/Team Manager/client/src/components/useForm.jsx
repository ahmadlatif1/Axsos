import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import axios from "axios";

const useForm = ({ initialData, onSubmitProps }) => {
    const [formData, setFormData] = useState(initialData);
    const [errors, setErrors] = useState({});
    const navigate = useNavigate();
    const { id } = useParams();

    useEffect(() => {
        if (id) {
            axios.get(`http://localhost:8000/api/member/${id}`)
                .then(res => setFormData(res.data))
                .catch(err => console.error("Fetch error:", err));
        } else {
            setFormData(initialData);
        }
    }, [id, initialData]);

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    const validateForm = () => {
        const formErrors = {};
        if (!formData.name.trim()) {
            formErrors.name = "Name is required";
        }
        if (!formData.email.trim()) {
            formErrors.email = "Email is required";
        } else if (!/\S+@\S+\.\S+/.test(formData.email)) {
            formErrors.email = "Email is invalid";
        }
        return formErrors;
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        const clientErrors = validateForm();
        if (Object.keys(clientErrors).length > 0) {
            setErrors(clientErrors);
            return;
        }
        onSubmitProps(formData, setErrors, setFormData);
    };

    return { formData, handleChange, handleSubmit, errors };
}
export default useForm;