package com.amr.project.dao.abstracts;

import com.amr.project.model.entity.Review;

import java.util.List;

public interface ReviewDao extends ReadWriteDao<Review, Long> {

    List<Review> getReviewsByItemId(Long itemId);

    List<Review> getReviewsForModerator(boolean isModerated, boolean isModerateAccept);


    Review findByIdModerate(Long reviewId, boolean isModerated, boolean isModerateAccept);

    List<Review> findAllmoderated(Long itemId, boolean isModerated);
}
