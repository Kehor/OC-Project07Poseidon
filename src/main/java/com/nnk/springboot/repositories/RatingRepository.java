package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

    @Query(value = "SELECT * FROM rating WHERE id = ?1 LIMIT 1", nativeQuery = true)
    public Rating findOneById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE rating r set moodys_rating =?2, sandprating =?3, fitch_rating =?4, order_number =?5 where r.id = ?1", nativeQuery = true)
    public void updateRating(Integer id, String moodysRating, String sandPRating, String fitchRating, Integer orderNumber);
}
