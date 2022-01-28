import './App.css';
import { Routes, Route, Outlet, Link } from "react-router-dom";
import Dashboard from './core/components/dashboard/dashboard';
import Reports from './core/components/reports/reports';
import Layout from './core/components/layout/layout';
import NotFound from './shared/components/not-found/not-found';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route index element={<Dashboard />} />
          <Route path="reports" element={<Reports />} />
          <Route path="*" element={<NotFound />} />
        </Route>
      </Routes>
    </div>
  );
}

export default App;