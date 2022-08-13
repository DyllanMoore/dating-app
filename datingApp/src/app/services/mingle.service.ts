import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
  
@Injectable({
  providedIn: 'root'
})
export class PostService {
  private url = 'http://localhost:4444/data/oklahoma';
   
  constructor(private httpClient: HttpClient) { }
  
  getUsers(){
    return this.httpClient.get(this.url);
  }
}