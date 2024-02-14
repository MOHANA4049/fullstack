import { useState, useEffect } from 'react';
import { BiTimeFive } from 'react-icons/bi';
import { getJobs } from '../../services/user';
import { Link } from 'react-router-dom';
import 'C:/Users/mohan/jobapp/demo/src/assets/css/user/userjob.css'
const UserJob = () => {
    const [jobs, setJobs] = useState([]);

    useEffect(() => {
        fetchJobs();
    }, []);

    const fetchJobs = () => {
        getJobs()
            .then(response => {
                setJobs(response.data.data);
            })
            .catch(error => {
                console.error("Error fetching jobs:", error);
            });
    };

    return (
        <div className="job-list">
            {jobs.map(job => (
                <div key={job.jobId} className="job-card">
                    <div className="job-header">
                        <h1>{job.jobTitle}</h1>
                        <div className="job-meta">
                            <BiTimeFive />
                            <span>{job.DatePosted}</span>
                        </div>
                    </div>
                    <h6>{job.jobLocation}</h6>
                    <p>{job.jobDescription}</p>
                    <button className="apply-button">
                        <Link to="/form">Apply Now</Link>
                    </button>
                </div>
            ))}
        </div>
    );
};

export default UserJob;
