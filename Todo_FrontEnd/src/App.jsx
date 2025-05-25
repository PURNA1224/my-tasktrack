import { useState } from "react";
import TodoForm from "./components/TodoForm";
import TodoList from "./components/TodoList";
import SummaryButton from "./components/SummaryButton";
import "./App.css";

const App = () => {
  const [refresh, setRefresh] = useState(false);
  const [todos, setTodos] = useState([]);

  const handleAdd = () => setRefresh((prev) => !prev);

  return (
    <div className="app-container">
      <h1>
        <img className="main-image" src="checklist-ai.png"></img> AI-Enhanced
        To-Do Manager
      </h1>
      <h4>Stay organized and productive</h4>
      <hr className="hr-line"></hr>
      <TodoForm onAdd={handleAdd} />
      <h3 className="list-heading">Scheduled Tasks</h3>
      <hr className="hr-line"></hr>
      <TodoList refresh={refresh} onTodosFetched={setTodos} />
      <SummaryButton todos={todos} />
    </div>
  );
};

export default App;
