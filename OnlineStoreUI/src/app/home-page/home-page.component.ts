import { Component, OnInit } from '@angular/core';
import { Category } from '../category';
import { CategoryService } from '../category.service';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css'],
})
export class HomePageComponent implements OnInit {
  categories!: Category[];
  constructor(private categoryService: CategoryService) {
    // this.categories = this.categoryService.getAllCategories();
    this.categoryService
      .getAllCategories()
      .subscribe((response) => (this.categories = response));
    console.log(this.categories);
  }

  ngOnInit(): void {}
}
