import React from "react";
import "./EmptyTodos.css";

const EmptyTodos = () => {
  return (
    <div className="empty-todos">
      <img src="empty-list.png" alt="No Todos" className="empty-icon" />
      <h3>No tasks yet</h3>
      <p>Start by adding a new todo to stay organized!</p>
    </div>
  );
};

export default EmptyTodos;
