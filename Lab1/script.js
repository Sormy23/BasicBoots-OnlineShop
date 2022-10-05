var shopping_cart = []
if (JSON.parse(window.sessionStorage.getItem('user')) === null) {
    sessionStorage.setItem("user", JSON.stringify(shopping_cart))
}

function addItem(item) {
    shopping_cart = JSON.parse(window.sessionStorage.getItem('user'))
    var foundItem = false
    //If item in shoppingcart +1 else
    if (shopping_cart.length === 0) {
        addItemToList(item)
    } else {

        for (var i = 0; i < shopping_cart.length; i++) {
            if (shopping_cart[i].itemID === item) {
                shopping_cart[i].amount += 1
                foundItem = true
            }
        }
        if (!foundItem) {
            addItemToList(item)
        }

    }

    set_amount()

    //Update amount badge

    //document.getElementsByClassName('count_badge').innerHTML = amount

    sessionStorage.setItem("user", JSON.stringify(shopping_cart))
}


function addItemToList(item) {
    shopping_cart.push({itemID: item, amount: 1})
    console.log("add")
}


function set_amount() {
    var shop = []
    if (JSON.parse(window.sessionStorage.getItem('user')) === null) {
        sessionStorage.setItem("user", JSON.stringify(shop))
        console.log("empty it")
    }

    shop = JSON.parse(window.sessionStorage.getItem('user'))
    console.log("set amount")
    var amount = 0
    if (shop.length !== 0) {
        for (var i = 0; i < shop.length; i++) {
            amount += shop[i].amount
        }

        document.getElementById("count_badge").innerHTML = amount

    }

    console.log(amount)
}

