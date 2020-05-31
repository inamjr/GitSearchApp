import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DbinfoComponent } from './dbinfo.component';

describe('DbinfoComponent', () => {
  let component: DbinfoComponent;
  let fixture: ComponentFixture<DbinfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DbinfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DbinfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
