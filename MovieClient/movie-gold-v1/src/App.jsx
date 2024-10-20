import './App.css';
import api from './api/axiosConfig';
import { useState, useEffect } from 'react';
import Layout from './Components/Layout';
import {Routes, Route} from 'react-router-dom';
import Home from './Components/home/Home';
import Header from './Components/header/Header';
import Trailer from './Components/trailer/Trailer';
import Reviews from './Components/reviews/Reviews';

function App() {
  //useState to update and the movies 
  //When setmovies is called it resets the variable movies.

  const [movies, setMovies] = useState(); 
  const[movie, setMovie] = useState();
  const[reviews, setReviews] = useState();

  const getMovies = async () => {
    try {
      const response = await api.get('/api/v1/movies'); // Ensure correct endpoint
      console.log(response.data);
      setMovies(response.data); // Update state with fetched data
    } catch (err) {
      console.error(err); // Use console.error for errors
    }
  };

  const getMovieData = async (movieId) =>{
 
    try {
    const response = await api.get(`api/v1/movies/${movieId}`)
     const singleMovie = response.data;
     setMovie(singleMovie);

     setReviews(singleMovie.reviewIds)


    } catch (error) {
      console.log(error)
    }

  }

  //This calls the getMovies function that sets the movies variable
  // with setMovies to effectivelydisplay all the movies on mount of the component.
  useEffect(() => {
    getMovies();
  }, []);

  return (
    <div className='App'>
      <Header/>
      <Routes>
        <Route path= "/" element={<Layout/>}>
         <Route path="/" element={<Home movies = {movies}/>}></Route>
         <Route path="/Trailer/:ytTrailerId" element={ <Trailer/>}></Route>
         <Route path="/Reviews/:movieId" element={<Reviews getMovieData = {getMovieData} movie={movie} reviews = {reviews} setReviews={setReviews} /> }></Route>
        </Route>
      </Routes>
    </div>
  );
}

export default App;
