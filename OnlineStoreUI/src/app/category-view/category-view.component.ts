import { Component, Input, OnInit } from '@angular/core';
import { Category } from '../category';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-category-view',
  templateUrl: './category-view.component.html',
  styleUrls: ['./category-view.component.css'],
})
export class CategoryViewComponent implements OnInit {
  @Input() public category!: Category;
  products: Product[];
  constructor(private productService: ProductService) {
    this.products = [];
    // this.productService.getAllProducts().subscribe(
    //   response => this.products = response
    // );
  }

  ngOnInit(): void {
    this.products = this.productService.getProductsByCategoryId(
      this.category.id
    );
    console.log(this.products);
  }
}
