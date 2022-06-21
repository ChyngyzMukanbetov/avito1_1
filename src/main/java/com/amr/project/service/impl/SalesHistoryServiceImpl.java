package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.SalesHistoryDao;
import com.amr.project.model.dto.report.SalesHistoryDto;
import com.amr.project.service.abstracts.SalesHistoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

@Service
public class SalesHistoryServiceImpl  implements SalesHistoryService {


    private final SalesHistoryDao salesHistoryDao;


    public SalesHistoryServiceImpl(SalesHistoryDao salesHistoryDao) {
        this.salesHistoryDao = salesHistoryDao;
    }

    @Override
    @Transactional
    public List<SalesHistoryDto> getReport(Long id, Long idOne, Calendar orderDate) {
        return salesHistoryDao.getReport(id,idOne,orderDate);
    }
}
