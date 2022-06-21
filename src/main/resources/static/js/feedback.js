function footerWithFeedback() {
     let temp
        = "<footer id=\"footerId\" class=\" text-lg-start\">\n" +
        "    <div class=\"text-right p-3\" style=\"background-color: rgba(255, 255, 255, 0.0);\">\n" +
        "        <button type=\"button\" class=\"btn btn-outline-primary\" data-toggle=\"modal\" data-target=\"#feedbackModal\" data-whatever=\"@mdo\">Feedback</button>\n" +
        "\n" +
        "        <div class=\"modal fade\" id=\"feedbackModal\" tabindex=\"-1\" aria-labelledby=\"feedbackModalLabel\" aria-hidden=\"true\">\n" +
        "            <div class=\"modal-dialog\">\n" +
        "                <div class=\"modal-content\">\n" +
        "                    <div class=\"modal-header\">\n" +
        "                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Ваша жалоба или предложение</h5>\n" +
        "                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n" +
        "                            <span aria-hidden=\"true\">&times;</span>\n" +
        "                        </button>\n" +
        "                    </div>\n" +
        "                    <div class=\"modal-body\">\n" +
        "                        <form>\n" +
        "                            <div class=\"form-group\">\n" +
        "                                <label for=\"messagetext\" class=\"col-form-label\">Сообщение:</label>\n" +
        "                                <textarea class=\"form-control\" id=\"messagetext\"></textarea>\n" +
        "                            </div>\n" +
        "                        </form>\n" +
        "                    </div>\n" +
        "                    <div class=\"modal-footer\">\n" +
        "                        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Закрыть</button>\n" +
        "                        <button type=\"submit\" class=\"btn btn-primary\" onclick=\"newFeedback()\" data-dismiss=\"modal\"\n" +
        "                        >Отправить сообщение</button>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "        </div>\n" +
        "    </div>\n" +
        "</footer>"

    document.getElementById("footer").innerHTML = temp
}

footerWithFeedback()

async function newFeedback() {
    let feedbackDto = {fullText: document.getElementById('messagetext').value}


    await fetch("/api/feedback/", {
        method: 'POST',
        headers: {'Accept': 'application/json', 'Content-Type': 'application/json;charset=UTF-8'},
        body: JSON.stringify(feedbackDto)
    })
}

