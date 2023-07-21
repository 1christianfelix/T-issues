import "./App.css";
import { TodoApp } from "./components/TodoApp";
import Toast from "./util/Toast";

function App() {
  return (
    <div className="App h-screen w-screen">
      <Toast></Toast>
      <TodoApp></TodoApp>
    </div>
  );
}

export default App;
