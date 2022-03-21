import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuBarComponent } from './menu-bar/menu-bar.component';
import { SearchFieldComponent } from './search-field/search-field.component';
import { HomePageComponent } from './home-page/home-page.component';
import { CategoryViewComponent } from './category-view/category-view.component';
import { ProductsListComponent } from './products-list/products-list.component';
import { ProductPreviewComponent } from './product-preview/product-preview.component';
import { SearchPageComponent } from './search-page/search-page.component';
import { ProductPageComponent } from './product-page/product-page.component';
import { CartPageComponent } from './cart-page/cart-page.component';
import { CartListComponent } from './cart-list/cart-list.component';
import { CheckoutFormComponent } from './checkout-form/checkout-form.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EndPageComponent } from './end-page/end-page.component';
import { CheckoutPageComponent } from './checkout-page/checkout-page.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuBarComponent,
    SearchFieldComponent,
    HomePageComponent,
    CategoryViewComponent,
    ProductsListComponent,
    ProductPreviewComponent,
    SearchPageComponent,
    ProductPageComponent,
    CartPageComponent,
    CartListComponent,
    CheckoutFormComponent,
    EndPageComponent,
    CheckoutPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
