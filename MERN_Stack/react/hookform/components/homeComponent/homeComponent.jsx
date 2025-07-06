import React, { useState } from 'react';

import './homeComponent.css';
import UserForm from '../userForm/userForm';
import { FormData } from '../FormData/FormData';

const homeComponent = () => {

	const [firstName, setFirstName] = useState("");
	const [lastName, setLastName] = useState("");
	const [email, setEmail] = useState("");
	const [password, setPassword] = useState("");
	const [confirmPassword, setConfirmPassword] = useState("");

	
	


	return (
		<>
		
			<UserForm values={[firstName,lastName, email, password,confirmPassword]} functions={[setFirstName, setLastName, setEmail, setPassword,setConfirmPassword]}></UserForm>
			<FormData values={[firstName,lastName, email, password,confirmPassword]}></FormData>
		</>);
}

export default homeComponent;