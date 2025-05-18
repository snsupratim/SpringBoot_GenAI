import React, { useState, useRef, useEffect } from "react";
import axios from "axios";
import "./App.css";

function App() {
  const [message, setMessage] = useState("");
  const [chatHistory, setChatHistory] = useState([]);
  const chatEndRef = useRef(null);

  const handleSend = async () => {
    if (!message.trim()) return;

    const userMessage = { sender: "user", text: message };
    setChatHistory((prev) => [...prev, userMessage]);

    try {
      const res = await axios.get(
        `http://localhost:8080/api/mistralai/${encodeURIComponent(message)}`
      );
      const botMessage = { sender: "bot", text: res.data };
      setChatHistory((prev) => [...prev, botMessage]);
    } catch (error) {
      console.error("API error:", error);
      setChatHistory((prev) => [
        ...prev,
        { sender: "bot", text: "⚠️ Error: Could not reach server." },
      ]);
    }

    setMessage("");
  };

  useEffect(() => {
    chatEndRef.current?.scrollIntoView({ behavior: "smooth" });
  }, [chatHistory]);

  return (
    <div className="chat-container">
      <header className="chat-header">Mistral AI Chat</header>

      <div className="chat-body">
        {chatHistory.map((msg, index) => (
          <div key={index} className={`chat-message ${msg.sender}`}>
            <div className="avatar">{msg.sender === "user" ? "🧑" : "🤖"}</div>
            <div className="message-content">{msg.text}</div>
          </div>
        ))}
        <div ref={chatEndRef} />
      </div>

      <div className="chat-input">
        <input
          type="text"
          placeholder="Send a message..."
          value={message}
          onChange={(e) => setMessage(e.target.value)}
          onKeyDown={(e) => e.key === "Enter" && handleSend()}
        />
        <button onClick={handleSend}>Send</button>
      </div>
    </div>
  );
}

export default App;
