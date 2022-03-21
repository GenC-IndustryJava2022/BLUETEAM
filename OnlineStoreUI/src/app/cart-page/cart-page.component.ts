import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ActiveProduct } from '../active-product';
import { ActiveProductService } from '../active-product.service';
import { Cart } from '../cart';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.css'],
})
export class CartPageComponent implements OnInit {
  cart!: Cart;
  activeProducts!: ActiveProduct[];
  totalCost: number = 0;

  constructor(
    private routes: ActivatedRoute,
    private cartService: CartService,
    private activeProductService: ActiveProductService,
    private router: Router
  ) {
    this.cartService
      .getCartById(parseInt(this.routes.snapshot.paramMap.get('id')!))
      .subscribe((response) => {
        this.cart = response;
        this.isCartDefined()
          ? this.getActiveProducts()
          : (this.activeProducts = []);
      });
      this.calculateTotalPrice();
  }

  ngOnInit(): void {}

  getActiveProducts() {
    this.activeProductService
      .getActiveProductsByCartId(this.cart.cartId)
      .subscribe((response) => {
        this.activeProducts = response;
      });
  }

  calculateTotalPrice() {
    this.totalCost = 0;
    // this.totalCost = this.activeProducts.reduce((pV, activeProduct) => prev + activeProduct.)
  }

  isCartDefined(maybeACart: Cart = this.cart): boolean {
    return Boolean(maybeACart);
  }

  redirectToCheckout(){
    this.router.navigate(['/checkout'], { queryParams: {  } });
  }

  // adding cart is wack?
  private cartChecker(maybeACart: Cart | undefined): Cart {
    console.log('checking cart: ' + maybeACart);
    if (this.isCartDefined(maybeACart)) {
      console.log('cart exists: ' + maybeACart!.cartId);
      this.cart = maybeACart!;
    } else {
      console.log('creating a new cart: ');
      // this.cart=new Cart(2,"");
      this.cartService
        .addCart('generic browser string')
        .subscribe((response) => (this.cart = response));
    }
    return this.cart;
  }
}
