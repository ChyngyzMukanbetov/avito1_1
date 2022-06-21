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

    //    Поиск всех неотмодерированных отзывов
    @Override
    public List<Review> getReviewsForModerator(boolean isModerated, boolean isModerateAccept) {
        return em.createQuery(
                        "SELECT NEW com.amr.project.model.entity.Review(" +
                                "i.id, i.dignity, i.flaw, i.text, i.date," +
                                "i.rating)" +
                                "FROM Item s JOIN s.reviews i WHERE s.isModerated = :isModerated and s.isModerateAccept =:isModerateAccept", Review.class)
                .setParameter("isModerated", isModerated).setParameter("isModerateAccept", isModerateAccept).getResultList();
    }

    //    Поиск отзыва для товара по id
    @Override
    public Review findByIdModerate(Long reviewId, boolean isModerated, boolean isModerateAccept) {
        return em.createQuery(
                        "SELECT NEW com.amr.project.model.entity.Review(" +
                                "i.id, i.dignity, i.flaw, i.text, i.date," +
                                "i.rating)" +
                                "FROM Item s JOIN s.reviews i WHERE s.isModerated = :isModerated and " +
                                "s.isModerateAccept =:isModerateAccept and i.id = :reviewId", Review.class)
                .setParameter("isModerated", isModerated).setParameter("isModerateAccept", isModerateAccept)
                .setParameter("reviewId", reviewId).getSingleResult();
    }

    //    Поиск всех отмодерированных отзывов для товара по id
    @Override
    public  List<Review> findAllmoderated(Long itemId, boolean isModerated) {
        return em.createQuery(
                        "SELECT NEW com.amr.project.model.entity.Review(" +
                                "i.id, i.dignity, i.flaw, i.text, i.date," +
                                "i.rating)" +
                                "FROM Item s JOIN s.reviews i WHERE s.id = :itemId and i.isModerated = :isModerated", Review.class)
                .setParameter("isModerated", isModerated).setParameter("itemId", itemId).getResultList();
    }

}
