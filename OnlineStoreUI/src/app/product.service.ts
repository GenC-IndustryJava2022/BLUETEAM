import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  products!: Product[];
  baseURL: string = 'http://localhost:8088/products/';

  constructor(private httpClient: HttpClient) {
    // this.products = [
    //   new Product(
    //     103,
    //     'Snapbook Pro',
    //     1700,
    //     'snapbook-pro.png',
    //     'It just works, sometimes.',
    //     1
    //   ),
    //   new Product(
    //     104,
    //     'Mystery Laptop',
    //     1600,
    //     'mystery-laptop.png',
    //     'Let us choose a laptop for you! No returns.',
    //     1
    //   )
    // ];
  }

  // getAllProducts(): Product[] {
  //   return this.products;
  // }
  getAllProducts(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.baseURL + 'all').pipe(
      map((response) => {
        this.products = response;
        return response;
      }),
      catchError(this.handleError<any>())
    );
  }

  getProductById(productId: number): Product | undefined {
    return this.products.find((p) => p.id == productId);
  }

  // getProductsByCategoryId(categoryId: number): Product[] {
  //   return this.products.filter((p) => p.categoryId == categoryId);
  // }

  getProductsByCategoryId(categoryId: number): Observable<Product[]> {
    return this.httpClient
      .get<Product[]>(this.baseURL + 'by_category?categoryId=' + categoryId)
      .pipe(
        map((response) => {
          this.products = response;
          return response;
        }),
        catchError(this.handleError<any>())
      );
  }

  private handleError<T>(result?: T) {
    console.log('some error happened...');
    return result;
  }
}
