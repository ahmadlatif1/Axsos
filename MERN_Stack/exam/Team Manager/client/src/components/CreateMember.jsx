import axios from "axios";
import { Link,useNavigate } from "react-router-dom";
import MemberForm from "./MemberForm";

const CreateMember = () => {
        const navigate = useNavigate();
    
    const handleCreate = (formData, setErrors, resetForm) => {
        axios.post("http://localhost:8000/api/member", formData)
            .then((res) => {
                console.log("✅ member created:", res.data);
                resetForm({name:"", email:"", gender:"unspecified", details:""})
                navigate ("/")
            })
            .catch((err) => {
                if (err.response?.data?.errors) {
                    const fieldErrors = {};
                    for (let key in err.response.data.errors) {
                        fieldErrors[key] = err.response.data.errors[key].message;
                    }
                    setErrors(fieldErrors);
                } else {
                    console.error("❌ Server error:", err);
                }
            });
    }

    return (
        <>
            <Link to={`/`} className="btn btn-warning btn-sm me-2">Home</Link>
            <MemberForm
                initialData={{name:"", email:"", gender:"Unspecified", details:""}}
                onSubmitProps={handleCreate}
            />
        </>
    )
}
export default CreateMember;