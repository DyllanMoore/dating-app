import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { map, Subscription } from 'rxjs';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { UserService } from 'src/app/services/users.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  currentUser: any;

  constructor(private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.currentUser = this.tokenStorageService.getUser();
  }

  redirect() {
        window.location.href = "http://localhost:4200/profile/" + this.currentUser.user_id;
  }

}
