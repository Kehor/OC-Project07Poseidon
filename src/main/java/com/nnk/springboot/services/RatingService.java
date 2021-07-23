package com.nnk.springboot.services;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public List<Rating> findAllRating() {
        List<Rating> ratingList = ratingRepository.findAll();
        return ratingList;
    }

    public Rating findOneRatingById(int id) {
        Rating rating = ratingRepository.findOneById(id);
        return rating;
    }

    public void deleteOneRatingById(int id) {
        ratingRepository.delete(findOneRatingById(id));
    }

    public Rating saveRating(Rating rating) {
        rating = ratingRepository.save(rating);
        return rating;
    }

    public Rating updateRating(Rating rating) {
        ratingRepository.updateRating(rating.getId(), rating.getMoodysRating(), rating.getSandPRating(), rating.getFitchRating(), rating.getOrderNumber());

        return rating;
    }

}
