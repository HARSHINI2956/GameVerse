import { useNavigate } from "react-router-dom";

function Login() {
  const navigate = useNavigate();

  return (
    <div style={{
      background: "#0f172a",
      color: "white",
      height: "100vh",
      display: "flex",
      justifyContent: "center",
      alignItems: "center"
    }}>
      <div style={{
        background: "#1e293b",
        padding: "30px",
        borderRadius: "12px",
        width: "320px",
        textAlign: "center"
      }}>
        <h1>🎮 GameVerse</h1>

        <input
          type="text"
          placeholder="Username"
          style={{ width: "100%", padding: "10px", margin: "10px 0" }}
        />

        <input
          type="password"
          placeholder="Password"
          style={{ width: "100%", padding: "10px", margin: "10px 0" }}
        />

        <button
          onClick={() => navigate("/dashboard")}
          style={{
            width: "100%",
            padding: "10px",
            background: "#3b82f6",
            color: "white",
            border: "none",
            borderRadius: "8px",
            cursor: "pointer"
          }}
        >
          Login
        </button>
      </div>
    </div>
  );
}

export default Login;