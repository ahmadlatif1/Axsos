import React,{useState} from 'react';

import  './PersonCard.css';



export function PersonCard({ firstName, lastName, age, hairColor }) {


 const [currentAge, setCurrentAge] = useState(age);

  // Function to handle button click and update age
  const handleAgeIncrement = () => {
    setCurrentAge(currentAge + 1);
  };  

  return (
    <>
    <div className={"personcard"}>
      <h2 >First Name: {firstName}</h2>
      <h2 >Last Name: {lastName}</h2>
      <div >Age: {currentAge}</div>
      <div >Hair Color: {hairColor}</div>
      <button onClick={handleAgeIncrement}>
          Wish a happy birthday!
        </button>
    </div>
    </>
  );
}