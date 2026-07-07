import { useNavigate } from "react-router-dom";

function Leaderboard() {
  const navigate = useNavigate();

  const scores = [
    { player: "Satya", score: 980 },
    { player: "Rahul", score: 920 },
    { player: "Anjali", score: 880 },
    { player: "Akash", score: 840 },
    { player: "Guest", score: 790 },
  ];

  return (
    <div
      style={{
        background: "#0f172a",
        color: "white",
        minHeight: "100vh",
        padding: "40px",
      }}
    >
      <h1>🏆 Leaderboard</h1>

      <table
        style={{
          width: "60%",
          borderCollapse: "collapse",
          marginTop: "20px",
        }}
      >
        <thead>
          <tr>
            <th>Rank</th>
            <th>Player</th>
            <th>Score</th>
          </tr>
        </thead>

        <tbody>
          {scores.map((item, index) => (
            <tr key={index}>
              <td>{index + 1}</td>
              <td>{item.player}</td>
              <td>{item.score}</td>
            </tr>
          ))}
        </tbody>
      </table>

      <br />

      <button
        onClick={() => navigate("/dashboard")}
        style={{
          padding: "10px 20px",
          background: "#3b82f6",
          color: "white",
          border: "none",
          borderRadius: "8px",
          cursor: "pointer",
        }}
      >
        ⬅ Back to Dashboard
      </button>
    </div>
  );
}

export default Leaderboard;