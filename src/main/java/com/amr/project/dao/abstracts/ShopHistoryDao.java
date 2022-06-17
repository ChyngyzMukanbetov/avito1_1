package com.amr.project.dao.abstracts;

import com.amr.project.model.entity.Shop;
import com.amr.project.model.entity.report.ShopHistory;

import java.util.List;

public interface ShopHistoryDao extends ReadWriteDao<ShopHistory, Long> {

    List<ShopHistory> findAllByShop(Shop shop);
}
