import { Component, OnInit } from '@angular/core';
import { UserCurrencyRequest } from '../model/user-currency-request';
import { CurrencyService } from '../service/currency.service';
import { ErrorResponse } from '../model/error-response';

@Component({
  selector: 'app-currency-page',
  templateUrl: './currency-page.component.html',
  styleUrls: ['./currency-page.component.css']
})
export class CurrencyPageComponent implements OnInit {

    requests: UserCurrencyRequest[];
    error: ErrorResponse;

    constructor(private currencyService: CurrencyService) {
      this.error = new ErrorResponse('');
    }

    ngOnInit() {
      this.error = new ErrorResponse('');

      this.currencyService.findAll().subscribe(data => {
        this.requests = data;
      });

      this.error = this.currencyService.getError();
    }
}
