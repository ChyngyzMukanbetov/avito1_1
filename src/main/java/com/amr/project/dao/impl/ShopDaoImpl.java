package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.ShopDao;
import com.amr.project.model.entity.Shop;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopDaoImpl extends ReadWriteDaoImpl<Shop, Long> implements ShopDao {

    @Override
    public List<Shop> getShopList() {
        return em.createQuery("select u from Shop u order by u.rating desc", Shop.class).setMaxResults(6).getResultList();
    }
}
