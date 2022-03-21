import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartPageComponent } from './cart-page/cart-page.component';
import { CheckoutPageComponent } from './checkout-page/checkout-page.component';
import { EndPageComponent } from './end-page/end-page.component';
import { HomePageComponent } from './home-page/home-page.component';
import { ProductPageComponent } from './product-page/product-page.component';
import { SearchPageComponent } from './search-page/search-page.component';

const routes: Routes = [
  {path:'', component: HomePageComponent},
  {path:'search', component: SearchPageComponent},
  {path:'product/:id', component: ProductPageComponent},
  {path:'cart/:id', component: CartPageComponent},
  {path:'checkout',component: CheckoutPageComponent},
  {path:'end', component: EndPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
