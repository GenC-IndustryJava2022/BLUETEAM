import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Category } from './category';

@Injectable({
  providedIn: 'root',
})
export class CategoryService {
  categories: Category[];
  baseURL: string = '';

  postHeader = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  // constructor(private httpClient: HttpClient) {
  constructor() {
    this.categories = [
      new Category(1, 'laptops', 'laptops.png'),
      new Category(2, 'desktops', 'desktops.png'),
    ];
  }

  addCategory(category: Category): boolean {
    // this.httpClient
    //   .post<Category>(this.baseURL + 'category', category, this.postHeader)
    //   .subscribe(
    //     (res) => {},
    //     (err) => {
    //       console.log(err);
    //     }
    //   );
    return true;
  }

  getAllCategories(): Category[] {
    return this.categories;
  }
  // getAllCategories(): Observable<Category> {
  //   return this.httpClient.get<Category[]>(this.baseURL + 'categories').pipe(
  //     map((response) => {
  //       this.categories = response;
  //       return response;
  //     }),
  //     catchError(this.handleError<any>())
  //   );
  // }

  getCategoryById(categoryId: number): Category | undefined {
    return this.categories.find((p) => p.id == categoryId);
  }

  private handleError<T>(result?: T) {
    console.log('some error happened...');
    return result;
  }
}
