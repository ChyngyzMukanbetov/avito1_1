package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.ReadWriteDao;
import com.amr.project.dao.abstracts.ShopDao;
import com.amr.project.model.entity.Shop;
import com.amr.project.service.abstracts.ShopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ShopServiceImpl extends ReadWriteServiceImpl<Shop, Long> implements ShopService {

    private final ShopDao shopDao;

    public ShopServiceImpl(ReadWriteDao<Shop, Long> dao, ShopDao shopDao) {
        super(dao);
        this.shopDao = shopDao;
    }

    @Transactional
    @Override
    public List<Shop> getShopList() {
        return shopDao.getShopList();
    }

    @Override
    @Transactional
    public void update(Shop shop) {
        shop.setModerated(false);
        shop.setModerateAccept(false);
        shop.setPretendedToBeDeleted(false);
        dao.update(shop);
    }
}
