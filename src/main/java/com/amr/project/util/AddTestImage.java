package com.amr.project.util;

import com.amr.project.dao.abstracts.AddTestImageDao;
import com.amr.project.model.entity.Image;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AddTestImage {

    private final AddTestImageDao addTestImageDao;

    public AddTestImage(AddTestImageDao addTestImageDao) {
        this.addTestImageDao = addTestImageDao;
    }

    /*
        При запуске проекта, выполняется написанный ниже метод, осуществляющий
        конвертацию изображений в массив байтов и дальнейше внесение данных Image в базу данных
    */

    @PostConstruct
    @Transactional
    public void saveTestImageInDB() throws IOException {

        Image image;

        List<String> imagePathsMain = new ArrayList<>();
        List<String>imagePathsShops = new ArrayList<>();
        List<String> imagePathsItems = new ArrayList<>();

        //Цикл добавления в List всех путей к изображениям профиля пользователя
        for(int i = 0; i <=10; i++) {
            imagePathsMain.add("src/main/resources/images/Main"+i+".jpg");
        }

        //Цикл добавления в List всех путей к изображениям профиля магазина
        for(int i = 0; i <= 10; i++) {
            imagePathsShops.add("src/main/resources/images/Shop"+i+".jpg");
        }

        //Цикл добавления в List всех путей к изображениям товаров
        for(int i = 0; i <= 20; i++) {
            imagePathsItems.add("src/main/resources/images/Item"+i+".jpg");
        }


        //Цикл преобразования изображений профиля пользователя в массив байтов и занесение их в БД
        for(int i = 1; i<=10; i++) {
            image = new Image();
            BufferedImage bufferedImage = ImageIO.read(new File(imagePathsMain.get(i)));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", baos);
            byte[] data = baos.toByteArray();
            image.setIsMain(true);
            image.setPicture(data);
            addTestImageDao.save(image);
       }

        //Цикл преобразования изображений профиля магазина в массив байтов и занесение их в БД
        for(int i = 1; i<=10; i++) {
            image = new Image();
            BufferedImage bufferedImage = ImageIO.read(new File(imagePathsShops.get(i)));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", baos);
            byte[] data = baos.toByteArray();
            image.setIsMain(false);
            image.setPicture(data);
            addTestImageDao.save(image);
        }

        //Цикл преобразования изображений товаров в массив байтов и занесение их в БД
        for(int i = 1; i<=20; i++) {
            image = new Image();
            BufferedImage bufferedImage = ImageIO.read(new File(imagePathsItems.get(i)));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", baos);
            byte[] data = baos.toByteArray();
            image.setIsMain(false);
            image.setPicture(data);
            addTestImageDao.save(image);
        }
    }
}