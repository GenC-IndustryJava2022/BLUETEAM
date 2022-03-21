import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-checkout-form',
  templateUrl: './checkout-form.component.html',
  styleUrls: ['./checkout-form.component.css']
})
export class CheckoutFormComponent implements OnInit {

  constructor(private routes: ActivatedRoute,private router: Router) { }

  ngOnInit(): void {
  }

  redirectToEnd(){
    this.router.navigate(['/end'], { queryParams: {  } });
  }
  

}
