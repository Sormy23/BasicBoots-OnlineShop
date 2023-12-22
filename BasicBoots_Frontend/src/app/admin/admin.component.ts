import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {OrderService} from "../core/order.service";
import {Order} from "../model/order.model";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {

  orders: Order[] = [];

  constructor(protected router: Router, private orderService: OrderService) {}

  ngOnInit() {
    if (window.localStorage.getItem('token') == null) {
      this.router.navigateByUrl("login");
    }

    this.orderService.getOrders()
      .subscribe( data => {
        this.orders = data.result;
        console.log(this.orders)
      });
  }

  logout() {
    window.localStorage.removeItem('token');
    this.router.navigateByUrl("login");
  }
}
