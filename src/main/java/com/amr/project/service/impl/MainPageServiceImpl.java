package com.amr.project.service.impl;

import com.amr.project.dao.pages.MainPageDao;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import com.amr.project.service.pages.MainPageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MainPageServiceImpl implements MainPageService {

    private final MainPageDao mainPageDao;

    public MainPageServiceImpl(MainPageDao mainPageDao) {
        this.mainPageDao = mainPageDao;
    }


    @Override
    public List<Item> listItem() {
        return mainPageDao.listItem();
    }

    @Override
    public List<Shop> listShop() {
        return mainPageDao.listShop();
    }
}
