import {Component, OnInit, TemplateRef} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ProductService} from "../core/product.service";
import {CartService} from "../core/cart.service";
import {OrderService} from "../core/order.service";
import {Order} from "../model/order.model";
import {BasketComponent} from "../basket/basket.component";
import {BsModalRef, BsModalService} from "ngx-bootstrap/modal";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit{

    constructor(private modalService: BsModalService, private formBuilder: FormBuilder,protected router: Router, private productService: ProductService, private cartService: CartService, private orderService: OrderService, private basket: BasketComponent) { }

    addForm: FormGroup = new FormGroup({});
    modalRef: BsModalRef;

    ngOnInit() {
        this.addForm = this.formBuilder.group({
            anrede: [''],
            vorname: ['', Validators.required],
            name: ['', Validators.required],
            street: ['', Validators.required],
            zipCode: ['', Validators.required],
            city: ['', Validators.required],
        });
        console.log("Generated a new form")
    }

    onSubmit(successModal: TemplateRef<any>) {
      console.log("Create order: " + this.addForm.value);

      let order: Order = new Order();
      order.anrede = this.addForm.value.anrede;
      order.vorname = this.addForm.value.vorname;
      order.name = this.addForm.value.name;
      order.street = this.addForm.value.street;
      order.zipCode = this.addForm.value.zipCode;
      order.city = this.addForm.value.city;
      order.productList = this.cartService.cart;
      order.date = new Date();

      console.log("Order: " + JSON.stringify(order));

      this.orderService.saveOrder(order)
        .subscribe(data => {
          console.log("Saved order: " + data);
          console.log("Product list that was saved to backend: " + JSON.stringify(order.productList));
        },
          error => {
            console.log("Error saving order: " + JSON.stringify(error));
          });

      this.cartService.cart = [];
      this.router.navigateByUrl("");
      this.modalRef = this.modalService.show(successModal);
    }

    onCancel() {
        this.router.navigateByUrl("/basket");
    }

}
