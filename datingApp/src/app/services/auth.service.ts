import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
const AUTH_API = 'http://localhost:4444/data/users';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) { }
  login(username: string, password: string): Observable<any> {
    return this.http.post(AUTH_API + '/login', {
      username,
      password
    }, httpOptions);
  }
  signup(username: string, password: string, first_name: string, city: string, state: string, country: string, date_of_birth: Date): Observable<any> {
    return this.http.post(AUTH_API, {
      username,
      password,
      first_name,
      city,
      state,
      country,
      date_of_birth, 
      question_1_fk: 1,
      question_2_fk: 1,
      question_3_fk: 1
    }, httpOptions);
  }

  setup(question_1_fk: Number, question_2_fk: Number, question_3_fk: Number, image: string ): Observable<any> {
    return this.http.post(AUTH_API, { 
      question_1_fk,
      question_2_fk,
      question_3_fk,
      image
    }, httpOptions);
  }
  
}