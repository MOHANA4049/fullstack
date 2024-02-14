import '../assets/css/Log.css';
import { Link } from "react-router-dom"; 
import { FaEnvelope ,FaLock } from "react-icons/fa";
import { signIn} from '../services/auth';
import { useNavigate } from "react-router-dom";
import { useState } from 'react';
import { jwtDecode } from "jwt-decode";

const Login = () => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    const handleEmailChange = (e) => {
        setEmail(e.target.value);
    };

    const handlePasswordChange = (e) => {
        setPassword(e.target.value);
    };

    const handleFormSubmit = (e) => {
        e.preventDefault();

        const form = {
            email: email,
            password: password
        }
        signIn(form)
            .then((res) => {
                const decoded = jwtDecode(res.data.token);//
                sessionStorage.setItem('token', res.data.token);
                console.log(decoded.sub);//
                if(decoded.sub === "admin@123"){//
                setEmail("");
                setPassword("");
                navigate('/admin');
                }
                else{//
                    setEmail("");
                setPassword("");
                navigate('/user');
                }
            })
            .catch((err) => {
                setEmail("");
                setPassword("");
                console.log(err);
            });
    };

    return (
        <div className='login-main'>
            <div className="demo">
                <form action='' className='wrapper' onSubmit={handleFormSubmit}>
                    <h1 className="ok">Login</h1>
                    <div className='input-box'>
                        <input type='email' placeholder='Email' required onChange={handleEmailChange} value={email}/>
                        <FaEnvelope className='icon'/>
                    </div>
                    <div className="input-box">
                        <input type='password' placeholder='Password' required onChange={handlePasswordChange} value={password} />
                        <FaLock className='icon'/>
                    </div>
                    <div className="remember-forgot">
                        <label><input type='checkbox'/>Remember me</label>
                        <a href='#'>Forgot Password?</a>
                    </div>
                    <button type='submit' className="login-button" >Login</button>
                    <div className="register-link">
                        <p>Dont have an account?</p>
                        <a href='#'><Link to="/signup">Register</Link></a>
                    </div>
                </form>
            </div>
        </div>
    );
};

export default Login;