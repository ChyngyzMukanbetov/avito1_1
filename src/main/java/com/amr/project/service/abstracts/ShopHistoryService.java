package com.amr.project.service.abstracts;

import com.amr.project.model.entity.Shop;
import com.amr.project.model.entity.report.ShopHistory;

import java.util.List;

public interface ShopHistoryService extends ReadWriteService<ShopHistory, Long> {

    List<ShopHistory> findAllByShop(Shop shop);
    ShopHistory persist(Shop shop);
    ShopHistory update(Shop shop);
}
