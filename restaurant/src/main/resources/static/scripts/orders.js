// Get the ready order table element
const table = document.getElementById("readyForDelivery");

// Get the number of orders ready for delivery
const readyOrders = table.rows.length - 1;

var message = " orders are ready for delivery!"

/**
 * This function notifies the waiter about the ready orders via a toastr message.
 */
function notify() {
    if (readyOrders == 0) {
        toastr.success("There are no orders ready for delivery!");
    } else {
        message = readyOrders + message;
        toastr.success(message);
    }
}

// Call notify function when the table loads
window.addEventListener("load", notify);