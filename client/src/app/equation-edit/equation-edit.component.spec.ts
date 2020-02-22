import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EquationEditComponent } from './equation-edit.component';

describe('EquationEditComponent', () => {
  let component: EquationEditComponent;
  let fixture: ComponentFixture<EquationEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EquationEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EquationEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
