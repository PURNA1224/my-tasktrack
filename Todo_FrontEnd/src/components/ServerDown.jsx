import React from "react";
import "./ServerDown.css";

const ServerDown = () => {
  return (
    <div className="server-down">
      <h2>🚧 Server Unavailable</h2>
      <p>
        This project uses a free backend hosting service, which may go down due
        to inactivity.
      </p>
      <p>
        Please try again in a few minutes or contact{" "}
        <b>purnashekar777@gmail.com </b>
        for help.
      </p>
    </div>
  );
};

export default ServerDown;
