import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'capitalizeWords',
  standalone: true
})
export class CapitalizeWordsPipe implements PipeTransform {

/* exemples
  <p>{{ 'este é um exemplo de texto' | capitalizeWords }}</p>
*/  


  transform(value: string): string {
    if (!value) return value;
    return value.replace(/\b\w/g, (char) => char.toUpperCase());

    // return value.replace(/\w\S*/g, (txt) => {
    //   return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();
    // });

  }

}
