import { Injectable } from '@angular/core';
import {Product} from "./model/product.model";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cart: any[] = [];

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
}
