import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {ApiResponse} from "../model/api.response";
import {Order} from "../model/order.model";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http: HttpClient) { }
  baseUrl: string = environment.apiUrl + '/order/';

  getOrders(): Observable<ApiResponse<Order[]>> {
    console.log("Fetched all orders from backend");
    return this.http.get<ApiResponse<Order[]>>(this.baseUrl);
  }

  saveOrder(order: Order): Observable<ApiResponse<Order>> {
    console.log("Saved order");
    return this.http.post<ApiResponse<Order>>(this.baseUrl, order);
  }

  getOrderById(id: number): Observable<ApiResponse<Order>> {
    console.log("Fetched order from backend by id: " + id);
    return this.http.get<ApiResponse<Order>>(this.baseUrl + id);
  }

  cancelOrder(id: number): void {
    console.log("Canceled order with id: " + id);
    this.http.put<ApiResponse<void>>(this.baseUrl + 'cancel/' + id, null);
  }

  finishOrder(id: number): void {
    console.log("Finished order with id: " + id);
    this.http.put<ApiResponse<void>>(this.baseUrl + 'finish/' + id, null);
  }
}
