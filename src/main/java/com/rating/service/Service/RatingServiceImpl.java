package com.rating.service.Service;

import com.rating.service.Entity.Rating;
import com.rating.service.PayLoad.RatingDto;
import com.rating.service.Repository.RatingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService{


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public RatingDto createRating(RatingDto ratingDto) {
        Rating rating = maptoRating(ratingDto);
        Rating rating1 = ratingRepository.save(rating);
        RatingDto ratingDto1 = mapToRatingDto(rating1);
        return ratingDto1;
    }

    @Override
    public List<RatingDto>  getAllRating() {
        List<Rating> ratings = ratingRepository.findAll();
       List<RatingDto> dtos= ratings.stream().map(c -> mapToRatingDto(c)).collect(Collectors.toList());
        return dtos;
    }

    @Override
    public List<RatingDto> getRatingByUserId(String userId) {
        List<Rating> id = ratingRepository.findByUserId(userId);
        List<RatingDto> collect = id.stream().map(c -> mapToRatingDto(c)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<RatingDto> getRatingByHotelId(String hotelId) {
        List<Rating> id = ratingRepository.findByHotelId(hotelId);
        List<RatingDto> dtos = id.stream().map(c -> mapToRatingDto(c)).collect(Collectors.toList());
        return dtos;
    }

    public Rating maptoRating(RatingDto ratingDto){
        Rating rating = modelMapper.map(ratingDto, Rating.class);
        return rating;
    }
    public RatingDto mapToRatingDto(Rating rating){
        RatingDto dto = modelMapper.map(rating, RatingDto.class);
        return dto;
    }


}
