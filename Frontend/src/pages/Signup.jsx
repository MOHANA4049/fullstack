// import '../assets/css/signup.css'
// import { Link } from 'react-router-dom';
// import { FaUser, FaLock, FaEnvelope } from 'react-icons/fa';
// export default function Signup() {
//   return (
//     <div className='signup-main'>
//       <div className="demos">
//         <form action='' className='signup-wrapper'>
//           <h1>Sign Up</h1>
//           <div className='signup-input-box'>
//             <input type='text' placeholder='Name' required />
//             <FaUser className='signup-icon' />
//           </div>
//           <div className='signup-input-box'>
//             <input type='email' placeholder='Email' required />
//             <FaEnvelope className='signup-icon' />
//           </div>
//           <div className='signup-input-box'>
//             <input type='password' placeholder='Password' required />
//             <FaLock className='signup-icon' />
//           </div>
//           <button type='submit' className='signup-button'>Sign Up</button>
//           <div className='signup-register-link'>
//             <p>Already have an account?</p>
//             <Link to="/login">Login</Link>
//           </div>
//         </form>
//       </div>
//     </div>
//   );
// }
import '../assets/css/signup.css';
import { Link } from 'react-router-dom';
import { FaUser, FaLock, FaEnvelope } from 'react-icons/fa';
import { useNavigate } from "react-router-dom";
import { useState } from 'react';
import { signUp } from '../services/auth';
const Signup = () => {
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
    const navigate = useNavigate();

    const handleNameChange = (e) => {
        setName(e.target.value);
    };

    const handleEmailChange = (e) => {
        setEmail(e.target.value);
    };

    const handlePasswordChange = (e) => {
        setPassword(e.target.value);
    };

    const handleConfirmPasswordChange = (e) => {
        setConfirmPassword(e.target.value);
    };
    const handleSignUp = () => {
        if (password !== confirmPassword) {
            console.log("Passwords do not match");
            return;
        }

        const form = {
            name: name,
            email: email,
            password: password
        };

        signUp(form)
            .then(() => {
                setName("");
                setEmail("");
                setPassword("");
                setConfirmPassword("");
                navigate('/login');
            })
            .catch((err) => {
                console.log(err);
            });
    };

    return (
        <div className='signup-main'>
            <div className="demos">
                <form action='' className='signup-wrapper'>
                    <h1>Sign Up</h1>
                    <div className='signup-input-box'>
                        <input type='text' placeholder='Name' required onChange={handleNameChange} value={name} />
                        <FaUser className='signup-icon' />
                    </div>
                    <div className='signup-input-box'>
                        <input type='email' placeholder='Email' required onChange={handleEmailChange} value={email} />
                        <FaEnvelope className='signup-icon' />
                    </div>
                    <div className='signup-input-box'>
                        <input type='password' placeholder='Password' required onChange={handlePasswordChange} value={password} />
                        <FaLock className='signup-icon' />
                    </div>
                    <div className="signup-input-box">
                    <input type='password' placeholder='Confirm Password' value={confirmPassword} onChange={handleConfirmPasswordChange} required />
                    <FaLock className='icon' />
                </div>
                    <button type='button' className='signup-button' onClick={handleSignUp}>Sign Up</button>
                    <div className='signup-register-link'>
                        <p>Already have an account?</p>
                        <Link to="/login">Login</Link>
                    </div>
                </form>
            </div>
        </div>
    );
};
export default Signup;