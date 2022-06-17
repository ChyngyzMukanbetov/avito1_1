console.log("static js file")

ratingStars()

function changeImage(element) {

    var main_prodcut_image = document.getElementById('main_product_image');
    main_prodcut_image.src = element.src;


}

function getDescription() {
    const $elem = document.querySelector('#description')
    $elem.textContent = 'Описание'
}

function ratingStars() {
    const rating = 5
    let temp = `<span class="fas fa-star"></span>`
    const starBar = document.querySelector('#rating')
    for (let i = 1; i < rating; i++) {
        temp += `<span class="fas fa-star"></span>`
    }
    temp += `<a href="#" class="px-lg-2 px-1 reviews">{3 Reviews}</a>`
    starBar.innerHTML = temp
}