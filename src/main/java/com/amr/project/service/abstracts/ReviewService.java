package com.amr.project.service.abstracts;

import com.amr.project.model.dto.ReviewDto;
import com.amr.project.model.entity.Review;
import com.amr.project.model.entity.User;

import java.util.List;

public interface ReviewService extends ReadWriteService<Review, Long> {

    List<Review> getReviewsByItemId(Long itemId);


    void save(final ReviewDto entity, User user);

    List<Review> findAllForModerator(boolean isModerated, boolean isModerateAccept);

    Review findByIdModerate(Long id, boolean isModerated, boolean isModerateAccept);

    List<Review> findAllModerated(Long itemId);
}
