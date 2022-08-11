import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
const AUTH_API = 'http://localhost:4444/data/users/';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) { }
  login(username: string, password: string): Observable<any> {
    return this.http.post(AUTH_API + 'login', {
      username,
      password
    }, httpOptions);
  }
  signup(username: string, password: string, first_name: string, city: string, state: string, country: string, date_of_birth: Date): Observable<any> {
    return this.http.post(AUTH_API + 'signup', {
      username,
      password,
      first_name,
      city,
      state,
      country,
      date_of_birth
    }, httpOptions);
  }
}