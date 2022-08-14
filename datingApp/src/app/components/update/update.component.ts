import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  
  constructor(
    private authService: AuthService,
    private tokenStorageService: TokenStorageService
  ) { }

  currentUser = this.tokenStorageService.getUser();

  form: any = {
    username: this.currentUser.username,
    password: this.currentUser.password,
    first_name: this.currentUser.first_name,
    city: this.currentUser.city,
    state: this.currentUser.state,
    country: this.currentUser.country,
    date_of_birth: this.currentUser.date_of_birth
  };
  errorMessage='';
  
  ngOnInit(): void {
  }

  updateUser(): void {
    const { username, password, first_name, city, state, country, date_of_birth} = this.form;
    this.authService.update(username, password, first_name, city, state, country, date_of_birth).subscribe(
      data => {
        console.log(data);
        this.reloadPage();
      },
      err => {
        this.errorMessage = err.error.message;

      }
    );
  }
  reloadPage(): void {
    console.log(this.form)
    window.location.href = "http://localhost:4200/profile";
  }
}