package com.amr.project.service.impl;

import com.amr.project.converter.ReviewConverter;
import com.amr.project.dao.abstracts.ReviewDao;
import com.amr.project.model.dto.ReviewDto;
import com.amr.project.model.entity.Review;
import com.amr.project.model.entity.User;
import com.amr.project.service.abstracts.ReviewService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ReviewServiceImpl extends ReadWriteServiceImpl<Review, Long> implements ReviewService {

    private final ReviewConverter reviewConverter;
    private final ReviewDao reviewDao;

    public ReviewServiceImpl(ReviewConverter reviewConverter, ReviewDao reviewDao) {
        super(reviewDao);
        this.reviewConverter = reviewConverter;
        this.reviewDao = reviewDao;
    }

    @Override
    public List<Review> getReviewsByItemId(Long itemId) {
        return reviewDao.getReviewsByItemId(itemId);
    }


    @Override
    public void save(ReviewDto entity, User user) {
        entity.setDate(LocalDate.now());
        if (user != null&&entity.getUserId()!=1L) {
            entity.setUserId(user.getId());
            entity.setUserName(user.getUsername());
        }
        Review review = reviewConverter.toModel(entity);
        review.setModerateAccept(true);
        review.setModerated(false);
        reviewDao.persist(review);
    }

    @Override
    public List<Review> findAllForModerator(boolean isModerated, boolean isModerateAccept) {
        return reviewDao.getReviewsForModerator(isModerated, isModerateAccept);
    }

    @Override
    public Review findByIdModerate(Long id, boolean isModerated, boolean isModerateAccept) {
        return reviewDao.findByIdModerate(id, isModerated, isModerateAccept);
    }

    @Override
    public List<Review> findAllModerated(Long itemId) {
        return reviewDao.findAllmoderated(itemId, true);
    }

    @Override
    public void update(Review entity) {
        entity.setDate(new Date());
        entity.setModerated(false);
        entity.setModerateAccept(true);
        super.update(entity);
    }
}
