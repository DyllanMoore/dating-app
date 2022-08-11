import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from "@angular/forms";
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  postId: any;
  errorMessage: any;

  constructor(private http:HttpClient) { }

  ngOnInit() {
    this.http.post<any>('localhost:4444/data/users/login/', {title: 'User Login'}).subscribe({
      next: data => {
        this.postId = data.Id;
      },
      error: error => {
        this.errorMessage = error.message;
        console.error('Incorrect login!', error);
      }
    })
  }
  

}
