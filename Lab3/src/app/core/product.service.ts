import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs/index";
import {ApiResponse} from "../model/api.response";
import {Product} from "../model/product.model";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }
  baseUrl = environment.apiUrl + '/product/';

  getProducts(): Observable<ApiResponse<Product[]>> {
    console.log("Fetched all products from backend");
    return this.http.get<ApiResponse<Product[]>>(this.baseUrl);
  }

  getProductById(id: number): Observable<ApiResponse<Product>> {
    console.log("Fetched product from backend by id");
    return this.http.get<ApiResponse<Product>>(this.baseUrl + id);
  }

  createProduct(product: Product): Observable<ApiResponse<Product>> {
    console.log("Created Product: " + product.name);
    return this.http.post<ApiResponse<Product>>(this.baseUrl, product);
  }

  searchProduct(searchString: string): Observable<ApiResponse<Product[]>> {
    console.log("Searched Product by Searchstring: " + searchString);
    return this.http.get<ApiResponse<Product[]>>(this.baseUrl + 'search/' + searchString);
  }

  updateProduct(product: Product): Observable<ApiResponse<Product>> {
    console.log("Updated Product: " + product.name);
    return this.http.put<ApiResponse<Product>>(this.baseUrl + product.id, product);
  }

  deactivateProduct(id: number): Observable<ApiResponse<void>> {
    console.log("Deactivated Product with id: " + id);
    return this.http.put<ApiResponse<void>>(this.baseUrl + 'deactivate/' + id, null);
  }

}
