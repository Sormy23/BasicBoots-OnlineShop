var shopping_cart = []
localStorage.setItem("user", JSON.stringify(shopping_cart))

function addItem(item) {
    shopping_cart = JSON.parse(window.localStorage.getItem('user'))
    var amount = 0
    var foundItem = false
    //If item in shoppingcart +1 else
    if (shopping_cart.length === 0) {
        addItemToList(item);
    } else {

        for (var i = 0; i < shopping_cart.length; i++) {
            if (shopping_cart[i].itemID === item) {
                shopping_cart[i].amount += 1
                foundItem = true
            }
            amount += shopping_cart[i].amount
        }
        if (!foundItem) {
            addItemToList(item)
        }

    }

    console.log(shopping_cart)
    console.log(amount)
    //Update amount badge

    localStorage.setItem("user", JSON.stringify(shopping_cart))
}

function addItemToList(item) {
    shopping_cart.push({itemID: item, amount: 1})
}
