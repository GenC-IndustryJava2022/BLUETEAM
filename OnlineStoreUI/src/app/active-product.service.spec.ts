import { TestBed } from '@angular/core/testing';

import { ActiveProductService } from './active-product.service';

describe('ActiveProductService', () => {
  let service: ActiveProductService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ActiveProductService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
