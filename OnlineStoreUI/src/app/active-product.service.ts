import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, map, Observable } from 'rxjs';
import { ActiveProduct } from './active-product';
import { Product } from './product';

@Injectable({
  providedIn: 'root',
})
export class ActiveProductService {
  activeProducts!: ActiveProduct[];
  cartId = 1;
  baseURL: string = 'http://localhost:8088/activeproducts/';

  postHeader = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  constructor(private httpClient: HttpClient) {}

  getActiveProductsByCartId(cartId: number): Observable<ActiveProduct[]> {
    return this.httpClient
      .get<ActiveProduct[]>(this.baseURL + 'by_cart?cartId=' + cartId)
      .pipe(
        map((response) => {
          this.activeProducts = response;
          return response;
        }),
        catchError(this.handleError<any>())
      );
  }

  getActiveProductById(activeProductId: number): Observable<ActiveProduct> {
    return this.httpClient
      .get<ActiveProduct>(this.baseURL + 'find?id=' + activeProductId)
      .pipe(
        map((response) => {
          return response;
        }),
        catchError(this.handleError<any>())
      );
  }

  private handleError<T>(result?: T) {
    console.log('some error happened...');
    return result;
  }

  addActiveProduct(newActiveProduct: ActiveProduct) {
    newActiveProduct.activeProductsId = 0;
    return this.httpClient.post<ActiveProduct>(
      this.baseURL + 'add',
      newActiveProduct,
      this.postHeader
    ); //, this.postHeader)
    // this.httpClient.post<ActiveProduct>(this.baseURL +"add?browserInfo=", browserInfo) //, this.postHeader)
    // .subscribe(response => {this.activeProduct = response},(err) =>{console.log(err)})
  }
}
