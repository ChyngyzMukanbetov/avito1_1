package com.amr.project.dao.impl;


import com.amr.project.dao.abstracts.SalesHistoryDao;
import com.amr.project.model.dto.report.SalesHistoryDto;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Calendar;
import java.util.List;

@Repository
public class SalesHistoryDaoImpl implements SalesHistoryDao {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public List<SalesHistoryDto> getReport(Long id, Long idOne, Calendar orderDate) {

        List<SalesHistoryDto> salesHistoryDto = em.createQuery("Select i.name as itemName, sh.id as id, sh.price as price, sh.basePrice as basePrice, sh.count as count,sh.orderDate as orderDate " +
                "From SalesHistory sh join sh.item i on sh.id = i.id Where i.shop.id =: shopId and i.id =:idItem and sh.orderDate=:orderDate")
                .unwrap(org.hibernate.query.Query.class)
                .setParameter("shopId", id)
                .setParameter("idItem", idOne)
                .setParameter("orderDate", orderDate)
                .setResultTransformer(Transformers.aliasToBean(SalesHistoryDto.class))
                .getResultList();


        return salesHistoryDto;
    }


}
