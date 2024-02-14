import 'C:/Users/mohan/demo/src/assets/css/about.css'; // Import the CSS file for styling
import Navbar from '../components/HomeNavbar';
import aboutBackground from 'C:/Users/mohan/jobapp/demo/src/assets/images/aboutpage.jpg'; // Import the background image
const About = () => {
  const styles = {
    backgroundImage: `url(${aboutBackground})`,
    height: '100vh',
    backgroundSize: 'cover',
    backgroundRepeat: 'no-repeat'
  };
  return (
    <div style={styles}>
    <div className="fulls">
        <Navbar/>
    <div className="about-container">
        <h1>About Us</h1>
        <p>
          Welcome to our Online Job Application portal, where we connect talented individuals with exciting job opportunities. Our mission is to make the job application process seamless and efficient for both employers and applicants.
        </p>
        <p>
          At Online Jobs Portal, we strive to provide a user-friendly platform that empowers job seekers to find their dream careers and assists employers in discovering top-notch talent.
        </p>
        <p>
          Our team is dedicated to creating a positive and inclusive job search experience. Feel free to explore our portal and take the next step towards your professional journey.
        </p>
    </div>
    </div>
    </div>
  );
};

export default About;
