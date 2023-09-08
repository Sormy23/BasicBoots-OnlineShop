import { Component } from '@angular/core';
import {Router} from '@angular/router';
import {CartService} from "./cart.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Lab3';

  getURL() {
    return this.router.url;
  }

  isBasketEmpty(): boolean {
    return this.cartService.cart.length == 0;
  }

  constructor(private router: Router, private cartService: CartService) {
  }

  protected readonly console = console;
}
