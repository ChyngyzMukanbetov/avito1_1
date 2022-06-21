package com.amr.project.service.abstracts;

import com.amr.project.model.dto.ItemShopDto;

public interface SearchService {
    ItemShopDto getResultItemShopDto(String name);

}
