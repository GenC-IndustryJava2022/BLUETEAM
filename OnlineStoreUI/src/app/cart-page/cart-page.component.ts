import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Cart } from '../cart';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.css']
})
export class CartPageComponent implements OnInit {

  cart!: Cart;



  constructor(  private routes: ActivatedRoute,
    private cartService: CartService) {
      
    this.cartService
      .getCartById(parseInt(this.routes.snapshot.paramMap.get('id')!))
     .subscribe((response) => (this.cartChecker(response)));
     
     }
    
     private cartChecker(maybeACart: Cart| undefined ): Cart{

      if(typeof maybeACart=='undefined'){
        this.cart=new Cart(2,"");
       }
       else{
         this.cart=maybeACart;
       }
       return this.cart;
     }
  ngOnInit(): void {

 

  }

}
