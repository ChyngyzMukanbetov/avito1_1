# ВНИМАНИЕ!!! ЭТО ПРИМЕР ДОКУМЕНТАЦИИ
#ВАМ ТОЖЕ ОЧЕНЬ ПРИГОДИТСЯ

## Сущности

[Схема базы данных](https://dbdiagram.io/embed/614c9d0e825b5b0146107aac)

```
* - поля ссылающиеся на другие Entity;
** - поля ссылающиеся на Enum.
```

### Address:

#### Поля:

- **id** - уникальный идентификационный номер адреса;
- **cityIndex** - поле хранящее почтовый индекс;
- **country** - поле хранящее Страну*;
- **city** - поле хранящее Город*;
- **street** - поле хранящее название улицы;
- **house** - поле хранящее дом (String);
- **user** - поле связывающие адрес с конкретным Пользователем*.

```
Сущность представляет собой набор данных предназначенных для определения 
адреса доставки заказа/ расположения магазина / расположения пользователя.
```

### CartItem:

#### Поля:

- **id** - уникальный идентификационный номер карточки товара;
- **item** - поле хранящее выбранный Товар*;
- **shop** - поле хранящее Магазин* в котором был выбран товар;
- **user** - поле хранящее Пользователя* который выбрал товар;
- **quantity** - поле хранящее количество товаров.

#### Методы:

- **getSubTotal()**- метод который подсчитывает стоимость товара на основании предоставленной скидки и количества
  выбранного товара.


Пароли юзеров: 1 в бикрипте,UserInfo удален, его поля перенесены в класс User  