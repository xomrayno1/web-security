
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './App.css'
import Home from './components/Home';
import Login from './components/Login';
import Staff from './components/Staff';
import Order from './components/Order';
import NotFound from './components/NotFound';
import Register from './components/Register';

function App() {
  return (
    <>
    <div>Header Page</div>
    <Router>
      <Routes>
        <Route path="/order" element={<Order />} />
        <Route path="/staff" element={<Staff />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/" element={<Home />} />
        <Route path='*' element={<NotFound />} />
      </Routes>
    </Router>
    <div>Footer Page</div>
    </>
  )
}

export default App
