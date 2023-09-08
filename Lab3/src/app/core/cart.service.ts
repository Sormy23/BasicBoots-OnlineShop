import { Injectable } from '@angular/core';
import {Product} from "../model/product.model";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cart: { PRODUCT: Product, AMOUNT: number }[] = [];

  constructor() { }

  addToCart(product: Product) {
    if (this.cart.length == 0) {
      this.cart.push({PRODUCT: product, AMOUNT: 1});
    } else {
      let index = this.cart.findIndex(item => item.PRODUCT.id == product.id);
      if (index == -1) {
        this.cart.push({PRODUCT: product, AMOUNT: 1});
      } else {
        this.cart[index].AMOUNT++;
      }
    }
  }

  getBasketAmount(): number {
    let sum: number = 0;
    for (let i of this.cart) {
      sum += i.AMOUNT;
    }
    return sum;
  }

  removeFromCart(product: Product) {
    let index = this.cart.findIndex(item => item.PRODUCT.id == product.id);
    if (index != -1) {
      if (this.cart[index].AMOUNT == 1) {
        this.cart.splice(index, 1);
      } else {
        this.cart[index].AMOUNT--;
      }
    }
  }
}
