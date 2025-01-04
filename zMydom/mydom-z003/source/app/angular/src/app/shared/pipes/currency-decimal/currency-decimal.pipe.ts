import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'currencyDecimal',
  standalone: true
})
export class CurrencyDecimalPipe implements PipeTransform {
/* exemples
  <p>{{ price | currency: 'USD' | number: '1.2-2' }}</p>
  <p>{{ price | number: '1.2-2' }}</p>

*/


  transform(value: number, currencyCode: string): string {
    // Formata o valor como moeda
    let formattedValue = new Intl.NumberFormat('en-US', { style: 'currency', currency: currencyCode }).format(value);

    // Limita o número de casas decimais
    const decimalSeparator = formattedValue.indexOf('.') !== -1 ? '.' : ',';
    const decimalPart = formattedValue.split(decimalSeparator)[1];
    const decimalDigits = decimalPart ? decimalPart.length : 0;
    const maxDecimalDigits = 2; // Máximo de duas casas decimais
    if (decimalDigits > maxDecimalDigits) {
      formattedValue = formattedValue.slice(0, formattedValue.length - (decimalDigits - maxDecimalDigits));
    }

    return formattedValue;
  }

  /*
  transform(value: number, currencyCode: string): string {
    // Verifica se o valor é válido
    if (isNaN(value) || value === null) {
      return '';
    }

    // Formata o valor como moeda
    const formattedValue = new Intl.NumberFormat('en-US', {
      style: 'currency',
      currency: currencyCode,
      minimumFractionDigits: 0,
      maximumFractionDigits: 2
    }).format(value);

    return formattedValue;
  }
*/
}
