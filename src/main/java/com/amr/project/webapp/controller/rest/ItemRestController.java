package com.amr.project.webapp.controller.rest;

import com.amr.project.converter.ItemMapper;
import com.amr.project.model.dto.ItemDto;
import com.amr.project.model.entity.Item;
import com.amr.project.service.abstracts.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemRestController {

    private final ItemService itemService ;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemRestController(ItemService itemService, ItemMapper itemMapper) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }

//    Возвращает все товары из магазина, по id магазина
    @GetMapping("/shopItems/{shopId}")
    public List<ItemDto> getAllItemsShop(@PathVariable Long shopId) {
        List<Item> itemModelList = itemService.getItemsByShopId(shopId);
        List<ItemDto> itemDtoLists = itemMapper.toDTOList(itemModelList);
        return itemDtoLists;
    }

//    Возвращает товар по id
    @GetMapping("/getItem/{id}")
    public ItemDto getItemById(@PathVariable Long id) {
        return itemMapper.toDTO(itemService.findById(id));
    }

//    Все товары
    @GetMapping("/getAll")
    public List<ItemDto> getAllItems() {
        List<Item> itemList = itemService.findAll();
        List<ItemDto> itemDtoList = itemMapper.toDTOList(itemList);
        return itemDtoList;
    }

    //    Создание нового товара
    @PostMapping("/createItem")
    public ResponseEntity<ItemDto> createNewItem(@RequestBody ItemDto itemDto) {
            Item item = itemMapper.toModel(itemDto);
            itemService.persist(item);
            return new ResponseEntity<>(itemMapper.toDTO(item), HttpStatus.OK);

    }

//    Редактирование товара по id
    @PutMapping("/editItem")
    public ResponseEntity<ItemDto> editItem(@RequestBody ItemDto itemDto) {
        if (!itemService.existsById(itemDto.getId()) ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Item item = itemMapper.toModel(itemDto);
            itemService.update(item);
            return new ResponseEntity<>(itemDto, HttpStatus.OK);
        }
    }

//    Помечает товар на удаление
    @PutMapping("/marksForDeleted/{id}")
    public ResponseEntity<String> marksForDeleted(@PathVariable Long id) {
        Item item = itemService.findById(id);
        item.setPretendedToBeDeleted(true);
        itemService.update(item);
        return new ResponseEntity<>("The product is marked for deletion!", HttpStatus.OK);
    }

//    Удаление товара по id
    @DeleteMapping("/deleteItem/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        itemService.delete(itemService.findById(id));
        return new ResponseEntity<>("Deleted Item", HttpStatus.OK);
    }
}
