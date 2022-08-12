import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
@Component({
  selector: 'app-q3',
  templateUrl: './q3.component.html',
  styleUrls: ['./q3.component.css']
})
export class Q3 implements OnInit {
  form: any = {
    question_3_id: null,
  };
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  constructor(private authService: AuthService) { }
  ngOnInit(): void {
  }
  onSubmit(): void {
    const { question_3_id} = this.form;
    this.authService.q2(question_3_id).subscribe(
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