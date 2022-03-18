import { Component, Input, OnInit } from '@angular/core';
import { ActiveProduct } from '../active-product';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-cart-list',
  templateUrl: './cart-list.component.html',
  styleUrls: ['./cart-list.component.css'],
})
export class CartListComponent implements OnInit {
  @Input() activeProduct!: ActiveProduct;
  product!: Product;

  constructor(private productService: ProductService) {}

  ngOnInit(): void {
    this.productService
      .getProductById(this.activeProduct.productId)
      .subscribe((response) => (this.product = response));}

  updateQuantity() {
    console.log('updated quantity:' + this.activeProduct.quantity);
  }

  isActiveProductDefined(
    maybeAActiveProduct: ActiveProduct = this.activeProduct
  ): boolean {
    return Boolean(maybeAActiveProduct);
  }

  isProductDefined(maybeAProduct: Product = this.product): boolean {
    return Boolean(maybeAProduct);
  }
}
