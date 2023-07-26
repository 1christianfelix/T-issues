import "./App.css";
import IssueDashboard from "./components/IssueDashboard";
import TissuesApp from "./components/TissuesApp";
import Toast from "./util/Toast";

function App() {
  return (
    <div className="App h-screen w-screen">
      <Toast></Toast>
      <TissuesApp></TissuesApp>
    </div>
  );
}

export default App;
