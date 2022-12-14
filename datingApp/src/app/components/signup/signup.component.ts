import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  form: any = {
    username: null,
    password: null,
    first_name: null,
    city: null,
    state: null,
    country: null,
    date_of_birth: null,
    question_1_id: null,
    question_2_id: null,
    question_3_id: null
  };
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  constructor(private authService: AuthService) { }
  ngOnInit(): void {
  }
  onSubmit(): void {
    const { username, password, first_name, city, state, country, date_of_birth, question_1_id, question_2_id, question_3_id } = this.form;
    this.authService.signup(username, password, first_name, city, state, country, date_of_birth, question_1_id, question_2_id, question_3_id).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        this.reloadPage();
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }
  reloadPage(): void {
    window.location.href = "http://localhost:4200/login";
  }
}