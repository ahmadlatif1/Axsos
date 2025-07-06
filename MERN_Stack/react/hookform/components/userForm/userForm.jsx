import React, { useState } from  'react';
    
import './userForm.css'
const userForm=({values,functions}) => {
     

    const createUser = (e) => {
        // prevent default refresh 
        e.preventDefault();
        
        // new user object, do with it as you want
        const newUser = { ...values };
        console.log("Welcome", newUser);

		for(let f of functions)f("");
    };


	const [firstName,lastName,email,password,confirmPassword]=values
	const [setFirstName,setLastName,setEmail,setPassword,setConfirmPassword]=functions
    
	const [errors, setErrors] = useState({firstName:"",lastName:"",email:"",password:"",confirmPassword:""});

	const validateFirstName = (n) => {setFirstName(n); setErrors(prev => ({...prev, firstName: n && n.length < 2 ? "first name must be more than 2 letters" : ""}));};
	const validateLastName = (n) => {setLastName(n); setErrors(prev => ({...prev, lastName: n && n.length < 2 ? "last name must be more than 2 letters" : ""}));};
	const validateEmail = (n) => {setEmail(n); setErrors(prev => ({...prev, email: n && !n.match(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/) ? "email invalid" : ""}));};
	const validatePassword = (n) => {setPassword(n); setErrors(prev => ({...prev, password: n && n.length < 8 ? "password must be 8 characters" : ""}));};
	const validateConfirmPassword = (p, c) => {setConfirmPassword(c); setErrors(prev => ({...prev, confirmPassword: c && p !== c ? "passwords must match" : ""}));};

   return(
   <form onSubmit={ createUser } className='userForm'>
       <h2>user form</h2>
       <div>
           <div>
               <label>FirstName: </label>
               <input type="text" value={firstName} onChange={ (e) => validateFirstName(e.target.value) } />
           </div>
           {errors.firstName && <p className="error">{errors.firstName}</p>}
       </div>
       <div>
           <div>
               <label>LastName: </label>
               <input type="text" value={lastName} onChange={ (e) => validateLastName(e.target.value) } />
           </div>
           {errors.lastName && <p className="error">{errors.lastName}</p>}
       </div>
       <div>
           <div>
               <label>Email Address: </label>
               <input type="text" value={email} onChange={ (e) => validateEmail(e.target.value) } />
           </div>
           {errors.email && <p className="error">{errors.email}</p>}
       </div>
       <div>
           <div>
               <label>Password: </label>
               <input type="text" value={password} onChange={ (e) => validatePassword(e.target.value) } />
           </div>
           {errors.password && <p className="error">{errors.password}</p>}
       </div>
       <div>
           <div>
               <label>Confirm Password: </label>
               <input type="text" value={confirmPassword} onChange={ (e) => validateConfirmPassword(password, e.target.value) } />
           </div>
           {errors.confirmPassword && <p className="error">{errors.confirmPassword}</p>}
       </div>
       <input type="submit" value="Create User" />
   </form>
);
};
    

export default userForm;