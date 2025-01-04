import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompetenciaPickerComponent } from './competencia-picker.component';

describe('CompetenciaPickerComponent', () => {
  let component: CompetenciaPickerComponent;
  let fixture: ComponentFixture<CompetenciaPickerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CompetenciaPickerComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CompetenciaPickerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
