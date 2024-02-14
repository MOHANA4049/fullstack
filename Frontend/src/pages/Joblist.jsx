// /* eslint-disable react/prop-types */
// import { Link } from "react-router-dom";

// const JobList = () => {
//   const jobs = [
//     {
//       id: 1,
//       title: "Software Engineer",
//       description: "Develop and maintain software applications.",
//       location: "City A",
//       salary: "8-10LPA",
//     },
//     {
//       id: 2,
//       title: "Graphic Designer",
//       description: "Create visually appealing designs for various media.",
//       location: "City B",
//       salary: "5-6LPA",
//     },
//     {
//       id: 3,
//       title: "Marketing Specialist",
//       description: "Plan and execute marketing strategies.",
//       location: "City C",
//       salary: "9-12LPA",
//     },
//     {
//         id: 4,
//         title: "UL/UX Designer",
//         description: "Plan and execute designing strategies.",
//         location: "City C",
//         salary: "9-12LPA",
//       },
//       {
//         id: 5,
//         title: "Software Developer",
//         description: "Plan and develop software applications.",
//         location: "City C",
//         salary: "9-12LPA",
//       },
//       {
//         id: 6,
//         title: "Associate Engineer",
//         description: "Plan and develop software applications.",
//         location: "City C",
//         salary: "5-10LPA",
//       },
//   ];

//   return (
//     <div style={{ display: "flex", flexWrap: "wrap", justifyContent: "center" }}>
//       {jobs.map((job) => (
//         <JobCard key={job.id} job={job} />
//       ))}
//     </div>
//   );
// };

// // eslint-disable-next-line react/prop-types
// const JobCard = ({ job }) => (
//   <div style={styles.card}>
//     <div style={styles.content}>
//       <h2 style={styles.title}>{job.title}</h2>
//       <p>{job.description}</p>
//       <p>Location: {job.location}</p>
//       <p>Salary: {job.salary}</p>
//       <Link to='/form'>
//         <button style={styles.button}>APPLY NOW</button>
//       </Link>
//     </div>
//   </div>
// );

// const styles = {
//   card: {
//     width: "45%",
//     border: "1px solid #ccc",
//     borderRadius: "8px",
//     margin: "10px",
//     overflow: "hidden",
//     boxShadow: "0 4px 8px rgba(0, 0, 0, 0.1)",
//   },
//   content: {
//     padding: "10px",
//     backgroundColor:"rgba(255, 255, 255, 0.7)",
//     fontFamily: "Arial",
//   },
//   title: {
//     textAlign: "center",
//     fontSize: "20px",
//     fontStyle: "Times New Roman, serif",
//     fontWeight: "bold",
//   },
//   button: {
//     backgroundColor: "lightgreen",
//     color: "black",
//     border: "none",
//     marginTop:"20px",
//     padding: "8px 16px 8px 16px",
//     borderRadius: "50px",
//     cursor: "pointer",
//   },
// };

// export default JobList;

import{ useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { getJobs } from '../services/user';
const JobList = () => {
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
    <div style={{ display: "flex", flexWrap: "wrap", justifyContent: "center" }}>
      {jobs.map((job) => (
        <div key={job.id} style={styles.card}>
          <div style={styles.content}>
            <h2 style={styles.title}>{job.jobTitle}</h2>
            <p>{job.jobDescription}</p>
            <p>Location: {job.jobLocation}</p>
            <p>Salary: {job.Salary}</p>
            <p>Date Posted: {job.DatePosted}</p>
            <Link to='/form'>
              <button style={styles.button}>APPLY NOW</button>
            </Link>
          </div>
        </div>
      ))}
    </div>
  );
};


// const JobCard = ( job ) => (
//   <div style={styles.card}>
//     <div style={styles.content}>
//       <h2 style={styles.title}>{job.jobTitle}</h2>
//       <p>{job.jobDescription}</p>
//       <p>Location: {job.jobLocation}</p>
//       <p>Salary: {job.Salary}</p>
//       <p>Salary: {job.DatePosted}</p>
//       <Link to='/form'>
//         <button style={styles.button}>APPLY NOW</button>
//       </Link>
//     </div>
//   </div>
// );

const styles = {
  card: {
    width: "45%",
    border: "1px solid #ccc",
    borderRadius: "8px",
    margin: "10px",
    overflow: "hidden",
    boxShadow: "0 4px 8px rgba(0, 0, 0, 0.1)",
  },
  content: {
    padding: "10px",
    backgroundColor:"rgba(255, 255, 255, 0.7)",
    fontFamily: "Arial",
  },
  title: {
    textAlign: "center",
    fontSize: "20px",
    fontStyle: "Times New Roman, serif",
    fontWeight: "bold",
  },
  button: {
    backgroundColor: "lightgreen",
    color: "black",
    border: "none",
    marginTop:"20px",
    padding: "8px 16px 8px 16px",
    borderRadius: "50px",
    cursor: "pointer",
  },
};

export default JobList;

