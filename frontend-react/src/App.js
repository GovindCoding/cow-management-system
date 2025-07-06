
import React, { useEffect, useState } from 'react';
import axios from 'axios';

function App() {
  const [cows, setCows] = useState([]);
  useEffect(() => {
    axios.get('http://localhost:8080/cows')
      .then(res => setCows(res.data))
      .catch(err => console.error(err));
  }, []);

  return (
    <div>
      <h1>Cow List</h1>
      <ul>
        {cows.map(cow => <li key={cow.id}>{cow.name} - {cow.breed}</li>)}
      </ul>
    </div>
  );
}

export default App;
