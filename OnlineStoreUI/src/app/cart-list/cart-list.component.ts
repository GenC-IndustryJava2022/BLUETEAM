import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActiveProduct } from '../active-product';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { ActiveProductService } from '../active-product.service';
import { Cart } from '../cart';
import { ActivatedRoute, Router } from '@angular/router';
import { ElementSchemaRegistry } from '@angular/compiler';
@Component({
  selector: 'app-cart-list',
  templateUrl: './cart-list.component.html',
  styleUrls: ['./cart-list.component.css'],
})
export class CartListComponent implements OnInit {
  @Input() activeProduct!: ActiveProduct;
  @Output() costEvent = new EventEmitter<ActiveProduct>();
  product!: Product;
  calculatedCost: number = 0;
  buttonMessage = 'Delete';
  cartId = 2;
  cart!: Cart;
  private router!: Router;
  constructor(
    private productService: ProductService,
    private activeProductService: ActiveProductService
  ) {}

  ngOnInit(): void {
    this.productService
      .getProductById(this.activeProduct.productId)
      .subscribe((response) => {
        this.product = response;
      });
  }

  updateQuantity() {
    this.activeProductService.updateActiveProduct(this.activeProduct)
    .subscribe((response) => {
      this.activeProduct = response;
      this.costEvent.emit(this.activeProduct);
    });
  }

  isActiveProductDefined(
    maybeAActiveProduct: ActiveProduct = this.activeProduct
  ): boolean {
    return Boolean(maybeAActiveProduct);
  }

  isProductDefined(maybeAProduct: Product = this.product): boolean {
    return Boolean(maybeAProduct);
  }

  deleteProduct(): void {
    this.activeProductService
      .deleteProductFromActiveProduct(this.activeProduct)
      .subscribe(() => (this.costEvent.emit(undefined)));
    let elem: HTMLElement | null = document.getElementById(
      'demo' + this.activeProduct.activeProductsId
    );
    if (elem != null) {
      elem.remove();
    }
  }
}
