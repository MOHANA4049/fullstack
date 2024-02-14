import '../assets/css/Log.css'
export default function Logs(){
    return(

<>
  <meta charSet="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Login Page</title>
  <link rel="stylesheet" href="../CSS/style.css" />
  <div className="main">
    <h1 className="heading">Welcome to Job Portal</h1>
    <div className="form-box">
      <div className="button-box">
        <div id="btn" />
        <button type="button" className="toggle-btn" onClick="login()">
          Log in
        </button>
        <button type="button" className="toggle-btn" onClick="register()">
          Register
        </button>
      </div>
      <form id="login" className="input-group">
        <input type="text" className="input-field" placeholder="User Name" />
        <input
          type="password"
          className="input-field"
          placeholder="Enter Password"
        />
        <input type="checkbox" className="check-box" />{" "}
        <span> Remember Password </span>
        <button type="submit" className="submit-btn">
          Log In
        </button>
      </form>
      <form id="register" className="input-group">
        <input type="text" className="input-field" placeholder="User Name" />
        <input type="email" className="input-field" placeholder="Email-Id" />
        <input
          type="password"
          className="input-field"
          placeholder="Enter Password"
        />
        <input type="checkbox" className="check-box" />
        <span> I agree to the terms &amp; conditions</span>
        <button type="submit" className="submit-btn">
          Register
        </button>
      </form>
    </div>
  </div>
</>

    )
}

