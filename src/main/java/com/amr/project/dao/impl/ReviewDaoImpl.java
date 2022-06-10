package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.ReviewDao;
import com.amr.project.model.entity.Review;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewDaoImpl extends ReadWriteDaoImpl<Review, Long> implements ReviewDao {

//    Поиск всех отзывов для товара
    @Override
    public List<Review> getReviewsByItemId(Long itemId) {
        return em.createQuery(
                        "SELECT NEW com.amr.project.model.entity.Review(" +
                                "i.id, i.dignity, i.flaw, i.text, i.date," +
                                "i.rating)" +
                                "FROM Item s JOIN s.reviews i WHERE s.id = :itemId", Review.class)
                .setParameter("itemId", itemId).getResultList();
    }
}
