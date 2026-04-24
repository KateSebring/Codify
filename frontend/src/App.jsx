import './css/index.css'
import Home from "./pages/Home";
import Register from "./pages/Register";
import Login from "./pages/Login";
import JobAppDashboard from "./pages/JobAppDashboard";
import JobAppSubmission from "./pages/JobAppSubmission";

import { Routes, Route } from "react-router-dom";

export default function App() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/register" element={<Register />} />
      <Route path="/login" element={<Login />} />
      <Route path="/dashboard" element={<JobAppDashboard />} />
      <Route path="/newApplication" element={<JobAppSubmission />} />
    </Routes>
  );
}