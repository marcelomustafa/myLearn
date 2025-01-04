import { Component, OnInit } from '@angular/core';
import { CalendarEvent, CalendarMonthViewComponent } from 'angular-calendar';
import { addDays, startOfMonth, endOfMonth } from 'date-fns';

@Component({
  standalone: true,
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.css'],
  imports: [CalendarMonthViewComponent]
})
export class CalendarComponent implements OnInit {

  viewDate: Date = new Date();
  events: CalendarEvent[] = [];

  ngOnInit() {
    this.generateEvents();
  }

  generateEvents() {
    const start = startOfMonth(this.viewDate);
    const end = endOfMonth(this.viewDate);
    this.events = [];

    for (let date = start; date <= end; date = addDays(date, 1)) {
      this.events.push({
        start: date,
        title: this.getRandomStatus(),
        color: this.getStatusColor(this.getRandomStatus())
      });
    }
  }

  getRandomStatus(): string {
    const statuses = ['Disponível', 'Agendado', 'Realizado'];
    return statuses[Math.floor(Math.random() * statuses.length)];
  }

  getStatusColor(status: string) {
    switch (status) {
      case 'Disponível':
        return { primary: 'green', secondary: 'lightgreen' };
      case 'Agendado':
        return { primary: 'red', secondary: 'lightcoral' };
      case 'Realizado':
        return { primary: 'blue', secondary: 'lightblue' };
      default:
        return { primary: 'gray', secondary: 'lightgray' };
    }
  }

  dayClicked(day: any) {
    alert('Data clicada: ' + day.date);
  }

  dayModifier(day: any) {
    const event = this.events.find(e => e.start.getTime() === day.date.getTime());
    if (event) {
      day.cssClass = event.color.primary;
    }
  }

}
