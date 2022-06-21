function itemCard() {
    let shopId = document.documentURI.split('/').pop();
    let temp="";
    fetch("/api/item/shopItems/" + shopId, {method: "GET", dataType: "JSON"})
        .then(res => res.json())
        .then(items => {
            items.forEach(function (item) {
                temp += `
                <div class="card" style="width: 18rem;">
  <img src="${item.images.shift()}" class="card-img-top" alt="изображение товара">
  <div class="card-body">
    <h5 class="card-title">${item.name}</h5>
    <p class="card-text">${item.description}</p>
    <p class="card-text">Цена: ${item.price}</p>
    <a href="/item/${item.id}" class="btn btn-primary">Страница товара</a>
  </div>
</div>`})
            document.getElementById("itemCardforView").innerHTML = temp
        })
}
itemCard();

