import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-search-field',
  templateUrl: './search-field.component.html',
  styleUrls: ['./search-field.component.css'],
})
export class SearchFieldComponent implements OnInit {
  query!: string;

  constructor(private routes: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    this.routes.queryParams.subscribe((response) => {
      this.query = this.stringOrEmpty(response['q']);
    });
  }

  stringOrEmpty(maybeAString: string): string {
    if (Boolean(maybeAString)) {
      return maybeAString;
    }
    return '';
  }

  redirectToSearch(): void {
    this.router.navigate(['/search'], { queryParams: { q: this.query } });
  }
}
