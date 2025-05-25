import "./TodoItem.css";
import { updateTodoStatus } from "../api";
const TodoItem = ({ todo, onDelete, onStatusChange }) => {
  const handleToggleStatus = async () => {
    const updatedStatus = !todo.isPending;
    try {
      await updateTodoStatus(todo.id, updatedStatus);
      onStatusChange(todo.id, updatedStatus);
    } catch (err) {
      console.log("Failed to update status");
    }
  };

  return (
    <>
      <li
        className="todo-item"
        style={{
          background: todo.isPending
            ? "rgb(222 234 245 / 56%)"
            : "rgb(205 241 205 / 44%)",
        }}
      >
        <div className="todo-content">
          <h3> {todo.title.toUpperCase()}</h3>
          <p>{todo.description}</p>

          <table style={{ marginleft: "-3px" }}>
            <tbody>
              <tr>
                <td>
                  <strong>Start</strong>
                </td>
                <td>:</td>
                <td>{todo.startDate || "N/A"}</td>
              </tr>
              <tr>
                <td>
                  <strong>End</strong>
                </td>
                <td>:</td>
                <td>{todo.endDate || "N/A"}</td>
              </tr>
              <tr>
                <td>
                  <strong>Status</strong>
                </td>
                <td>:</td>
                <td>{todo.isPending ? "Pending" : "Completed"}</td>
              </tr>
            </tbody>
          </table>

          <label>
            <input
              type="checkbox"
              checked={!todo.isPending}
              onChange={handleToggleStatus}
            />
            Mark as Completed
          </label>
        </div>
        <button onClick={() => onDelete(todo.id)}>Delete</button>
      </li>
    </>
  );
};

export default TodoItem;
