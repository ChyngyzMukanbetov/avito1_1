insert into country (name) values ('Russia'),('USA'),('Italy'),('Poland');
insert into category (name) values ('first_category'),('second_category'),('therd_category'),('fourth_category');
insert into personal_data (authority,comment,date_of_issue,passport,place_of_birth,personal_data_status) values ('authority1','comment1','2022-06-01 22:00:00',1111111,'London',1),('authority2','comment2','2022-06-01 23:00:00',2222222,'Piter',2),('authority3','comment3','2022-06-03 23:00:00',333333,'Paris',3),('authority4','comment4','2021-06-01 22:00:00',444444,'Moscow',4);
insert into contact_form (answer,date_time,email,is_moderated,name,text) values ('answer1','2022-06-01 22:00:00','first@mail.ru',1,'first','text1'), ('answer2','2022-05-01 22:00:00','second@mail.ru',0,'second','text2');
insert into city (name,country_id) values ('Spb',1),('New-Yerk',2),('Rom',3),('Krakow',4);
insert into address (city_index,house,street,city_id,additional_info) values ('city_index1','house1','street1',1,'additionalInfo1'),('city_index2','house2','street2',2,'additionalInfo2'),('city_index3','house3','street3',3,'additionalInfo3'),('city_index4','house4','street4',4,'additionalInfo4');
insert into user (activate,activation_code,age,birthday,email,first_name,gender,is_identification,is_using2fa,last_name,password,phone,role,secret,username,address_id,personal_data_id) values
                                                                                                                                                                                             (1,'active_code1',1,'2022-06-01 22:00:00','user1@mail.ru','user1','MALE',1,1,'user1lastName','$2a$10$s0DR7i2s0llqDlro7U7XRemfKjLCeBd5xrMGAVTdMOG8V7UgmqztG','11111111111','USER','secret1','username1',1,1),
                                                                                                                                                                                             (1,'active_code2',2,'2022-06-02 22:00:00','user2@mail.ru','user2','FEMALE',1,1,'user2lastName','$2a$10$s0DR7i2s0llqDlro7U7XRemfKjLCeBd5xrMGAVTdMOG8V7UgmqztG','22222222222','MODERATOR','secret2','username2',2,2),
                                                                                                                                                                                             (1,'active_code1',3,'2022-06-03 22:00:00','user3@mail.ru','user3','MALE',1,1,'user3lastName','$2a$10$s0DR7i2s0llqDlro7U7XRemfKjLCeBd5xrMGAVTdMOG8V7UgmqztG','33333333333','ADMIN','secret3','username3',3,3),
                                                                                                                                                                                             (1,'active_code1',4,'2022-06-04 22:00:00','user4@mail.ru','user4','FEMALE',1,1,'user4lastName','$2a$10$s0DR7i2s0llqDlro7U7XRemfKjLCeBd5xrMGAVTdMOG8V7UgmqztG','44444444444','ANONYMOUS','secret4','username4',4,4);
insert into shop (count,description,email,is_moderate_accept,is_moderated,is_pretended_to_be_deleted,moderated_reject_reason,name,phone,rating,location_id,user_id) values
                                                                                                                                                                       (1,'description1','shop1@mail.ru',1,1,1,'reason1','shop1','111',5.0,1,1),
                                                                                                                                                                       (2,'description2','shop2@mail.ru',1,1,1,'reason2','shop2','222',4.5,2,2),
                                                                                                                                                                       (3,'description3','shop3@mail.ru',1,1,1,'reason3','shop3','333',4.0,3,3),
                                                                                                                                                                       (4,'description4','shop4@mail.ru',1,1,1,'reason4','shop4','444',3.0,4,4);
insert into order_by_user (currency,descript,delyv_data,total,data,qiwi_id,status,address_id,user_id) values
                                                                                                          ('currency1','discript1','2010-06-01 22:00:00',1,'2022-06-01 22:00:00','qiwi_id1',1,1,1),
                                                                                                          ('currency2','discript2','2011-06-01 23:00:00',2,'2022-06-01 22:00:00','qiwi_id2',2,2,2),
                                                                                                          ('currency3','discript3','2012-06-01 21:00:00',3,'2022-06-01 22:00:00','qiwi_id3',3,3,3),
                                                                                                          ('currency4','discript4','2013-06-01 20:00:00',4,'2022-06-01 22:00:00','qiwi_id4',4,4,4);
insert into favorite (user_id) values (1),(2),(3),(4);
insert into chat (hash,recipient_id,sender_id) values (1111111111,1,2),(222222222,2,3),(33333333333,3,4),(444444444444,4,1);




INSERT INTO  coupon (end,start,user_id,shop_id) VALUES (  '2021-01-01 00:00:12','2021-02-01 00:00:00',  1,  4);
INSERT INTO  coupon (end,start,user_id,shop_id) VALUES (  '2021-01-01 00:00:00','2000-02-01 23:59:00',  2,  3);
INSERT INTO  coupon (end,start,user_id,shop_id) VALUES (  '2022-02-01 12:00:00','2000-03-01 23:59:00',  3,  2);
INSERT INTO  coupon (end,start,user_id,shop_id) VALUES (  '2020-03-01 00:12:00','2000-04-01 23:59:00',  4,  1);


INSERT INTO  discount (fixed_discount, min_order, percentage, shop_id, user_id) VALUES ( 10, 10000, 13, 4,  1);
INSERT INTO  discount (fixed_discount, min_order, percentage, shop_id, user_id) VALUES ( 4, 5678, 14, 3,  1);
INSERT INTO  discount (fixed_discount, min_order, percentage, shop_id, user_id) VALUES ( 5, 1500, 15, 2,  2);
INSERT INTO  discount (fixed_discount, min_order, percentage, shop_id, user_id) VALUES ( 6, 4500, 10, 1,  3);


INSERT INTO  feedback (date_time,full_text,reason,username,shop_id,user_id) VALUES ( '2021-01-01 23:00:12', 'full_text1','reason1','username1',2,  1);
INSERT INTO  feedback (date_time,full_text,reason,username,shop_id,user_id) VALUES ( '2021-02-01 00:59:12', 'full_text2','reason2','username2',3,  2);
INSERT INTO  feedback (date_time,full_text,reason,username,shop_id,user_id) VALUES ( '2022-03-01 14:00:12', 'full_text3','reason3','username3',4,  3);
INSERT INTO  feedback (date_time,full_text,reason,username,shop_id,user_id) VALUES ( '2020-04-01 12:00:12', 'full_text4','reason4','username4',1,  4);


INSERT INTO  cart_item (quantity,shop_id,user_id) VALUES ( 2, 1,  1);
INSERT INTO  cart_item (quantity,shop_id,user_id) VALUES ( 4, 2,  3);
INSERT INTO  cart_item (quantity,shop_id,user_id) VALUES ( 10, 3,  2);
INSERT INTO  cart_item (quantity,shop_id,user_id) VALUES ( 5, 4,  4);

INSERT INTO  favorite_shop (favorite_id,shop_id ) VALUES (1,1);
INSERT INTO  favorite_shop (favorite_id,shop_id ) VALUES (2,2);
INSERT INTO  favorite_shop (favorite_id,shop_id ) VALUES (3,3);
INSERT INTO  favorite_shop (favorite_id,shop_id ) VALUES (4,4);


INSERT INTO  message (date,text_message,viewed,chat_id,recipient_id,sender_id) VALUES ( '2021-01-01 00:00:12', 'text_message1',1,1,1,1);
INSERT INTO  message (date,text_message,viewed,chat_id,recipient_id,sender_id) VALUES ( '2021-02-03 23:00:12', 'text_message2',1,2,2,2);
INSERT INTO  message (date,text_message,viewed,chat_id,recipient_id,sender_id) VALUES ( '2021-03-04 13:00:12', 'text_message3',1,3,3,3);
INSERT INTO  message (date,text_message,viewed,chat_id,recipient_id,sender_id) VALUES ( '2021-04-01 17:59:12', 'text_message4',1,4,4,4);


INSERT INTO  user_chat (user_id,chat_id) VALUES (1,1);
INSERT INTO  user_chat (user_id,chat_id) VALUES (2,2);
INSERT INTO  user_chat (user_id,chat_id) VALUES (3,3);
INSERT INTO  user_chat (user_id,chat_id) VALUES (4,4);


INSERT INTO item(base_price,count,description,discount,is_moderate_accept,is_moderated,is_pretended_to_be_deleted,moderated_reject_reason,
                 name,price,rating,cart_item_id,category_id,shop_id,user_id )
VALUES (23, 1,'description1', 10, 1,1,1,'moderated_reject_reason','name1',26,2,1,1,1,1);
INSERT INTO item(base_price,count,description,discount,is_moderate_accept,is_moderated,is_pretended_to_be_deleted,moderated_reject_reason,
                 name,price,rating,cart_item_id,category_id,shop_id,user_id )
VALUES (24, 2,'description2', 11, 1,1,1,'moderated_reject_reason2','name2',27,2,2,2,2,2);
INSERT INTO item(base_price,count,description,discount,is_moderate_accept,is_moderated,is_pretended_to_be_deleted,moderated_reject_reason,
                 name,price,rating,cart_item_id,category_id,shop_id,user_id )
VALUES (35, 3,'description3', 30, 1,1,1,'moderated_reject_reason3','name3',36,3,3,3,3,3);
INSERT INTO item(base_price,count,description,discount,is_moderate_accept,is_moderated,is_pretended_to_be_deleted,moderated_reject_reason,
                 name,price,rating,cart_item_id,category_id,shop_id,user_id )
VALUES (45, 4,'description4', 40, 1,1,1,'moderated_reject_reason4','name4',46,4,4,4,4,4);



INSERT INTO  review (date,dignity,flaw,is_moderate_accept,is_moderated,moderated_reject_reason,rating,text,item_id,shop_id,user_id)
VALUES ('2021-01-01 00:00:12','dignity1','flaw1',1,1,'moderated_reject_reason1',1,'text1',1,1,1);
INSERT INTO  review (date,dignity,flaw,is_moderate_accept,is_moderated,moderated_reject_reason,rating,text,item_id,shop_id,user_id)
VALUES ('2022-02-02 00:00:22','dignity2','flaw2',1,1,'moderated_reject_reason2',2,'text2',2,2,2);
INSERT INTO  review (date,dignity,flaw,is_moderate_accept,is_moderated,moderated_reject_reason,rating,text,item_id,shop_id,user_id)
VALUES ('2022-03-03 00:00:33','dignity3','flaw3',1,1,'moderated_reject_reason3',3,'text3',3,3,3);
INSERT INTO  review (date,dignity,flaw,is_moderate_accept,is_moderated,moderated_reject_reason,rating,text,item_id,shop_id,user_id)
VALUES ('2022-04-04 00:00:44','dignity4','flaw4',1,1,'moderated_reject_reason4',4,'text4',4,4,4);

INSERT INTO  favorite_item (favorite_id, item_id) VALUES (1,1);
INSERT INTO  favorite_item (favorite_id, item_id) VALUES (2,2);
INSERT INTO  favorite_item (favorite_id, item_id) VALUES (3,3);
INSERT INTO  favorite_item (favorite_id, item_id) VALUES (4,4);


INSERT INTO  sales_history (base_price,count,order_date,price,item_id ) VALUES (11,11,'2021-01-01 00:00:12',11.1,1);
INSERT INTO  sales_history (base_price,count,order_date,price,item_id ) VALUES (22,22,'2022-02-02 00:00:22',22.2,2);
INSERT INTO  sales_history (base_price,count,order_date,price,item_id ) VALUES (33,33,'2020-03-03 00:00:33',33.3,3);
INSERT INTO  sales_history (base_price,count,order_date,price,item_id ) VALUES (44,44,'2021-04-04 00:00:44',44.4,4);


INSERT INTO  order_item (order_by_user_id, item_id) VALUES (4,4);
INSERT INTO  order_item (order_by_user_id, item_id) VALUES (1,1);
INSERT INTO  order_item (order_by_user_id, item_id) VALUES (2,2);
INSERT INTO  order_item (order_by_user_id, item_id) VALUES (3,3);


INSERT INTO  personal_data (authority,comment,date_of_issue,passport,place_of_birth,personal_data_status)
VALUES ('authority1','comment1','2021-01-01 00:00:12',1,'place_of_birth1',1);
INSERT INTO  personal_data (authority,comment,date_of_issue,passport,place_of_birth,personal_data_status)
VALUES ('authority2','comment2','2022-02-02 00:00:22',2,'place_of_birth2',2);
INSERT INTO  personal_data (authority,comment,date_of_issue,passport,place_of_birth,personal_data_status)
VALUES ('authority3','comment3','2021-03-03 00:00:33',3,'place_of_birth3',3);
INSERT INTO  personal_data (authority,comment,date_of_issue,passport,place_of_birth,personal_data_status)
VALUES ('authority4','comment4','2021-04-04 00:00:44',4,'place_of_birth4',4);