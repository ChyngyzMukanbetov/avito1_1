package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.ShopHistoryDao;
import com.amr.project.model.entity.Shop;
import com.amr.project.model.entity.report.ShopHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopHistoryDaoImpl extends ReadWriteDaoImpl<ShopHistory, Long> implements ShopHistoryDao {

    @Override
    public List<ShopHistory> findAllByShop(Shop shop) {
        return (List<ShopHistory>) em.createQuery("SELECT sh FROM ShopHistory sh WHERE sh.shop=:shop").setParameter("shop", shop).getResultList();
    }
}
