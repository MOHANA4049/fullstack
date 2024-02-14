
import Navbar from '../components/HomeNavbar';
import 'C:/Users/mohan/jobapp/demo/src/assets/css/home.css'
// import videoBg from 'C:/Users/mohan/demo/src/assets/videos/pexels-kindel-media-6774633 (2160p).mp4'
const Home=()=>{
    const jobs = [
        {
            title: 'Software Engineer',
            company: 'Example Inc.',
            description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed tempus odio vitae libero maximus, vitae consequat tortor mattis.'
        },
        {
            title: 'Data Scientist',
            company: 'Sample Corp.',
            description: 'Nulla euismod nunc eget orci commodo, ut vestibulum nunc varius. Aliquam posuere lacinia velit, nec ultricies dui gravida nec.'
        },
        {
            title: 'Web Developer',
            company: 'Tech Solutions Ltd.',
            description: 'Praesent convallis, dolor sit amet interdum faucibus, odio urna laoreet felis, eget hendrerit purus lectus a nunc.'
        },
        {
            title: 'Marketing Manager',
            company: 'Global Marketing Group',
            description: 'Vivamus nec sapien rutrum, molestie quam nec, hendrerit justo. Proin interdum, mi non interdum mattis, augue odio suscipit nisi.'
        },
        {
            title: 'Accountant',
            company: 'Finance World Inc.',
            description: 'Fusce tristique turpis vitae luctus sodales. Etiam sit amet lectus nec lorem consectetur vehicula.Maecenas hendrerit leo a velit.'
        },
        {
            title: 'UI/UX Designer',
            company: 'Creative Innovations Inc.',
            description: 'In hac habitasse platea dictumst. Maecenas hendrerit leo a velit commodo, nec lobortis velit tristique.'
        }
    ];
    return (
        <div className="container">
            <header>
                <Navbar />
            </header>
            {/* <div className="homemain">
                <video src={videoBg} autoPlay loop muted/>
            </div> */}
            <div className="Homee" style={{height:"100vh"}}>
            </div>

            <div className="section-pad">
                <div className="container">
                 <div className="row">
                    <div className="col-lg-12">
                    <div className="text-center">
                        <span id="span1" className="animate" >
                            FEATURED JOB PACKAGES
                        </span>
                        <h2 id="span" className="animate" >BROWSE TOP COMPANIES</h2>
                    </div>
                 </div>
                 </div>
                </div>
            </div>
            <div className="top">
            <div className="container">
                <div className="row justify-content-center">
                    <div className="col-xl-10">
                        <div className="text-center" id="cv-caption">
                            <p className="pera2" style={{fontWeight:'normal'}}>Elevate your Resume, seize your future.</p>
                            <a href="#" className="border-btn2" id="border-btn4">
                            Upload your CV</a>
                        </div>
                    </div>
                </div>
            </div>
            </div>
            <div className="section-pad">
                <div className="container">
                 <div className="row">
                    <div className="col-lg-12">
                    <div className="text-center">
                        <span id="span1">
                                RECENT JOBS
                        </span>
                        <h2 id="span">FEATURED JOBS</h2>
                    </div>
                 </div>
                 </div>
                </div>
            </div>
            <div className="Home" style={{ height: "100vh" }}>
                <div className="rows">
                    {jobs.map((job, index) => (
                        <div key={index} className="col-lg-4 mb-4">
                            <div className="job-details">
                                <div className="job-title">{job.title}</div>
                                <div className="job-company">{job.company}</div>
                                <div className="job-description">{job.description}</div>
                            </div>
                        </div>
                    ))}
                </div>
            </div>
            <footer className="footer">
    <div className="containers">
        <div className="rows">
            <div className="col-md-45">
                <div className="footer-section">
                    <h3>ABOUT US</h3>
                    <pre>Heaven fruitful doesnt cover lesser days 
                         appear creeping seasons so behold.</pre>
                </div>
            </div>
            <div className="col-md-45">
                <div className="footer-section">
                    <h3>CONTACT INFO</h3>
                    <p>
                        Phone: +8880 44338899 <br />
                        Email: mona@gmail.com
                    </p>
                </div>
            </div>
            <div className="col-md-45">
                <div className="footer-section">
                    <h3>IMPORTANT LINK</h3>
                    <ul>
                        <li><a href="#">View Project</a></li>
                        <li><a href="#">Contact Us</a></li>
                        <li><a href="#">Testimonial</a></li>
                        <li><a href="#">Properties</a></li>
                        <li><a href="#">Support</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</footer>

        </div>
        
            /* <div className="homemain">
                <video src={videoBg} autoPlay loop muted/>
                    </div> */
    )
}
export default Home;
