import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  products!: Product[];
  baseURL: string = '';

  postHeader = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  // constructor(private httpClient: HttpClient) {
  constructor() {
    this.products = [
      new Product(
        103,
        'Snapbook Pro',
        1700,
        'snapbook-pro.png',
        'It just works, sometimes.',
        1
      ),
      new Product(
        104,
        'Mystery Laptop',
        1600,
        'mystery-laptop.png',
        'Let us choose a laptop for you! No returns.',
        1
      )
    ];
  }

  addProduct(product: Product): boolean {
    // this.httpClient
    //   .post<Product>(this.baseURL + 'product', product, this.postHeader)
    //   .subscribe(
    //     (res) => {},
    //     (err) => {
    //       console.log(err);
    //     }
    //   );
    return true;
  }

  getAllProducts(): Product[] {
    return this.products;
  }
  // getAllProducts(): Observable<Product> {
  //   return this.httpClient.get<Product[]>(this.baseURL + 'products').pipe(
  //     map((response) => {
  //       this.products = response;
  //       return response;
  //     }),
  //     catchError(this.handleError<any>())
  //   );
  // }

  getProductById(productId: number): Product | undefined {
    return this.products.find((p) => p.id == productId);
  }

  getProductsByCategoryId(categoryId: number): Product[] {
    return this.products.filter((p) => p.categoryId == categoryId);
  }

  private handleError<T>(result?: T) {
    console.log('some error happened...');
    return result;
  }
}
