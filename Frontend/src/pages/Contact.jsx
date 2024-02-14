import 'C:/Users/mohan/demo/src/assets/css/contact.css'; // Import the CSS file for styling
import Contacts from 'C:/Users/mohan/jobapp/demo/src/assets/images/contactus.jpg'
const Contact = () => {
  const styles={
     backgroundImage: `url(${Contacts})`,
      minHeight: '100vh',
      backgroundRepeat: 'no-repeat',
      backgroundSize: 'cover',
      // backgroundPosition:'relative',
      width: '70%',
  }
  return (
    <div className="con">
      <div style={styles}>
      </div>
      <div className="c2">
        <form>
          <label htmlFor="name">Your Name:</label>
          <input type="text" id="name" name="name" placeholder="Your Name" required />

          <label htmlFor="email">Your Email:</label>
          <input type="email" id="email" name="email" placeholder="Your Email" required />

          <label htmlFor="message">Your Message:</label>
          <textarea id="message" name="message" placeholder="Type your message here..." required></textarea>

          <button type="submit">Submit</button>
        </form>
      </div>
    </div>
  );
}

export default Contact;

 