import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
@Component({
  selector: 'app-q1',
  templateUrl: './q1.component.html',
  styleUrls: ['./q1.component.css']
})
export class Q1 implements OnInit {
  form: any = {
    question_1_id: null,
  };
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  constructor(private authService: AuthService) { }
  ngOnInit(): void {
  }
  onSubmit(): void {
    const { question_1_id} = this.form;
    this.authService.q1(question_1_id).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }
}