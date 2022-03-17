import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.css'],
})
export class ProductPageComponent implements OnInit {
  product!: Product;
  constructor(
    private routes: ActivatedRoute,
    private productService: ProductService
  ) {}

  ngOnInit(): void {
    this.productService
      .getProductById(parseInt(this.routes.snapshot.paramMap.get('id')!))
      .subscribe((response) => (this.product = response));
    console.log("product: " + this.product);
    // console.log(parseInt(this.routes.snapshot.paramMap.get('id')!));
    // this.product = this.productService.getProductById(
    //   parseInt(this.routes.snapshot.paramMap.get('id')!)
    // )!;
  }

  // isReady(): boolean {
  //   return this.product;
  // }
}
