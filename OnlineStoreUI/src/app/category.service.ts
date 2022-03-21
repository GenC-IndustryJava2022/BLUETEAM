import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, map, Observable } from 'rxjs';
import { Category } from './category';

@Injectable({
  providedIn: 'root',
})
export class CategoryService {
  categories!: Category[];
  // I think the actual DB URL should be an environment variable?
  baseURL: string = 'http://localhost:8088/categories/';

  postHeader = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  constructor(private httpClient: HttpClient) {
    // this.categories = [
    //   new Category(1, 'laptops', 'laptops.png'),
    //   new Category(2, 'desktops', 'desktops.png'),
    // ];
  }

  // getAllCategories(): Category[] {
  //   return this.categories;
  // }

  getAllCategories(): Observable<Category[]> {
    return this.httpClient.get<Category[]>(this.baseURL + 'all').pipe(
      map((response) => {
        this.categories = response;
        return response;
      }),
      catchError(this.handleError<any>())
    );
  }

  getCategoryById(categoryId: number): Category | undefined {
    return this.categories.find((p) => p.categoryId == categoryId);
  }

  private handleError<T>(result?: T) {
    console.log('some error happened...');
    return result;
  }
}
