import {Component, OnInit} from '@angular/core';
import {CartService} from "../core/cart.service";
import {Router} from "@angular/router";

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
      this.router.navigateByUrl("/shop");
    }
  }

}
