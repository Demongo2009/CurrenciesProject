import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { CurrencyRequest } from '../model/currency-request';
import { RateValue } from '../model/rate-value';
import { UserCurrencyRequest } from '../model/user-currency-request';
import { Observable, catchError } from 'rxjs';
import { ErrorResponse } from '../model/error-response';

@Injectable({
  providedIn: 'root'
})
export class CurrencyService {

  private getRequestsUrl: string;
  private postRequestUrl: string;
  error: ErrorResponse;

  constructor(private http: HttpClient) {
    this.getRequestsUrl = 'http://localhost:8080/api/currencies/requests';
    this.postRequestUrl = 'http://localhost:8080/api/currencies/get-current-currency-value-command';
    this.error = new ErrorResponse('');
  }

  public findAll(): Observable<UserCurrencyRequest[]> {
    return this.http.get<UserCurrencyRequest[]>(this.getRequestsUrl)
      .pipe(
        catchError((error: HttpErrorResponse) => {
          this.error = error.error;
          return new Observable<UserCurrencyRequest[]>;
        }));
  }

  public postRequest(currencyRequest: CurrencyRequest) {
    return this.http.post<RateValue>(this.postRequestUrl, currencyRequest,
      {headers : new HttpHeaders({ 'Content-Type': 'application/json' })})
      .pipe(
        catchError((error: HttpErrorResponse) => {
          this.error = error.error;
          return new Observable<RateValue>;
        }));
  }

  public getError() {
    return this.error;
  }

}
