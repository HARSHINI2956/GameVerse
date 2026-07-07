import { useNavigate } from "react-router-dom";
import { useState } from "react";

function GameSetup() {
  const navigate = useNavigate();

  const [players, setPlayers] = useState("1");
  const [difficulty, setDifficulty] = useState("Easy");
  const [time, setTime] = useState("5 Minutes");

  return (
    <div
      style={{
        background: "#0f172a",
        color: "white",
        minHeight: "100vh",
        padding: "40px",
      }}
    >
      <h1>🎮 Game Setup</h1>

      <h2>PUBG</h2>

      <p>Select Number of Players</p>
      <select value={players} onChange={(e) => setPlayers(e.target.value)}>
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
      </select>

      <br /><br />

      <p>Select Difficulty</p>
      <select value={difficulty} onChange={(e) => setDifficulty(e.target.value)}>
        <option>Easy</option>
        <option>Medium</option>
        <option>Hard</option>
      </select>

      <br /><br />

      <p>Select Time Limit</p>
      <select value={time} onChange={(e) => setTime(e.target.value)}>
        <option>5 Minutes</option>
        <option>10 Minutes</option>
        <option>15 Minutes</option>
      </select>

      <br /><br />

      <button
        onClick={() => navigate("/leaderboard")}
        style={{
          padding: "12px 25px",
          background: "#22c55e",
          color: "white",
          border: "none",
          borderRadius: "8px",
          cursor: "pointer",
        }}
      >
        ▶ Start Game
      </button>
    </div>
  );
}

export default GameSetup;