import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
// import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './pages/login/login.component';
// import { ProfileComponent } from './components/profile/profile.component';
// import { SignupComponent } from './components/signup/signup.component';
// import { MingleComponent } from './components/mingle/mingle.component';
// import { MatchesComponent } from './components/matches/matches.component';
// import { UpdateComponent } from './components/update/update.component';
const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },

  {
    path: 'login',
    component: LoginComponent,
  },

  {
    path: 'signup',
    component: SignupComponent,
  },

  {
    path: 'profile',
    component: ProfileComponent,
  },

  {
    path: 'mingle',
    component: MingleComponent,
  },

  {
    path: 'matches',
    component: MatchesComponent,
  },

  {
    path: 'update',
    component: UpdateComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
