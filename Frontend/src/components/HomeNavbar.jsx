import '../assets/css/nav.css';

const Navbar = () => {
  return (
    <nav className="navbar">
      <ul className="nav-list">
        <li className="nav-item"><a href="/user" className="nav-link">Jobs</a></li>
        <li className="nav-item"><a href="/home" className="nav-link">Home</a></li>
        <li className="nav-item"><a href="/about" className="nav-link">About</a></li>
        <li className="nav-item"><a href="/contact" className="nav-link">Contact</a></li>
        <li className="nav-item"><a href="/login" className="nav-link">Login</a></li>
        <li className="nav-item"><a href="/signup" className="nav-link">Register</a></li>
      </ul>
    </nav>
  );
};

export default Navbar;

