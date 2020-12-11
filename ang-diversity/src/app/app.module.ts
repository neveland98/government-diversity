import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AllPeopleComponent } from './all-people/all-people.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './home/home.component';
import { AllTermsComponent } from './all-terms/all-terms.component';

@NgModule({
  declarations: [
    AppComponent,
    AllPeopleComponent,
    HomeComponent,
    AllTermsComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
