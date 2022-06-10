package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.ReadWriteDao;
import com.amr.project.model.entity.Country;
import com.amr.project.service.abstracts.CountryService;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl extends ReadWriteServiceImpl<Country, Long> implements CountryService {
    public CountryServiceImpl(ReadWriteDao<Country, Long> dao) {
        super(dao);
    }
}
