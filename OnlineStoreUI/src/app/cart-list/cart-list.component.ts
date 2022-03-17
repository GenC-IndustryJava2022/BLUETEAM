import { Component, Input, OnInit } from '@angular/core';
import { ActiveProduct } from '../active-product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-cart-list',
  templateUrl: './cart-list.component.html',
  styleUrls: ['./cart-list.component.css'],
})
export class CartListComponent implements OnInit {
  @Input() activeProduct!: ActiveProduct;

  constructor(private productService: ProductService) {}

  ngOnInit(): void {}

  isActiveProductDefined(
    maybeAActiveProduct: ActiveProduct = this.activeProduct
  ): boolean {
    return Boolean(maybeAActiveProduct);
  }
}
