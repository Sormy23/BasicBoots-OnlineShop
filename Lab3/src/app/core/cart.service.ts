import {Injectable, OnInit} from '@angular/core';
import {Product} from "../model/product.model";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cart: { PRODUCT: Product, AMOUNT: number }[] = [];

  constructor() { }

  //TODO: Implement Session Storage

  addToCart(product: Product) {
    if (this.cart.length == 0) {
      this.cart.push({PRODUCT: product, AMOUNT: 1});
      console.log("Added product to the basket: " + product.name);
    } else {
      let index = this.cart.findIndex(item => item.PRODUCT.id == product.id);
      if (index == -1) {
        this.cart.push({PRODUCT: product, AMOUNT: 1});
        console.log("Added product to the basket: " + product.name);
      } else {
        this.cart[index].AMOUNT++;
        console.log("Increased amount in basket of the product: " + product.name);
      }
    }
  }

  getBasketAmount(): number {
    let sum: number = 0;
    for (let i of this.cart) {
      sum += i.AMOUNT;
    }
    console.log("Calculated basket amount: " + sum);
    return sum;
  }

  removeFromCart(product: Product) {
    let index = this.cart.findIndex(item => item.PRODUCT.id == product.id);
    if (index != -1) {
      if (this.cart[index].AMOUNT == 1) {
        console.log("Remove product from cart: " + product.name);
        this.cart.splice(index, 1);
      } else {
        this.cart[index].AMOUNT--;
        console.log("Decrease number of product: " + product.name);
      }
    }
  }


}
