import { useState } from "react";
import "./SummaryButton.css";
import { summarizeTodos, pendingTodos } from "../api";
import SendToSlackButton from "./SendToSlackButton";

const SummaryButton = ({ todos }) => {
  const [message, setMessage] = useState("");
  const [isSending, setIsSending] = useState(false);
  const [errorOccur, setErrorOccur] = useState("");
  const [summary, setSummary] = useState("");
  const [isSummarizing, setIsSummarizing] = useState("");

  const handleClick = async () => {
    let pendingTodosReq = "";
    setIsSummarizing(true);
    try {
      pendingTodosReq = await pendingTodos();
    } catch (error) {
      setErrorOccur(error.message);
    }

    const payload = {
      incompleteTodos: pendingTodosReq.data,
      tone: "professional",
    };

    try {
      const response = await summarizeTodos(payload);
      setSummary(response.data);
    } catch (error) {
      setErrorOccur(error.code);
    } finally {
      setIsSummarizing(false);
    }
    setTimeout(() => {
      setErrorOccur("");
    }, 3000);
  };

  return (
    <div className="summary-button-container">
      <SendToSlackButton
        summary={summary}
        setSummary={setSummary}
        message={message}
        setMessage={setMessage}
        isSending={isSending}
        setIsSending={setIsSending}
        errorOccur={errorOccur}
        setErrorOccur={setErrorOccur}
        handleClick={handleClick}
        isSummarizing={isSummarizing}
      />
    </div>
  );
};

export default SummaryButton;
