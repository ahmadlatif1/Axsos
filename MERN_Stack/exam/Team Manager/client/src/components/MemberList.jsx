import CreateMember from './CreateMember';
import { useEffect } from 'react';
import axios from 'axios';
import DeleteButton from "./DeleteButton";
import { useState } from 'react';

import { useNavigate } from 'react-router-dom';
const MemberList = () => {


    const [members, setMembers] = useState([]);
    const navigate = useNavigate();
    const update=()=>axios.get("http://localhost:8000/api/members")
            .then(response => {
                setMembers(response.data);
            })
            .catch(error => {
                console.error("Error fetching members:", error);
            });

    const toggleAttendance = (memberId,e) => {
        axios.patch(`http://localhost:8000/api/member/${memberId}`, { attendance: e.target.checked })
        update()
    };


    useEffect(() => {
        update();
    }, []);

    return (
        <div className="container">
            <h1>Member List</h1>
            <table className="table table-striped">
                <thead>
                    <tr>
                        <th></th>
                        <th>Name</th>
                        <th>Attendance</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {members.map(member => (
                        <tr key={member._id}>
                            <td>
                                <input type="checkbox" checked={member.attendance} onChange={(e) => toggleAttendance(member._id,e)}  />
                            </td>
                            <td><a href={`/member/${member._id}`}>{member.name}</a></td>
                            <td>{member.attendance ? "present" : "absent"}</td>
                            <td>
                                <DeleteButton memberId={member._id} />
                            </td>
                        </tr>
                    ))}
                </tbody>

            </table>
            <button className="btn btn-primary" onClick={() => navigate("/newmember")}> Add Member</button>

            <h2>Present Members</h2>
            <table className="table table-striped">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Attendance</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {members.filter(member => member.attendance).map(member => (
                        <tr key={member.id}>
                            <td><a href={`/member/${member.id}`}>{member.name}</a></td>
                            <td>{member.attendance ? "present" : "absent"}</td>
                            <td>
                                <DeleteButton memberId={member.id} />
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default MemberList;

//this page contains 2 tables, one with all members like (select attendance checkbox|name|attendance|delete)
// add member button
// and another table with all members present (name|attendance|delete)