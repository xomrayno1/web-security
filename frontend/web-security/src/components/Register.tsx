import { Link } from "react-router-dom";

function Register() {
  return (
    <>
      <h1>Register</h1>
      <div>
        <Link to="/login">Back to login</Link>
      </div>
    </>
  )
}

export default Register;
