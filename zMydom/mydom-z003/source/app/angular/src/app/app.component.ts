import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CompetenciaUpDownComponent } from './shared/components/competencia-up-down/competencia-up-down.component';


@Component({
  standalone: true,
  imports: [CommonModule, RouterOutlet, CompetenciaUpDownComponent],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent 
        implements OnInit {
  
  title = 'mydom';
  form: FormGroup;  

  constructor(
    private fb: FormBuilder,
    private cdr: ChangeDetectorRef
  ) {

    this.form = this.fb.group({
      competencia: ['', []]
    });
    
  }  

  ngOnInit(): void {
    const hoje = new Date();
    this.form.controls['competencia'].value(hoje.getMonth());    
    this.cdr.detectChanges();
  }

}
