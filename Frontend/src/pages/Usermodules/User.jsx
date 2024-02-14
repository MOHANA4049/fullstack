// eslint-disable-next-line no-unused-vars
import React from "react";
import UserNav from '../Usermodules/UserNav';
import UserSearch from '../Usermodules/UserSearch';
import UserValue from '../Usermodules/UserValue';
import UserJob from '../Usermodules/UserJob';
import UserFooter from '../Usermodules/UserFooter';
// import JobList from 'C:/Users/mohan/jobapp/demo/src/pages/Joblist.jsx';
const User=()=>{
    return (
        <>
        <div className="container">
            <UserNav />
            <UserSearch/>
            <UserJob/>
            {/* <JobList/> */}
            <UserValue/>
            <UserFooter/>
        </div>
        </>
    )
}
export default User;