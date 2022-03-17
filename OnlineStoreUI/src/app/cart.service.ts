import { Injectable } from '@angular/core';
import { Cart } from './cart';
@Injectable({
  providedIn: 'root'
})
export class CartService {
carts!: Cart[];


  constructor() {
    this.carts=[
      new Cart(1,'Chrome 96.0.4664.110 Windows 10 20H2'),
      new Cart(2,'Firefox 89.0.238 Windows 10 20H2')
    ];
   }

   getCartById(cartId: number): Cart | undefined {
    console.log(this.carts.find((p) => p.cartId == cartId));
    return this.carts.find((p) => p.cartId == cartId);
  }
}
