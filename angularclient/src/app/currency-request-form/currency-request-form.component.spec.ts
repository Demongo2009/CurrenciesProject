import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CurrencyRequestFormComponent } from './currency-request-form.component';

describe('CurrencyRequestFormComponent', () => {
  let component: CurrencyRequestFormComponent;
  let fixture: ComponentFixture<CurrencyRequestFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CurrencyRequestFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CurrencyRequestFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
