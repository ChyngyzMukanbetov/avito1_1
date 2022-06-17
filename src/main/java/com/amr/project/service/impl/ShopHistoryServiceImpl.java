package com.amr.project.service.impl;


import com.amr.project.dao.abstracts.ReadWriteDao;
import com.amr.project.dao.abstracts.ShopHistoryDao;
import com.amr.project.model.entity.Shop;
import com.amr.project.model.entity.report.ShopHistory;
import com.amr.project.service.abstracts.ShopHistoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

@Service
public class ShopHistoryServiceImpl extends ReadWriteServiceImpl<ShopHistory, Long> implements ShopHistoryService {

    private final ShopHistoryDao shopHistoryDao;

    public ShopHistoryServiceImpl(ReadWriteDao<ShopHistory, Long> dao, ShopHistoryDao shopHistoryDao) {
        super(dao);
        this.shopHistoryDao = shopHistoryDao;
    }

    @Override
    public List<ShopHistory> findAllByShop(Shop shop) {
        return shopHistoryDao.findAllByShop(shop);
    }

    @Transactional
    public ShopHistory persist(Shop shop) {
        ShopHistory shopHistory = new ShopHistory();
        shopHistory.setShop(shop);
        shopHistory.setCreateDate(new GregorianCalendar(TimeZone.getTimeZone("Europe/Moscow")));
        shopHistory.setName(shop.getName());
        shopHistory.setEmail(shop.getEmail());
        shopHistory.setPhone(shop.getPhone());
        dao.persist(shopHistory);
        return shopHistory;
    }

    @Transactional
    public ShopHistory update(Shop shop) {
        ShopHistory shopHistory = new ShopHistory();
        shopHistory.setShop(shop);
        shopHistory.setUpdateDate(new GregorianCalendar(TimeZone.getTimeZone("Europe/Moscow")));
        shopHistory.setName(shop.getName());
        shopHistory.setEmail(shop.getEmail());
        shopHistory.setPhone(shop.getPhone());
        dao.persist(shopHistory);
        return shopHistory;
    }
}
