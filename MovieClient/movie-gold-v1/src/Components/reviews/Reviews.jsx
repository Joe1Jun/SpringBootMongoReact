import React from "react";
import ReviewForm from "../reviewForm/ReviewForm";
import { useEffect, useRef } from "react";
import api from '../../api/axiosConfig'
import {useParams} from 'react-router-dom';
import { Container, Row , Col } from "react-bootstrap";



const Reviews = ({getMovieData, movie, reviews, setReviews}) => {

const revText = useRef ();
let params = useParams();
const movieId = params.movieId;

useEffect(() =>{
   
   getMovieData(movieId)




}, [])

const handleSubmit = async (e) => {
   e.preventDefault();
   const rev = revText.current;

   try {

      const response = await api.post("/api/v1/reviews", {reviewBody: rev.value, imbdId : movieId})
   
      const updatedReviews = [...reviews, {body:rev.value}]
      rev.value = '';

      setReviews(updatedReviews);
      
   } 
   
   
   catch (error) {
      console.log(error)
   }

   
}

return (

   <Container>
      <Row>
         <Col>
         <h3>Reviews</h3>
         </Col>
      </Row>
      <Row className="mt-2">
         <Col>
         <img src={movie?.poster} alt="" />
         </Col>
         <Col>
         {
          <>
          
          <Row>
            <Col>
            <ReviewForm handleSubmit={handleSubmit} revText={revText} labelText= "Write a Review?" />
            </Col>
          </Row>
          <Row>
            <Col>
            <hr />
            </Col>
          </Row>
          
          
          
          </>

         }{
            reviews?.map((r) =>{
               return(
                   <>
                   
                   <Row>
                     <Col>
                     {r.body}
                     </Col>
                   </Row>
                   <Row>
            <Col>
            <hr />
            </Col>
          </Row>
                   
                   </>

               )
            })
         }
         </Col>
      </Row>
      <Row>
            <Col>
            <hr />
            </Col>
          </Row>
   </Container>
)




}

export default Reviews;