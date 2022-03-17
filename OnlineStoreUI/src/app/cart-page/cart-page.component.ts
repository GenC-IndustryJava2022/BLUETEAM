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
      
     let newCart=this.cartService
      .getCartById(parseInt(this.routes.snapshot.paramMap.get('id')!));
    console.log("cart: " + parseInt(this.routes.snapshot.paramMap.get('id')!));
      if(typeof newCart=='undefined'){
       this.cart=new Cart(2,"");
      }
      else{
        this.cart=newCart;
      }
     }
    

  ngOnInit(): void {

 

  }

}
