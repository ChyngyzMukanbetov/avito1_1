console.log("static js file")
var swiper = new Swiper(".mySwiperItems", {
    slidesPerView: 4,
    spaceBetween: 30,
    slidesPerGroup: 4,
    loop: true,
    loopFillGroupWithBlank: true,
    pagination: {
        el: ".swiperItems-pagination",
        clickable: true,
    },
    navigation: {
        nextEl: ".swiperItems-button-next",
        prevEl: ".swiperItems-button-prev",
    },
});

var swiper = new Swiper(".mySwiperShops", {
    slidesPerView: 6,
    spaceBetween: 15,
    slidesPerGroup: 6,
    loop: true,
    loopFillGroupWithBlank: true,
    pagination: {
        el: ".swiperShops-pagination",
        clickable: true,
    },
    navigation: {
        nextEl: ".swiperShops-button-next",
        prevEl: ".swiperShops-button-prev",
    },
});

