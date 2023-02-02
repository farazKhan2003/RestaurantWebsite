document.getElementById("orderButton").addEventListener("click", function(){
    fetch('/add-to-basket', {method: 'POST'})
}