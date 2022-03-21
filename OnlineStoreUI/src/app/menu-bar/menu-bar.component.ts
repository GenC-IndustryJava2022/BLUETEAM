import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-menu-bar',
  templateUrl: './menu-bar.component.html',
  styleUrls: ['./menu-bar.component.css'],
})
export class MenuBarComponent implements OnInit {
  cartId = 1;
  constructor(private cartService: CartService, private router: Router) {}

  ngOnInit(): void {}

  navToCart(): void {
      this.router.navigate(['/cart/' + this.cartId]);
  }
}
