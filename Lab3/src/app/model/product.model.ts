export interface Product {
  id: number;
  purchases: number[];
  name: string;
  price: number;
  description: string;
  imageUrl: string;
  validFrom: Date;
  validTo: Date;
}
