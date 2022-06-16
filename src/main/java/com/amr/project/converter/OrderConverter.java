package com.amr.project.converter;

import com.amr.project.model.entity.Order;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring"/*, uses = {UserConverter.class, ItemMapper.class}*/)
public interface OrderConverter {

    default List<Long> mapLongtoList(List<Order> orders) {
        if (orders != null) {
            List<Long> listOrderIds = new ArrayList<>(orders.size());
            for (Order order : orders) {
                listOrderIds.add(order.getId());
            }
            return listOrderIds;
        } else {
            return null;
        }
    }


//    @Mapping(source = "orderDate", target = "date")
//    @Mapping(source = "grandTotal", target = "total")
//    @Mapping(source = "user.id", target = "userId")
//    @Mapping(source = "itemsInOrder", target = "itemIds")
//    OrderDto toDto(Order order);


//    OrderDto toOrder(Order order);
}
