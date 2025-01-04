import { Component, OnInit, Input } from '@angular/core';
import { CalendarSchedulerEvent, CalendarSchedulerViewComponent } from 'angular-calendar-scheduler';
import { addMinutes, startOfDay, endOfDay } from 'date-fns';

@Component({
  standalone: true,
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css'],
  imports: [CalendarSchedulerViewComponent]
})
export class ScheduleComponent implements OnInit {

  @Input() interval: number = 30;
  @Input() unavailableTimes: { start: string, end: string }[] = [];
  view: string = 'day';
  viewDate: Date = new Date();
  events: CalendarSchedulerEvent[] = [];
  hourSegments: number = 2;
  dayStartHour: number = 0;
  dayEndHour: number = 24;

  ngOnInit() {
    this.generateTimeSlots();
  }

  generateTimeSlots() {
    const start = startOfDay(this.viewDate);
    const end = endOfDay(this.viewDate);

    for (let time = start; time <= end; time = addMinutes(time, this.interval)) {
      const timeString = time.toTimeString().substring(0, 5);
      if (!this.isUnavailable(timeString)) {
        this.events.push({
          start: time,
          end: addMinutes(time, this.interval),
          title: 'Nome',
          color: this.getStatusColor(this.getRandomStatus()),
          meta: {
            document: 'Documento',
            status: this.getRandomStatus()
          }
        });
      }
    }
  }

  isUnavailable(time: string): boolean {
    return this.unavailableTimes.some(interval => time >= interval.start && time <= interval.end);
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

  eventClicked(event: CalendarSchedulerEvent) {
    alert('Evento clicado: ' + event.title);
  }

}
