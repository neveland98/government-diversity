import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllTermsComponent } from './all-terms.component';

describe('AllTermsComponent', () => {
  let component: AllTermsComponent;
  let fixture: ComponentFixture<AllTermsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllTermsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllTermsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
