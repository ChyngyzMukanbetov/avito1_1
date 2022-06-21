async function categories() {
    let temp="";
    fetch("/api/categoryItems", {method: "GET", dataType: "JSON"})
        .then(res => res.json())
        .then(categories => {
            categories.forEach(function (category){
                temp += `
<p/>
                <a href="/category/${category.id}">${category.name}</a>
              `;
            })
            document.getElementById("categoriesForView").innerHTML = temp

        })
    closeModal()
}

categories()

function closeModal() {
    $.colorbox.close();
}