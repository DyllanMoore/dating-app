import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TokenStorageService } from './token-storage.service';

const AUTH_API = 'http://localhost:4444/data/users';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient, private tokenStorageService: TokenStorageService) { }
  currentUser = this.tokenStorageService.getUser();
  login(username: string, password: string): Observable<any> {
    return this.http.post(AUTH_API + '/login', {
      username,
      password
    }, httpOptions);
  }
  signup(username: string, password: string, first_name: string, city: string, state: string, country: string, date_of_birth: Date, question1Id: Number, question2Id: Number, question3Id: Number): Observable<any> {
    return this.http.post(AUTH_API, {
      username,
      password,
      first_name,
      city,
      state,
      country,
      date_of_birth, 
      question1Id,
      question2Id,
      question3Id
    }, httpOptions);
  }

  update(username: string, password: string, first_name: string, city: string, state: string, country: string, date_of_birth: Date): Observable<any> {
    return this.http.put(AUTH_API, {
      username,
      password,
      first_name,
      city,
      state,
      country,
      date_of_birth
    });
  }

  getUser(username: String): Observable<any> {
    return this.http.get(AUTH_API + "/" + username)
  }
} 