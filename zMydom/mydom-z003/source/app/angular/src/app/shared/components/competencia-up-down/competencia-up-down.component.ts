import { CommonModule } from '@angular/common';
import { ChangeDetectorRef, Component, forwardRef, Input, OnInit } from '@angular/core';
import { NG_VALUE_ACCESSOR } from '@angular/forms';

@Component({
  standalone: true,
  selector: 'app-competencia-up-down',
  templateUrl: './competencia-up-down.component.html',
  styleUrls: ['./competencia-up-down.component.css'],
  imports: [CommonModule],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => CompetenciaUpDownComponent),
      multi: true
    }
  ],
})
export class CompetenciaUpDownComponent 
        implements OnInit {

  @Input() monthFormat: 'short' | 'long' = 'short';
  competencia: number = 0;

  months = [
    { short: 'Jan', long: 'Janeiro' },
    { short: 'Fev', long: 'Fevereiro' },
    { short: 'Mar', long: 'Março' },
    { short: 'Abr', long: 'Abril' },
    { short: 'Mai', long: 'Maio' },
    { short: 'Jun', long: 'Junho' },
    { short: 'Jul', long: 'Julho' },
    { short: 'Ago', long: 'Agosto' },
    { short: 'Set', long: 'Setembro' },
    { short: 'Out', long: 'Outubro' },
    { short: 'Nov', long: 'Novembro' },
    { short: 'Dez', long: 'Dezembro' }
  ];

  constructor(
    private cdr: ChangeDetectorRef
  ) { }

  ngOnInit() {
  }


  private onChange: (value: number) => void = () => {};
  private onTouched: () => void = () => {};

  getMonthName(): string {
    const month = this.months[this.competencia];
    return month ? month[this.monthFormat] : '';
  }

  writeValue(value: number): void {
    this.competencia = value;
    this.cdr.detectChanges();
  }

  registerOnChange(fn: (value: number) => void): void {
    this.onChange = fn;
  }

  registerOnTouched(fn: () => void): void {
    this.onTouched = fn;
  }

  setDisabledState?(isDisabled: boolean): void {
    // Implement if needed
  }

  // Call this method when the value changes
  updateCompetencia(newIndex: number): void {
    this.competencia = +(newIndex ?? 0); // Converte o valor para número
    this.onChange(this.competencia);
    this.onTouched();
    this.cdr.detectChanges();
  }

}
