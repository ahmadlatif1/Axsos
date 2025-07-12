import React, { useState } from 'react';

import './tab.css';


export function Tab({ tabs }) {
	const [activeTab, setActiveTab] = useState(0);

	const handleTabClick = (index) => {
		setActiveTab(index); // Update state with clicked tab index
	};

	return (<>
		<div className='tabrow'>
			{tabs.map(({ label, content }, i) => (<div key={i}> <button onClick={() => handleTabClick(i)}>{label}</button> </div>))}
            </div>
            <div>{tabs[activeTab].content}</div>
		</>
	);
}
