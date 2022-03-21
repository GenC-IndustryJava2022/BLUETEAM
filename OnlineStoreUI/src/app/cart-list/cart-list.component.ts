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
  @Output() costEvent = new EventEmitter<number>();
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
        this.updateCost();
      });
  }

  updateQuantity() {
    // console.log('updated quantity:' + this.activeProduct.quantity);
    this.activeProductService.updateActiveProduct(this.activeProduct)
    .subscribe((response) => {
      this.activeProduct = response;
      this.updateCost();
    });
  }

  updateCost() {
    this.calculatedCost = this.product.price * this.activeProduct.quantity;
    this.costEvent.emit(this.calculatedCost);
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
      .subscribe();
    let elem: HTMLElement | null = document.getElementById(
      'demo' + this.activeProduct.activeProductsId
    );
    if (elem != null) {
      elem.remove();
    }
  }
}
