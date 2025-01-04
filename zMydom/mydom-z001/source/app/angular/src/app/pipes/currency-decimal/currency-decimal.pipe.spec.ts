import { CurrencyDecimalPipe } from './currency-decimal.pipe';

describe('CurrencyDecimalPipe', () => {
  it('create an instance', () => {
    const pipe = new CurrencyDecimalPipe();
    expect(pipe).toBeTruthy();
  });
});
