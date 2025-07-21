import axios from "axios";

const DeleteButton = ({ memberid, onDeleteSuccess }) => {
    const handleDelete = () => {
        if (!window.confirm("Are you sure you want to delete this Member?")) return;

        axios
            .delete(`http://localhost:8000/api/member/${memberid}`)
            .then(() => onDeleteSuccess(memberid))
            .catch(err => console.error("❌ Delete error:", err));
    };

    return (
        <button className="btn btn-danger btn-sm" onClick={handleDelete}>
            Delete
        </button>
    );
};

export default DeleteButton;