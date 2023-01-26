<script type="text/javascript">
    var orderTable = document.getElementById("orders");
    var orders = orderTable.getElementsByTagName("tr")
    for (var i = 0; i < order.length; i++) {
        var deliveryButton = document.createElement("button");
        deliveryButton.innerHTML = "Delivered"
        orders[i].appendChild(deliveryButton);
    }
</script>