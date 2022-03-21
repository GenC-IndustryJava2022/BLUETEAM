import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-checkout-page',
  templateUrl: './checkout-page.component.html',
  styleUrls: ['./checkout-page.component.css']
})
export class CheckoutPageComponent implements OnInit {

  constructor(private routes: ActivatedRoute,private router: Router) { }

  ngOnInit(): void {
  }

  redirectToEnd(){
    this.router.navigate(['/end'], { queryParams: {  } });
  }

}
