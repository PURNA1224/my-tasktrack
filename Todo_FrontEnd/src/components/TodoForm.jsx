import { useState } from "react";
import { addTodo } from "../api";
import "./TodoForm.css";

const TodoForm = ({ onAdd }) => {
  const [form, setForm] = useState({
    title: "",
    description: "",
    startDate: "",
    endDate: "",
    isPending: true,
  });

  const [errorMessages, setErrorMessages] = useState([]);

  const [showSuccessMsg, setShowSuccessMsg] = useState(false);

  const handleChange = (e) => {
    const { name, value } = e.target;
    const capValue = value.charAt(0).toUpperCase() + value.slice(1);
    setForm({ ...form, [name]: capValue });
    setErrorMessages([]);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await addTodo(form);
      onAdd(res.data);
      setShowSuccessMsg(true);
      setForm({
        title: "",
        description: "",
        startDate: "",
        endDate: "",
        isPending: true,
      });
    } catch (err) {
      if (err.response?.status === 500) {
        setErrorMessages(Object.values(err.response.data));
      } else {
        setErrorMessages(["Something went wrong. Please try again."]);
      }
    }
    setTimeout(() => {
      setShowSuccessMsg(false);
      setErrorMessages("");
    }, 3000);
  };

  return (
    <form onSubmit={handleSubmit} className="todo-form">
      <input
        name="title"
        className="wide"
        placeholder="Title"
        value={form.title}
        onChange={handleChange}
        required
      />
      <textarea
        name="description"
        className="wide"
        placeholder="Description"
        value={form.description}
        onChange={handleChange}
        required
      />
      <div className="date-row">
        <span className="date-group">
          <label htmlFor="startDate">Start Date</label>
          <input
            type="date"
            id="startDate"
            name="startDate"
            value={form.startDate}
            onChange={handleChange}
          />
        </span>
        <span className="date-group">
          <label htmlFor="endDate">End Date</label>
          <input
            type="date"
            id="endDate"
            name="endDate"
            value={form.endDate}
            onChange={handleChange}
          />
        </span>
      </div>

      <button className="addButton" type="submit">
        Add Todo
      </button>

      {showSuccessMsg && (
        <div className="success-message">Successfully added.</div>
      )}

      {errorMessages.length > 0 && (
        <div className="error-box">
          <ul>
            {errorMessages.map((msg, idx) => (
              <li key={idx} className="error-message">
                {msg}
              </li>
            ))}
          </ul>
        </div>
      )}
    </form>
  );
};

export default TodoForm;
