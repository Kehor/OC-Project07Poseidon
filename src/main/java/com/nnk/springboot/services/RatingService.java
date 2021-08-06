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
    /**
     *
     * @return all Rating in a List<Rating>
     */
    public List<Rating> findAllRating() {
        List<Rating> ratingList = ratingRepository.findAll();
        return ratingList;
    }
    /**
     *
     * @param id int
     * @return Rating
     */
    public Rating findOneRatingById(int id) {
        Rating rating = ratingRepository.findOneById(id);
        return rating;
    }
    /**
     * delete a Rating by its id
     * @param id int
     */
    public void deleteOneRatingById(int id) {
        ratingRepository.delete(findOneRatingById(id));
    }
    /**
     * save a Rating
     * @param rating Rating
     * @return Rating
     */
    public Rating saveRating(Rating rating) {
        rating = ratingRepository.save(rating);
        return rating;
    }
    /**
     * update a Rating
     * @param rating Rating
     * @return Rating
     */
    public Rating updateRating(Rating rating) {
        ratingRepository.updateRating(rating.getId(), rating.getMoodysRating(), rating.getSandPRating(), rating.getFitchRating(), rating.getOrderNumber());

        return rating;
    }

}
