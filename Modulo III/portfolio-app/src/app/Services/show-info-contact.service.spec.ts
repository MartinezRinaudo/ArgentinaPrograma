import { TestBed } from '@angular/core/testing';

import { ShowInfoContactService } from './show-info-contact.service';

describe('ShowInfoContactService', () => {
  let service: ShowInfoContactService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShowInfoContactService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
