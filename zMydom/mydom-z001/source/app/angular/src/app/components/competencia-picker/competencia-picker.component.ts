import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-competencia-picker',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './competencia-picker.component.html',
  styleUrl: './competencia-picker.component.scss'
})
export class CompetenciaPickerComponent {

  selectedMonth: number = new Date().getMonth(); // Valor numérico do mês
  selectedYear: number = new Date().getFullYear();
  months: string[] = [
    'Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho',
    'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'
  ];
  isMonthPickerOpen: boolean = false;

  openMonthPicker() {
    // Implemente a lógica para abrir a lista de seleção de mês
    this.isMonthPickerOpen = true;
  }

  closeMonthPicker() {
    this.isMonthPickerOpen = false;
  }

  selectMonth(index: number) {
    this.selectedMonth = index;
    this.closeMonthPicker();
  }

  onYearInput() {
    // Implemente a lógica para limitar o ano a 4 dígitos
    if (this.selectedYear.toString().length > 4) {
      this.selectedYear = parseInt(this.selectedYear.toString().slice(0, 4));
    }    
  }

  decreaseMonth() {
    // Implemente a lógica para retroceder o mês
    const newDate = new Date(this.selectedYear, this.selectedMonth - 1);
    this.selectedMonth = newDate.getMonth();
    this.selectedYear = newDate.getFullYear();    
  }

  increaseMonth() {
    // Implemente a lógica para avançar o mês
    const newDate = new Date(this.selectedYear, this.selectedMonth + 1);
    this.selectedMonth = newDate.getMonth();
    this.selectedYear = newDate.getFullYear();    
  }

  formatCompetencia(): string {
    return `${this.selectedMonth + 1}/${this.selectedYear}`;
  }  

  onKeyDown(event: KeyboardEvent, index: number) {
    if (event.key === 'Enter' || event.key === ' ') {
      this.selectMonth(index);
    }
  }

}  

