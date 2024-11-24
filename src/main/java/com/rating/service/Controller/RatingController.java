package com.rating.service.Controller;

import com.rating.service.Entity.Rating;
import com.rating.service.PayLoad.RatingDto;
import com.rating.service.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;
    @PostMapping
    public ResponseEntity<RatingDto> createRating(@RequestBody RatingDto ratingDto){
        RatingDto rating = ratingService.createRating(ratingDto);
        return new ResponseEntity<>(rating, HttpStatus.CREATED);
    }

    @GetMapping
    public List<RatingDto> getAllRating(){
        List<RatingDto> allRating = ratingService.getAllRating();
        return allRating;
    }
    @GetMapping("/users/{userId}")
    public List<RatingDto> getAllByUserId(@PathVariable("userId") String userId){
        List<RatingDto> ratingByUserId = ratingService.getRatingByUserId(userId);
        return ratingByUserId;
    }

    @GetMapping("/hotel/{hotelId}")
    public List<RatingDto> getAllByHotelId(@PathVariable("hotelId") String hotelId){
        List<RatingDto> ratingByHotelId = ratingService.getRatingByHotelId(hotelId);
        return ratingByHotelId;
    }
}
