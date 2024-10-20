import './App.css';
import api from './api/axiosConfig';
import { useState, useEffect } from 'react';
import Layout from './Components/Layout';
import {Routes, Route} from 'react-router-dom';
import Home from './Components/home/Home';


function App() {
  //useState to update and the movies 
  //When setmovies is called it resets the variable movies.

  const [movies, setMovies] = useState([]); // Initialize as an empty array

  const getMovies = async () => {
    try {
      const response = await api.get('/api/v1/movies'); // Ensure correct endpoint
      console.log(response.data);
      setMovies(response.data); // Update state with fetched data
    } catch (err) {
      console.error(err); // Use console.error for errors
    }
  };

  //This calls the getMovies function that sets the movies variable
  // with setMovies to effectivelydisplay all the movies on mount of the component.
  useEffect(() => {
    getMovies();
  }, []);

  return (
    <div className='App'>
      <Routes>
        <Route path= "/" element={<Layout/>}>
         <Route path="/" element={<Home/>}></Route>
        </Route>
      </Routes>
    </div>
  );
}

export default App;
