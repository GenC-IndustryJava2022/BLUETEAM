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
  buttonMessage = 'Add to Cart';

  addForm = this.fb.group({ quantity: new FormControl('') });

  constructor(
    private routes: ActivatedRoute,
    private productService: ProductService,
    private activeProductService: ActiveProductService,
    private fb: FormBuilder,
    private router: Router
  ) {}

  get quantity() {
    return this.addForm.get('quantity')?.value;
  }

  ngOnInit(): void {
    this.productService
      .getProductById(parseInt(this.routes.snapshot.paramMap.get('id')!))
      .subscribe((response) => (this.product = response));
    // console.log(parseInt(this.routes.snapshot.paramMap.get('id')!));
    // this.product = this.productService.getProductById(
    //   parseInt(this.routes.snapshot.paramMap.get('id')!)
    // )!;
  }

  // isReady(): boolean {
  //   return this.product;
  // }

  addToCart(): void {
    console.log('quantity: ' + this.quantity);
    let productId = parseInt(this.routes.snapshot.paramMap.get('id')!);
    let cartId = this.activeProductService.cartId;
    this.activeProductService
      .addActiveProduct(
        new ActiveProduct(0, productId, this.cartId, this.quantity)
      )
      .subscribe(() => (this.router.navigate(['/cart/' + cartId])));
    ;
  }

  isProductDefined(maybeAProduct: Product = this.product): boolean {
    return Boolean(maybeAProduct);
  }
}
