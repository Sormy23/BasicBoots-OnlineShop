import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HomepageComponent } from './homepage/homepage.component';
import { AppRoutingModule } from './app-routing.module';
import { ShopComponent } from './shop/shop.component';
import { BasketComponent } from './basket/basket.component';
import { ImprintComponent } from './imprint/imprint.component';
import { NotFoundComponent } from './not-found/not-found.component';
import {ProductService} from "./core/product.service";
import {HttpClientModule} from "@angular/common/http";
import {NgOptimizedImage} from "@angular/common";
import { OrderComponent } from './order/order.component';
import {ReactiveFormsModule} from "@angular/forms";
import {ModalModule} from "ngx-bootstrap/modal";
import { LoginComponent } from './login/login.component';
import {AuthenticationService} from "./core/authentication.service";
import { AdminComponent } from './admin/admin.component';

@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    ShopComponent,
    BasketComponent,
    ImprintComponent,
    NotFoundComponent,
    OrderComponent,
    LoginComponent,
    AdminComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgOptimizedImage,
    ReactiveFormsModule,
    ModalModule.forRoot()
  ],
  providers: [ProductService, BasketComponent, AuthenticationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
