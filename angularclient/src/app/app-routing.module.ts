import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CurrencyPageComponent } from './currency-page/currency-page.component';
import { CurrencyRequestFormComponent } from './currency-request-form/currency-request-form.component';

const routes: Routes = [
  { path: 'currencies/requests', component: CurrencyPageComponent },
  { path: 'currencies/createRequest', component: CurrencyRequestFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
