import { useEffect, useState } from "react";
import { fetchTodos, deleteTodo } from "../api";
import TodoItem from "./TodoItem";
import "./TodoList.css";
import EmptyTodos from "./EmptyTodos";
import ServerDown from "./ServerDown";

const TodoList = ({ refresh, onTodosFetched }) => {
  const [todos, setTodos] = useState([]);
  const [serverDown, setServerDown] = useState(false);

  useEffect(() => {
    fetchTodos()
      .then((res) => {
        setTodos(res.data);
        onTodosFetched(res.data);
      })
      .catch((error) => {
        setServerDown(true);
        console.error("Error fetching todos:", error.message || error);
      });
  }, [refresh, onTodosFetched]);

  const handleDelete = async (id) => {
    try {
      await deleteTodo(id);
      const updated = todos.filter((todo) => todo.id !== id);
      setTodos(updated);
      onTodosFetched(updated);
    } catch (err) {
      console.log("delete error:");
    }
  };

  const handleStatusChange = (id, isPending) => {
    try {
      const updated = todos.map((todo) =>
        todo.id === id ? { ...todo, isPending } : todo
      );
      setTodos(updated);
      onTodosFetched(updated);
    } catch (error) {
      console.log("status change error:");
    }
  };

  return (
    <ul className="todo-list">
      {serverDown ? (
        <ServerDown />
      ) : todos.length === 0 ? (
        <EmptyTodos />
      ) : (
        todos.map((todo) => (
          <TodoItem
            key={todo.id}
            todo={todo}
            onDelete={handleDelete}
            onStatusChange={handleStatusChange}
          />
        ))
      )}
    </ul>
  );
};

export default TodoList;
