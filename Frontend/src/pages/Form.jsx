
import { useState } from 'react';
import '../assets/css/form.css'; 
import instance from '../services/axios';
export default function Application() {
  const [formData, setFormData] = useState({
    applicantName: '',
    applicantContact: '',
    applicantEmail: '',
    workExperience: '',
    applicantSkills:'',
    resumePath:'',
  });
  
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };
  const handleSubmit = (e) => {
    e.preventDefault();
    instance.post(`http://localhost:8181/api/v1/app/postapp`,formData)
    .then(response => {
      
        console.log(response.data.data);
        console.log('Submitted data:', formData);
        alert("Form Submitted Successfully")
      })
      .catch(error => {
        console.error('Error posting user:', error);
      });
    
  };
  return (
    <div className="full">
      <div className="haii">

      </div>
      <div id="form-container">
        <form onSubmit={handleSubmit}>
          <div className="input-group">
            <label htmlFor="name">Name:</label>
            <input
              type="text"
              name="applicantName"
              id="name"
              className="input-field" value={formData.applicantName} onChange={handleInputChange}
              placeholder="Enter your full name"
              required
            />
          </div>
          <div className="input-group">
            <label htmlFor="contact">Contact:</label>
            <input
              type="tel"
              name="applicantContact"
              id="contact"
              className="input-field" value={formData.applicantContact} onChange={handleInputChange}
              placeholder="Enter your contact number"
              required
            />
          </div>
          <div className="input-group">
            <label htmlFor="email">Email:</label>
            <input
              type="email"
              name="applicantEmail"
              id="email"
              className="input-field"
              placeholder="Enter your email" value={formData.applicantEmail} onChange={handleInputChange}
              required
            />
          </div>
          <div className="input-group">
            <label htmlFor="workExperience">Work Experience:</label>
            <input
              type="text"
              name="workExperience"
              id="workExperience"
              className="input-field" value={formData.workExperience} onChange={handleInputChange}
              placeholder="Enter your work experience (if any)"required
            />
          </div>
          <div className="input-group">
            <label htmlFor="skills">Skills:</label>
            <textarea
              name="applicantSkills"
              id="skills"
              className="input-field" value={formData.applicantSkills} onChange={handleInputChange}
              placeholder="Enter your skills"required
            />
          </div>
          <div className="input-group">
            <label htmlFor="resume">Resume:</label>
            <input
              type="text"
              name="resumePath"
              id="resumePath"
              className="input-field" value={formData.resumePath} onChange={handleInputChange}
              placeholder="Enter your drive link"required
            />
          </div>
          <div className="input-group">
            <button id="submit" type="submit" onClick={{handleSubmit}}>Submit</button>
          </div>
        </form>
      </div>
    </div>
  );
}
