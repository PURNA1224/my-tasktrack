import "./SendToSlackButton.css";
import { sendToSlack } from "../api";
import { useState } from "react";

const SendToSlackButton = ({
  summary,
  setSummary,
  message,
  setMessage,
  isSending,
  setIsSending,
  errorOccur,
  setErrorOccur,
  handleClick,
  isSummarizing,
}) => {
  const [showMessageTools, setShowMessageTools] = useState(false);
  const handleChange = (e) => {
    setSummary(e.target.value);
  };

  const handleSlackSubmit = async (e) => {
    e.preventDefault();
    if (summary.length === 0) {
      setErrorOccur("please enter something");
    } else {
      try {
        setIsSending(true);
        let responseSlack = await sendToSlack(summary);
        setIsSending(false);
        setMessage(responseSlack);
        setSummary("");
      } catch (error) {
        setIsSending(false);
        setErrorOccur(error.message);
      }
    }
    setTimeout(() => {
      setMessage("");
      setErrorOccur("");
    }, 3000);
  };

  const showButton = () => {
    setShowMessageTools(!showMessageTools);
  };
  return (
    <>
      <form className="slack-form" onSubmit={handleSlackSubmit}>
        <div className="label-container" onClick={showButton}>
          <label htmlFor="summary">Send Message to Slack</label>
          <span className="toggle-icon">{showMessageTools ? "▲" : "▼"}</span>
        </div>
        {showMessageTools && (
          <>
            <textarea
              id="summary"
              className="slack-textarea hide-effect"
              value={summary}
              onChange={handleChange}
              placeholder="Type your message here..."
            />
            <div className="button-container hide-effect">
              <button
                onClick={handleClick}
                type="button"
                className="summarizeBtn"
              >
                Summarize
              </button>
              <button type="submit" className="slack-button">
                Send to Slack
              </button>
            </div>
          </>
        )}

        {isSending && (
          <div className="sending-box">
            <span className="text">Sending message...</span>
          </div>
        )}

        {isSummarizing && (
          <div className="sending-box">
            <span className="text">summarizing pending todos...</span>
          </div>
        )}

        {message && (
          <div className="success-box">
            <span className="success-icon">✔</span>
            <span className="success-text">Message sent successfully!</span>
          </div>
        )}

        {errorOccur && (
          <div className="error-box">
            <span className="error-icon">
              <img src="/error-icon.png" style={{ width: "15px" }}></img>
            </span>
            <span className="error-text">{errorOccur}</span>
          </div>
        )}
      </form>
    </>
  );
};

export default SendToSlackButton;
