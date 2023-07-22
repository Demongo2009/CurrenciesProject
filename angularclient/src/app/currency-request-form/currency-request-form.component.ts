import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CurrencyService } from '../service/currency.service';
import { CurrencyRequest } from '../model/currency-request';
import { ErrorResponse } from '../model/error-response';
import { RateValue } from '../model/rate-value';

@Component({
  selector: 'app-currency-request-form',
  templateUrl: './currency-request-form.component.html',
  styleUrls: ['./currency-request-form.component.css']
})
export class CurrencyRequestFormComponent {

  request: CurrencyRequest;
  error: ErrorResponse;
  result: RateValue;

  constructor(
    private route: ActivatedRoute,
      private router: Router,
        private currencyService: CurrencyService) {
    this.request = new CurrencyRequest();
    this.error = new ErrorResponse('');
    this.result = new RateValue;
  }

  onSubmit() {
    this.error = new ErrorResponse('');

    this.currencyService.postRequest(this.request)
    .subscribe(
      (result) => {
        this.result = result;
      });

    this.error = this.currencyService.getError();
  }

}
