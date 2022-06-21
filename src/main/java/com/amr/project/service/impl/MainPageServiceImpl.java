package com.amr.project.service.impl;

import com.amr.project.converter.CategoryMapper;
import com.amr.project.converter.ItemMapper;
import com.amr.project.converter.ShopMapper;
import com.amr.project.dao.abstracts.CategoryDao;
import com.amr.project.dao.abstracts.ItemDao;
import com.amr.project.dao.abstracts.ShopDao;
import com.amr.project.model.dto.MainPageDto;
import com.amr.project.service.abstracts.MainPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MainPageServiceImpl implements MainPageService {
    private final CategoryDao categoryDao;
    private final ItemDao itemDao;
    private final ShopDao shopDao;

    private final ItemMapper itemMapper;
    private final ShopMapper shopMapper;
    private final CategoryMapper categoryMapper;

    @Autowired
    public MainPageServiceImpl(CategoryDao categoryDao, ItemDao itemDao, ShopDao shopDao, ItemMapper itemMapper, ShopMapper shopMapper, CategoryMapper categoryMapper) {
        this.categoryDao = categoryDao;
        this.itemDao = itemDao;
        this.shopDao = shopDao;
        this.itemMapper = itemMapper;
        this.shopMapper = shopMapper;
        this.categoryMapper = categoryMapper;
    }


    @Transactional
    @Override
    public MainPageDto getMainPageDto() {

        return MainPageDto.builder()
                .categoryDto(categoryMapper.toDTOList(categoryDao.getCategoryList()))
                .itemDtoList(itemMapper.toDTOList(itemDao.getItemList()))
                .shopDtoList(shopMapper.toDTOList(shopDao.getShopList()))
                .username(null)
                .build();
    }
}
