import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { CurrencyPageComponent } from './currency-page/currency-page.component';
import { CurrencyRequestFormComponent } from './currency-request-form/currency-request-form.component';
import { CurrencyService } from './service/currency.service';

@NgModule({
  declarations: [
    AppComponent,
    CurrencyPageComponent,
    CurrencyRequestFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [CurrencyService],
  bootstrap: [AppComponent]
})
export class AppModule { }
