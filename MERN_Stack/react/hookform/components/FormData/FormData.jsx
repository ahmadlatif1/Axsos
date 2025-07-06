import React from 'react';

import './FormData.css';


export function FormData({values}) {

	const [firstName,lastName, email, password,confirmPassword]=values

	return <div className='formData'>
		<span><h4>First Name:</h4> {firstName}</span>
		<span><h4> Last Name:</h4> {lastName}</span>
		<span><h4>email:</h4> {email}</span>
		<span><h4>password:</h4> {password}</span>
		<span><h4>confirm :</h4> {confirmPassword}</span>


	</div>;
}
