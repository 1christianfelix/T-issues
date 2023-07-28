import "./App.css";
import IssueDashboard from "./components/IssueDashboard";
import TissuesApp from "./components/TissuesApp";
import Toast from "./util/Toast";
import Nav from "./components/Nav";

function App() {
  return (
    <div className="App h-screen w-screen">
      <Toast />
      <Nav></Nav>
      <TissuesApp></TissuesApp>
    </div>
  );
}

export default App;
