import {Product} from "./product.model";

export interface Order {
  id: number;
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
