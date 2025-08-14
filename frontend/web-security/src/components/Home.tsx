import { Link, Navigate } from "react-router-dom";
import { useAppSelector } from "../store/hook";

function Home() {
 const { user } = useAppSelector((state) => state.auth);
 
  if(!user){
    return <Navigate to="/login" replace />;
  }
  return (
    <>
      <div>
        Xin chao, {user?.username}
      </div>
      <div>
        <Link to="/order">Quan ly don hang</Link>
      </div>
      <div>
        <Link to="/staff">Quan ly nhan vien</Link>
      </div>
    </>
  );
}

export default Home;
