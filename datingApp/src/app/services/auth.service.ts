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

  q1(question_1_id: Number): Observable<any> {
    return this.http.post(AUTH_API + '/question1', { 
      question_1_id
    }, httpOptions);
  }

  q2(question_2_id: Number): Observable<any> {
    return this.http.post(AUTH_API + '/question2', { 
      question_2_id
    }, httpOptions);
  }

  q3(question_3_id: Number): Observable<any> {
    return this.http.post(AUTH_API + '/question3', { 
      question_3_id
    }, httpOptions);
  }

} 