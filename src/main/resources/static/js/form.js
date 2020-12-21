document.addEventListener("DOMContentLoaded", function () {
    let step4 = document.querySelector("div[data-step='4']");
    let categoryList = document.querySelector("div[data-step='1']").querySelectorAll("input[name=categoryList]");
    let quantityBags = document.querySelector("input[name=quantity]");
    let institutions = document.querySelector("div[data-step='3']").querySelectorAll("input[name=institution]");
    let summaryText = document.querySelectorAll(".summary--text");

    step4.querySelector(".next-step").addEventListener("click", function () {
        if (quantityBags.value === "1") {
            summaryText[0].innerHTML = "Liczba worków: " + quantityBags.value + ", a w nim: ";
        } else if (quantityBags.value === "0") {
            summaryText[0].innerHTML = "Nie wybrano ilości worków";
        } else {
            summaryText[0].innerHTML = "Liczba worków: " + quantityBags.value + ", a w nich: ";
        }
        if (quantityBags.value !== "0") {
            for (let i = 0; i < categoryList.length; i++) {
                if (categoryList[i].checked) {
                    summaryText[0].innerHTML += categoryList[i].parentElement.querySelector(".description").innerHTML + ", ";
                }
            }
        }

        for(let i=0; i<institutions.length; i++){
            if(institutions[i].checked){
                let inst = institutions[i].parentElement.querySelector(".title span").innerHTML;
                summaryText[1].innerHTML = "Wybrana fundacja: " + inst;
            }
        }

        let inputs = step4.querySelectorAll("input");
        let formSectionColumn = document.querySelector("div[data-step='5']").querySelectorAll(".form-section--column");
        let address = formSectionColumn[0].querySelectorAll("li");
        let date = formSectionColumn[1].querySelectorAll("li");

        for(let i=0; i<address.length; i++){
            address[i].innerHTML = inputs[i].value;
        }

        date[0].innerHTML = inputs[4].value;
        date[1].innerHTML = inputs[5].value;

        let textarea = step4.querySelector("textarea");

        if(textarea.value !== ""){
            date[2].innerHTML = textarea.value;
        }else{
            date[2].innerHTML = "Brak uwag";
        }

    })
})