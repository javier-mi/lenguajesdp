import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EquationsListComponent } from './equations-list.component';

describe('EquationsListComponent', () => {
  let component: EquationsListComponent;
  let fixture: ComponentFixture<EquationsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EquationsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EquationsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
