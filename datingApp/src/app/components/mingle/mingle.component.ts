import { Component, OnInit } from '@angular/core';
import { PostService } from 'src/app/services/mingle.service';
  
@Component({
  selector: 'app-mingle',
  templateUrl: './mingle.component.html',
  styleUrls: ['./mingle.component.css']
})
export class MingleComponent implements OnInit {
  users:any;
  
  constructor(private service:PostService) {}
  
  ngOnInit() {
      this.service.getUsers()
        .subscribe(response => {
          this.users = response;
        });
  }
}