import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-search-page',
  templateUrl: './search-page.component.html',
  styleUrls: ['./search-page.component.css'],
})
export class SearchPageComponent implements OnInit {
  public products!: Product[];
  public query: string = '';

  constructor(
    private routes: ActivatedRoute,
    private productService: ProductService
  ) {
    this.products = [];
  }

  ngOnInit(): void {
    this.routes.queryParams.subscribe((response) => {
      this.query = this.stringOrEmpty(response['q']);
      this.runSearch();
    });
  }

  runSearch(): void {
    this.productService
      .getProductsBySearchQuery(this.query)
      .subscribe((response) => (this.products = response));
  }

  stringOrEmpty(maybeAString: string): string {
    if (Boolean(maybeAString)) {
      return maybeAString;
    }
    return '';
  }
}
