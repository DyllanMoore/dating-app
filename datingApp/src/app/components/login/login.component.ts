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

  public loginForm !: FormGroup
  constructor(private formBuilder: FormBuilder, private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      username:[""],
      password:[""]
    })
  }

  login() {
    this.http.get<any>("path")
    .subscribe(res=>{
      const user = res.find((a:any) =>{
        return a.username === this.loginForm.value.username && a.password === this.loginForm.value.password
      });
      if (user) {
        alert("Login succeed");
        this.loginForm.reset();
        this.router.navigate(['home'])
      } else {
        alert('user not found!!')
      }
    }, err=>{
      alert("Something went wrong")
    })
  }

}
