import { useState } from 'react'
import { Tab } from '../components/tab/tab'

import './App.css'

function App() {

    const tabs = [{label:"tab1",content:"hello 1"},{label:"tab2",content:"hello 2"},{label:"tab3",content:"hello 3"},]

    return (
        <>
            <Tab tabs={tabs}></Tab>
        </>
    )
}

export default App
