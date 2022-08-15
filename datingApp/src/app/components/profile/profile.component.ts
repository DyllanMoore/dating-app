import { registerLocaleData } from '@angular/common';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { map, Subscription } from 'rxjs';
import { AuthService } from 'src/app/services/auth.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { UserService } from 'src/app/services/users.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  currentUser: any;

  constructor(private authService: AuthService, private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.retrieveUser();
  }
  
  retrieveUser(): void {
    this.currentUser = this.tokenStorageService.getUser();
    this.authService.getUser(this.currentUser.username).subscribe(
      data => {
        this.currentUser = data;
        console.log(data);
      },
      error => {
        console.log(error);
      }
    )
  }

  redirect() {
        window.location.href = "http://localhost:4200/profile/" + this.currentUser.user_id;
  }

}
