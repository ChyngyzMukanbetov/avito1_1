package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.ImageDao;
import com.amr.project.model.entity.Image;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImageDaoImpl extends ReadWriteDaoImpl<Image, Long> implements ImageDao {

//   Поиск всех картинок для товара
    @Override
    public List<Image> getImagesByItemId(Long itemId) {
        return em.createQuery(
                        "SELECT NEW com.amr.project.model.entity.Image(" +
                                "i.id, i.picture)" +
                                "FROM Item s JOIN s.images i WHERE s.id = :itemId", Image.class)
                .setParameter("itemId", itemId).getResultList();
    }
}
