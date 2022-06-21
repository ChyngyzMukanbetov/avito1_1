package com.amr.project.service.abstracts;

import com.amr.project.model.dto.report.SalesHistoryDto;

import java.util.Calendar;
import java.util.List;

public interface SalesHistoryService {
    List<SalesHistoryDto> getReport(Long id, Long idOne, Calendar orderDate);
}
