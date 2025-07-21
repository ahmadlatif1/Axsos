import './App.css';
import { Routes, Route } from 'react-router-dom';
import CreateMember from './components/CreateMember';
import DisplayMember from './components/DisplayMember.jsx';
import EditMember from './components/EditMember';
import MemberList from './components/MemberList.jsx';

const App = () => {
    return (
        <div className="container">
            <Routes>
                <Route path="/" element={<><MemberList/></>} />
                <Route path="/newmember" element={<><CreateMember/></>} />
                <Route path="/editmember/:id" element={<EditMember />} />
                <Route path="/member/:id" element={<DisplayMember />} />
            </Routes>
        </div>
    );
};

export default App;
