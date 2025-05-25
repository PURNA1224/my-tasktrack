import axios from "axios";

const API = axios.create({
  baseURL: "https://springboot-todo-backend.onrender.com",
});

export const fetchTodos = () => API.get("/todo/getAllTodos");
export const addTodo = (todo) => API.post("/todo/createTodo", todo);
export const deleteTodo = (id) => API.delete(`/todo/deleteTodo/${id}`);
export const summarizeTodos = (payload) => API.post("/todo/summarize", payload);
export const updateTodoStatus = (id, isPending) =>
  API.put(`/todo/update/${id}?isPending=${isPending}`);
export const pendingTodos = () => API.get("/todo/getPendingTodos");
export const sendToSlack = (message) =>
  API.post("/todo/sendMessage", message, {
    headers: {
      "Content-Type": "text/plain",
    },
  });
