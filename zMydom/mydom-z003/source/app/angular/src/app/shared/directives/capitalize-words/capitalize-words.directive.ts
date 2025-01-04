import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[appCapitalizeWords]',
  standalone: true
})
export class CapitalizeWordsDirective {

/* exemples
  <input type="text" appCapitalizeWords placeholder="Digite algo aqui...">
*/


  constructor(private el: ElementRef) { }

  @HostListener('input', ['$event']) onInputChange(event: any) {
    //const value = this.el.nativeElement.value;
    //this.el.nativeElement.value = value.replace(/\b\w/g, (first: string) => first.toLocaleUpperCase());

    const initialValue = this.el.nativeElement.value;
    this.el.nativeElement.value = this.capitalizeWords(initialValue);
    if (initialValue !== this.el.nativeElement.value) {
      event.stopPropagation();
    }

  }  

  capitalizeWords(value: string): string {
    return value.replace(/\b\w/g, (char) => char.toUpperCase());
  }

}
