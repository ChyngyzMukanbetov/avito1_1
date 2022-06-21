package com.amr.project.webapp.controller.view;

import com.amr.project.service.abstracts.SalesHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;

@Controller
@RequestMapping("/reportShop")
public class SalesHistoryController {


    private final SalesHistoryService salesHistoryService;

    @Autowired
    public SalesHistoryController(SalesHistoryService salesHistoryService) {
        this.salesHistoryService = salesHistoryService;
    }


    @GetMapping("/report")
    public String getItemById(Model model,
                              @RequestParam(value = "id", required = false) Long id,
                              @RequestParam(value = "idOne", required = false) Long idOne,
                              @RequestParam("orderDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Calendar orderDate) {
           model.addAttribute("report",salesHistoryService.getReport(id,idOne,orderDate));
        return "mainPage/report";
    }

}
