// document.getElementById("count_badge").innerHTML
// JSON.parse(window.sessionStorage.getItem('user'))
// sessionStorage.setItem("user", JSON.stringify(set))


function set_amount() {
    let amount = 0
    let cart = []

    if (sessionStorage.getItem("user") == null) {
        sessionStorage.setItem("user", JSON.stringify(cart))
    }

    for (let i = 0; i < cart.length; i++) {
        amount += (JSON.parse(sessionStorage.getItem("user")))[i].amount
    }

    document.getElementById("count_badge").innerHTML = amount.toString(100)
}


function addItem(item) {
    let cart = []
    let exists = false

    if (sessionStorage.getItem("user") == null) {
        cart.push({ID: item, amount: 1})
        sessionStorage.setItem("user", JSON.stringify(cart))
    }

    cart = JSON.parse(sessionStorage.getItem("user"))

    for (let i = 0; i < cart.length; i++) {
        if (cart[i].ID == item) {
            exists = true
            cart[i].amount += 1
        }
    }

    if (!exists) {
        cart.push({ID: item, amount: 1})
    }

    sessionStorage.setItem("user", JSON.stringify(cart))
}