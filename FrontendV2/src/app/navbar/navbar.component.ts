import { Component, OnInit } from '@angular/core';
// import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  isLoggedIn = false;
  username: string | undefined;

  // constructor(private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    // this.isLoggedIn = !!this.tokenStorageService.getToken();
    //   if (this.isLoggedIn) {
    //     const user = this.tokenStorageService.getUser();
    //     this.username = user.username;
    //   }
  }

  logout(): void {
    // this.tokenStorageService.signOut();
    // window.location.href="/";
  }
}
