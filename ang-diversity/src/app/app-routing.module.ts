import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { AllPeopleComponent } from './all-people/all-people.component';
import { HomeComponent } from './home/home.component';
import { AllTermsComponent } from './all-terms/all-terms.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path:'home', component: HomeComponent},
  { path: 'allPeople', component: AllPeopleComponent },
  { path: 'allTerms', component: AllTermsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
