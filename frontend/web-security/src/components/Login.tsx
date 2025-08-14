import { Link, Navigate, useNavigate } from "react-router-dom";
import { useAppDispatch, useAppSelector } from "../store/hook";
import { loginSuccess, type AuthState } from "../store/authSlice";
import { useState } from "react";

function Login() {
  const dispatch = useAppDispatch();
  const navigate = useNavigate();

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  

  const { user } = useAppSelector((state) => state.auth);

  if(user){
    return <Navigate to="/home" replace />;
  }

  const handleLogin = (e: React.FormEvent) => {
    e.preventDefault();
    console.log("handleLogin");
    const payload: AuthState = {
      user: { username, email: password },
      isCompleted: true,
    };

    dispatch(loginSuccess(payload));
    navigate("/");
  };

  return (
    <>
      <form onSubmit={handleLogin}>
        <div>
          <span>Username</span>
          <input
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            placeholder="Username"
            type="text"
          />
        </div>
        <div>
          <span>Password</span>
          <input
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            placeholder="Password"
            type="password"
          />
        </div>
        <div>
          <button type="submit">Login</button>
          <Link to="/register">Register</Link>
        </div>
      </form>
    </>
  );
}

export default Login;
