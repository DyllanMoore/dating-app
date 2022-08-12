import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { ProfileComponent } from './components/profile/profile.component';
import { SignupComponent } from './components/signup/signup.component';
import { Q1 } from './components/q1/q1.component';
import { Q2 } from './components/q2/q2.components';
import { Q3 } from './components/q3/q3.component';
import { MingleComponent } from './components/mingle/mingle.component';
import { MatchesComponent } from './components/matches/matches.component';
import { UpdateComponent } from './components/update/update.component';
const routes: Routes = [

  {
    path:'',
    component: HomeComponent
  },

  {
    path: 'login',
    component: LoginComponent
  },

  {
    path: 'signup',
    component: SignupComponent
  },

  {
    path: 'profile',
    component: ProfileComponent
  },

  {
    path: 'question1',
    component: Q1
  },

  {
    path: 'question2',
    component: Q2
  },
  
  {
    path: 'question3',
    component: Q3
  },

  {
    path: 'mingle',
    component: MingleComponent
  },

  {
    path: 'matches',
    component: MatchesComponent
  },

  {
    path: 'update',
    component: UpdateComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
