import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, Observable } from 'rxjs';
import {Cart } from './cart';
@Injectable({
  providedIn: 'root'
})
export class CartService {
cart!: Cart;
baseURL: string = 'http://localhost:8088/carts/';

// postHeader = {
//   headers:  new HttpHeaders({
//     'Content-Type': 'application/json'
//   })
// };

  constructor(private httpClient: HttpClient) {
    // this.carts=[
    //   new Cart(1,'Chrome 96.0.4664.110 Windows 10 20H2'),
    //   new Cart(2,'Firefox 89.0.238 Windows 10 20H2')
    // ];
   }

  //  getCartById(cartId: number): Cart | undefined {
  //   console.log(this.carts.find((p) => p.cartId == cartId));
  //   return this.carts.find((p) => p.cartId == cartId);
  // }

  getCartById(cartId: number): Observable<Cart>{
    return this.httpClient.get<Cart>(this.baseURL + 'find?id='+ cartId).pipe(
      map((response) => {
        this.cart = response;
        return response;
      }),
      catchError(this.handleError<any>())
    );
  }

  private handleError<T>(result?: T) {
    console.log('some error happened...');
    return result;
  }


  addCart(browserInfo:string):Observable<Cart>{
    return this.httpClient.post<Cart>(this.baseURL +"add?browserInfo=", browserInfo)
  }

  getTotalCost(cartId: number):Observable<number>{
  return this.httpClient.get<number>(this.baseURL + 'total_cost?id='+ cartId).pipe(
    map((response) => {
      return response;
    }),
    catchError(this.handleError<any>())
  );
  }
}
