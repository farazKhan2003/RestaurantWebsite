document.getElementById("orderButton").addEventListener("click", function(){
    fetch('/add_to_basket', {method: 'POST'})
}