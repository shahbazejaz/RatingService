package com.rating.service.Service;

import com.rating.service.PayLoad.RatingDto;

import java.util.List;

public interface RatingService {

    //create
   RatingDto createRating(RatingDto ratingDto);
    // getAll Ratings
   List<RatingDto> getAllRating();
    // get all by userId
   List<RatingDto> getRatingByUserId(String userId);
    // get All by hotel
   List<RatingDto> getRatingByHotelId(String hotelId);





}
