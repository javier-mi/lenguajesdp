import { TestBed } from '@angular/core/testing';

import { EquationsService } from './equations.service';

describe('EquationsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: EquationsService = TestBed.get(EquationsService);
    expect(service).toBeTruthy();
  });
});
