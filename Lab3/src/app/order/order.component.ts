import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ProductService} from "../core/product.service";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit{

    constructor(private formBuilder: FormBuilder,private router: Router, private productService: ProductService) { }

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

    }
}
