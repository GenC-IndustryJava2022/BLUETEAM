import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Cart } from '../cart';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.css'],
})
export class CartPageComponent implements OnInit {
  cart!: Cart;

  constructor(
    private routes: ActivatedRoute,
    private cartService: CartService
  ) {
    this.cartService
      .getCartById(parseInt(this.routes.snapshot.paramMap.get('id')!))
      .subscribe((response) => this.cartChecker(response));
  }

  // adding cart is wack?
  private cartChecker(maybeACart: Cart | undefined): Cart {
      console.log("checking cart: " + maybeACart)
      if (this.isCartDefined(maybeACart)) {
        console.log("cart exists: " + maybeACart!.cartId)
        this.cart = maybeACart!;
      } else {
      console.log("creating a new cart: ")
      // this.cart=new Cart(2,"");
      this.cartService
        .addCart('generic browser string')
        .subscribe((response) => this.cart =response);
    }
    return this.cart;
  }

  // isCartDefined():boolean {
  //   return Boolean(this.cart);
  // }

  isCartDefined(maybeACart:Cart=this.cart):boolean {
    return Boolean(maybeACart);
  }
  ngOnInit(): void {}
}
