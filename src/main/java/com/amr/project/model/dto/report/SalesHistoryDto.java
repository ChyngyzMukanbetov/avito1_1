package com.amr.project.model.dto.report;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Calendar;


//TODO: Нужен ли данный DTO?-НУЖЕН!
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesHistoryDto {
    private String itemName;
    private Long id;
    private BigDecimal price;       //Цена проданного товара в этот день ("= price" в таблице "item)
    private BigDecimal basePrice;   //Себестоимость товара ("= basePrice" в таблице "item")
    private int count;              //Кол-во проданного товара в этот день
    private Calendar orderDate;     //Дата продажи товара


}
