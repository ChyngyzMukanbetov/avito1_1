package com.amr.project.webapp.controller.rest;

import com.amr.project.model.dto.ItemShopDto;
import com.amr.project.service.abstracts.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SearchRestController {



    private final SearchService searchService;

    @Autowired
    public SearchRestController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public ResponseEntity<ItemShopDto> getSearchResult(@RequestParam("q") String name) {
        return ResponseEntity.ok(searchService.getResultItemShopDto(name));
    }
}

