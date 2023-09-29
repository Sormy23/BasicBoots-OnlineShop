import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { HomepageComponent } from './homepage/homepage.component';
import { ShopComponent } from './shop/shop.component';
import { ImprintComponent } from './imprint/imprint.component';
import { BasketComponent } from './basket/basket.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { OrderComponent } from './order/order.component';
import { LoginComponent } from "./login/login.component";

const routes: Routes = [
  { path: '', component: HomepageComponent },
  { path: 'shop', component: ShopComponent },
  { path: 'imprint', component: NotFoundComponent },
  { path: 'basket', component: BasketComponent },
  { path: 'order', component: OrderComponent },
  { path: 'login', component: LoginComponent },
  { path: 'admin', component: NotFoundComponent},
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
