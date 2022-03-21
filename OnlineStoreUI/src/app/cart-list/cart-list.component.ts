import { Component, Input, OnInit } from '@angular/core';
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
  product!: Product;
  buttonMessage='Delete';
  cartId = 2;
  cart!: Cart;
  private router!: Router;
  constructor(private productService: ProductService,   private activeProductService: ActiveProductService) {}

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


 // addToCart(): void {
      //   console.log('quantity: ' + this.quantity);
      //   let productId = parseInt(this.routes.snapshot.paramMap.get('id')!);
      //   let cartId = this.activeProductService.cartId;
      //   this.activeProductService
      //     .addActiveProduct(
      //       new ActiveProduct(0, productId, this.cartId, this.quantity)
      //     )
      //     .subscribe(() => (this.router.navigate(['/cart/' + cartId])));
      //   ;
      // }
      deleteProduct(): void{
        this.activeProductService.deleteProductFromActiveProduct(this.activeProduct)
        .subscribe();
        let elem:HTMLElement | null= document.getElementById("demo"+this.activeProduct.activeProductsId);
        if(elem != null){
          elem.remove();
        }
      }



}
