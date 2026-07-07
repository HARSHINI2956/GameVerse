import { useNavigate } from "react-router-dom";

const games = [
  "PUBG",
  "Free Fire",
  "Subway Surfers",
  "Among Us",
  "Asphalt 9",
  "Chess",
  "Ludo",
  "Sudoku",
  "Smash Cards",
  "Puzzle"
];

function Dashboard() {
  const navigate = useNavigate();

  return (
    <div style={{ padding: "30px", background: "#0f172a", minHeight: "100vh", color: "white" }}>
      <h1>🎮 GameVerse Dashboard</h1>

      <button
        onClick={() => navigate("/leaderboard")}
        style={{ marginBottom: "20px", padding: "10px" }}
      >
        🏆 Leaderboard
      </button>

      <div style={{
        display: "grid",
        gridTemplateColumns: "repeat(5,1fr)",
        gap: "20px"
      }}>
        {games.map((game) => (
          <div
            key={game}
            onClick={() => navigate("/setup")}
            style={{
              background: "#1e293b",
              padding: "20px",
              borderRadius: "10px",
              cursor: "pointer",
              textAlign: "center"
            }}
          >
            <h3>{game}</h3>
            <button>Play</button>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Dashboard;