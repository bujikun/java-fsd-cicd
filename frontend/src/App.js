import logo from "./logo.svg";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { useEffect, useState } from "react";
function App() {
  const [isFetching, setIsFetching] = useState(false);
  const [users, setUsers] = useState([]);

  useEffect(() => {
    const fetchUsers = async () => {
      const response = await fetch("http://localhost:9090/api/users");
      const data = await response.json();
      console.log(data);
      setUsers(data);
    };
    if (isFetching) {
      fetchUsers();
    }
  }, [isFetching]);

  const handleClick = () => {
    setIsFetching(true);
  };

  return (
    <div className="App">
      <header className="App-header">
        <h3>
          React App using a Spring Boot backend written by Newton Bujiku for
          CI/CD
        </h3>
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          <button className="btn btn-success btn-lg" onClick={handleClick}>
            Click to view a list of users from a Spring Boot backend
          </button>
          {users.length > 0 && (
            <button
              className="btn btn-danger btn-lg m-3"
              onClick={(e) => {
                setUsers([]);
                setIsFetching(false);
              }}
            >
              Clear
            </button>
          )}
        </p>
        {users.length > 0 && <UserList users={users} />}
      </header>
    </div>
  );
}

const UserList = ({ users }) => {
  console.log(users);
  return (
    <div>
      <ul className="list-group mx-5">
        {users.map((user) => (
          <li
            key={user.firstName}
            className="list-group-item list-group-item-success"
          >
            {`Name: ${user.firstName} ${user.lastName}, Age: ${user.age}`}
          </li>
        ))}
      </ul>
    </div>
  );
};
export default App;
