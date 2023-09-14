import {Component, OnInit} from '@angular/core';
import {CartService} from "../core/cart.service";
import {Router} from "@angular/router";
import {Product} from "../model/product.model";

@Component({
  selector: 'app-basket',
  templateUrl: './basket.component.html',
  styleUrls: ['./basket.component.css']
})
export class BasketComponent implements OnInit{
  constructor(protected cartService: CartService, private router: Router) {
  }

  ngOnInit() {
    if (this.cartService.cart.length == 0) {
      this.router.navigateByUrl("/shop"); // Auto redirect if cart page is empty
    }
  }

  removeFromCart(product: Product) {
    this.cartService.removeFromCart(product);
    if (this.cartService.cart.length == 0) {
      this.router.navigateByUrl("/shop"); // Auto redirect when last item is removed and cart is empty
    }
  }

  calculateEndPrice(): number {
    let sum: number = 0;
    for (let product of this.cartService.cart) {
      sum += product.quantity * product.price;
    }
    return sum;
  }

}
