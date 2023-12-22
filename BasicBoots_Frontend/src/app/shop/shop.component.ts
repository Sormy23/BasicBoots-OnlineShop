import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {ProductService} from "../core/product.service";
import {Product} from "../model/product.model";
import {CartService} from "../core/cart.service";

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit{

  products: Product[] = [];

  constructor(private router: Router, private productService: ProductService, protected cartService: CartService) { }

  ngOnInit() {
    this.productService.getProducts()
      .subscribe( data => {
        this.products = data.result;
      });
  }
}
