import './App.css';
import MainRoute from "./routes/MainRoute";



function App() {

    return (
        <div className="App">
            <MainRoute/>
            <h1>Welcome to Notes-App</h1>
            <h3><a href="http://localhost:3000/register"> Register </a></h3>
            <h3><a href="http://localhost:3000/login"> Login </a></h3>
        </div>

    );
}

export default App;
