import {Injectable, OnInit} from '@angular/core';
import {Product} from "../model/product.model";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cart: Product[] = [];

  constructor() { }

  //TODO: Implement Session Storage

  addToCart(product: Product) {
    if (this.cart.length == 0) {
      product.quantity = 1;
      this.cart.push(product);
      console.log("Added product to the basket: " + product.name);
    } else {
      let index = this.cart.findIndex(item => item.id == product.id);
      if (index == -1) {
        product.quantity = 1;
        this.cart.push(product);
        console.log("Added product to the basket: " + product.name);
      } else {
        this.cart[index].quantity++;
        console.log("Increased amount in basket of the product: " + product.name);
      }
    }
  }

  getBasketAmount(): number {
    let sum: number = 0;
    for (let i of this.cart) {
      sum += i.quantity;
    }
    console.log("Calculated basket amount: " + sum);
    return sum;
  }

  removeFromCart(product: Product) {
    let index = this.cart.findIndex(item => item.id == product.id);
    if (index != -1) {
      if (this.cart[index].quantity == 1) {
        console.log("Remove product from cart: " + product.name);
        this.cart.splice(index, 1);
      } else {
        this.cart[index].quantity--;
        console.log("Decrease number of product: " + product.name);
      }
    }
  }


}
