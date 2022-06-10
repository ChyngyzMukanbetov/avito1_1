package com.amr.project.webapp.controller.view;

import com.amr.project.converter.ItemMapper;
import com.amr.project.model.dto.ItemDto;
import com.amr.project.model.entity.Item;
import com.amr.project.service.abstracts.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/item")
public class ItemViewController {

    private final ItemService itemService;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemViewController(ItemService itemService,
                              ItemMapper itemMapper) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }


    @GetMapping("/item/{id}")
    public String getItemById(Model model, @PathVariable Long id) {
        Item item = itemService.findById(id);
        ItemDto itemDto = itemMapper.toDTO(item);
        model.addAttribute("itemDto", itemDto);
        return "itemView";
    }

    @GetMapping("/allItems")
    public String getAllItems(Model model) {
        List<Item> itemList = itemService.findAll();
        List<ItemDto> itemDtoList = new ArrayList<>();
        for (Item item : itemList) {
            itemDtoList.add(itemMapper.toDTO(item));
        }
        model.addAttribute("itemDtoList", itemDtoList);
        return "allItemsView";
    }

}
