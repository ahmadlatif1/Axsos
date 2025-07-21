
import useForm from "./useForm";


const MemberForm = ({ initialData, onSubmitProps }) => {
    const { formData, handleChange, handleSubmit, errors } = useForm({ initialData, onSubmitProps });

    


    return (
        <form className="p-4 shadow bg-white rounded" onSubmit={handleSubmit} style={{width:"300px"}} >
            <h3 className="text-center mb-4">{initialData && initialData._id ? "Edit Member" : "Create Member"}</h3>

            <div className="mb-3">
                <label className="form-label">Name: 
                <input type="text" name="name" value={formData.name} onChange={handleChange} className="form-control" /></label>
                {errors.name && <div className="text-danger">{errors.name}</div>}
            </div>

            <div className="mb-3">
                <label className="form-label">Email: 
                <input type="email" name="email" value={formData.email} onChange={handleChange} className="form-control" /></label>
                {errors.email && <div className="text-danger">{errors.email}</div>}
            </div>

            <div className="mb-3">
                
                <div style={{ display: 'flex', flexDirection:'column' }} onChange={handleChange}>
                    <label htmlFor="contactChoice1"> <input type="radio" id="contactChoice1" name="gender" value="Male" checked={formData.gender === "Male"} /> Male</label>
                    
                    <label htmlFor="contactChoice2"><input type="radio" id="contactChoice2" name="gender" value="Female" checked={formData.gender === "Female"} /> Female</label>
                    
                    <label htmlFor="contactChoice3"><input type="radio" id="contactChoice3" name="gender" value="Unspecified" checked={formData.gender === "Unspecified"} /> Prefer not to say</label>
                </div>

            </div>

            <div className="mb-3">
                <label className="form-label">Details
                <textarea name="details" value={formData.details} onChange={handleChange} className="form-control"></textarea></label>
                {errors.details && <div className="text-danger">{errors.details}</div>}
            </div>
            <div style={{display:"flex"}}> <button className="btn btn-primary w-100"> {initialData && initialData._id ? "Update" : "Create"}</button>
            <button className="btn btn-primary w-100" href="/">Cancel </button>
            </div>
            
        </form>
    );
};

export default MemberForm;
