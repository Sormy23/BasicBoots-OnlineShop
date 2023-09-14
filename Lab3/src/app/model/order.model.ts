import {Product} from "./product.model";

export interface Order {
  anrede: string;
  vorname: string;
  name: string;
  street: string;
  zipCode: string;
  city: string;
  date: Date;
  price: number;
  finished: Date;
  canceled: Date;
  productList: any;
}
