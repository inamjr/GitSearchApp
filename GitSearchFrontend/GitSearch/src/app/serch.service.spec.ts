import { TestBed } from '@angular/core/testing';

import { SerchService } from './serch.service';

describe('SerchService', () => {
  let service: SerchService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SerchService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
