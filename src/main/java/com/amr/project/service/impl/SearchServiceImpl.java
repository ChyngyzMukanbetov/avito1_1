package com.amr.project.service.impl;


import com.amr.project.dao.impl.ItemReadWriteDaoImpl;
import com.amr.project.dao.impl.ShopReadWriteDaoImpl;
import com.amr.project.model.dto.ItemShopDto;
import com.amr.project.service.abstracts.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class SearchServiceImpl implements SearchService {

    private ShopReadWriteDaoImpl shopReadWriteDao;
    private ItemReadWriteDaoImpl itemReadWriteDao;

    @Override
    public ItemShopDto getResultItemShopDto(String name) {

        ItemShopDto result = new ItemShopDto();
        result.setItemDtoList(itemReadWriteDao.findByPartNameItem(name));
        result.setShopDtoList(shopReadWriteDao.findByPartName(name));

        return result;
    }




}
