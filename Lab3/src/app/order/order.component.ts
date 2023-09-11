import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ProductService} from "../core/product.service";
import {CartService} from "../core/cart.service";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit{

    constructor(private formBuilder: FormBuilder,private router: Router, private productService: ProductService, private cartService: CartService) { }

    addForm: FormGroup = new FormGroup({});

    ngOnInit() {
        this.addForm = this.formBuilder.group({
            anrede: [''],
            vorname: ['', Validators.required],
            name: ['', Validators.required],
            street: ['', Validators.required],
            zipCode: ['', Validators.required],
            city: ['', Validators.required],
        });
    }

    onSubmit() {
      console.log("Create order: " + this.addForm.value);

      //Create order in Backend

      this.cartService.cart = [];
      this.router.navigateByUrl("");
    }

    onCancel() {
        this.router.navigateByUrl("/basket");
    }
}
