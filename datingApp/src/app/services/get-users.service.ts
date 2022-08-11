import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class GetUsersService {

  constructor(private http:HttpClient) { }

  //Function to get users by username
  getUsersByUsername(username:User):Observable<HttpResponse<User>>{
    return this.http.get("localhost:4444/data/users/" + username + "/", {observe: "response"}) as Observable<HttpResponse<User>>;
  }
}
