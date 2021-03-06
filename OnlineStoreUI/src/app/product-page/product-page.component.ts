import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ActiveProduct } from '../active-product';
import { ActiveProductService } from '../active-product.service';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.css'],
})
export class ProductPageComponent implements OnInit {
  product!: Product;
  cartId = 1;
  isInCart = false;
  quantity:number = 1;
  buttonMessage = 'Add to Cart';

  constructor(
    private routes: ActivatedRoute,
    private productService: ProductService,
    private activeProductService: ActiveProductService,
    private fb: FormBuilder,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.productService
      .getProductById(parseInt(this.routes.snapshot.paramMap.get('id')!))
      .subscribe((response) => (this.product = response));
  }

  addToCart(): void {
    console.log('quantity: ' + this.quantity);
    let productId = parseInt(this.routes.snapshot.paramMap.get('id')!);
    let cartId = this.activeProductService.cartId;
    this.activeProductService
      .addActiveProduct(
        new ActiveProduct(0, productId, this.cartId, this.quantity)
      )
      .subscribe(
        () => this.goToCart(),
        (error) => this.handleError(error)
      );
  }

  isProductDefined(maybeAProduct: Product = this.product): boolean {
    return Boolean(maybeAProduct);
  }

  goToCart() {
    this.router.navigate(['/cart/' + this.cartId]);
  }

  handleError(error: any): void {
    if ((error.status = 409)) {
      console.log('already in cart');
      this.isInCart = true;
      this.goToCart();
    } else {
      console.log('some error happened');
    }
  }
}
