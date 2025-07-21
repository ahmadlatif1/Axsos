import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import DeleteButton from "./DeleteButton";
const DisplayMember = ({ }) => {

    const { id } = useParams();
    const navigate = useNavigate();
    const [data, setData] = useState(null);
    useEffect(() => {
        axios.get(`http://localhost:8000/api/member/${id}`)
            .then(res => setData(res.data))
            .catch(err => console.error("Fetch error:", err));
    }, [id]);

    const { name, email, gender, details } = data || {};


    return (
        <div>
            <p>Name: {name}</p>
            <p>Email: {email}</p>
            <p>Gender: {gender}</p>
            <p>Details: {details}</p>
            <button onClick={() => navigate(`/editmember/${id}`)}>Edit</button>
            <DeleteButton memberid={id} onDeleteSuccess={() => navigate("/")} />
            <button onClick={() => navigate("/")}>Back To Dashboard</button>
        </div>
    );
};

export default DisplayMember;

