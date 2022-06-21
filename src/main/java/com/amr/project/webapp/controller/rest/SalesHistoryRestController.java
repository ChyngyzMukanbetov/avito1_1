package com.amr.project.webapp.controller.rest;

import com.amr.project.model.dto.report.SalesHistoryDto;
import com.amr.project.service.abstracts.SalesHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/api/report")
public class SalesHistoryRestController {

    private final SalesHistoryService salesHistoryService;

    @Autowired
    public SalesHistoryRestController(SalesHistoryService salesHistoryService) {
        this.salesHistoryService = salesHistoryService;
    }

    @GetMapping("/reportShop")
    public ResponseEntity<List<SalesHistoryDto>> getReportShop(@RequestParam(value = "id", required = false) Long id,
                                                               @RequestParam(value = "idOne", required = false) Long idOne,
                                                               @RequestParam("orderDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Calendar orderDate) {
        return new ResponseEntity<>(salesHistoryService.getReport(id, idOne, orderDate), HttpStatus.OK);
    }
}
