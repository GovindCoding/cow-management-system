import React, { useEffect, useState } from 'react';
import axios from 'axios';

const AdminDashboard = () => {
  const [cows, setCows] = useState([]);
  const [milkRecords, setMilkRecords] = useState([]);
  const [healthRecords, setHealthRecords] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/cows').then(res => setCows(res.data));
    axios.get('http://localhost:8080/milk').then(res => setMilkRecords(res.data));
    axios.get('http://localhost:8080/health').then(res => setHealthRecords(res.data));
  }, []);

  return (
    <div>
      <h1>Admin Dashboard</h1>

      <h2>Cows</h2>
      <ul>{cows.map(cow => <li key={cow.id}>{cow.name} - {cow.breed}</li>)}</ul>

      <h2>Milk Records</h2>
      <ul>{milkRecords.map(m => <li key={m.id}>{m.date} - {m.quantity}L</li>)}</ul>

      <h2>Health Records</h2>
      <ul>{healthRecords.map(h => <li key={h.id}>{h.date} - {h.diagnosis}</li>)}</ul>
    </div>
  );
};

export default AdminDashboard;
