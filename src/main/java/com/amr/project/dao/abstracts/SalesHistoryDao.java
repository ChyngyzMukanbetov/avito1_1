package com.amr.project.dao.abstracts;

import com.amr.project.model.dto.report.SalesHistoryDto;

import java.util.Calendar;
import java.util.List;

public interface SalesHistoryDao {

    List<SalesHistoryDto> getReport(Long id, Long idOne, Calendar orderDate);
}
