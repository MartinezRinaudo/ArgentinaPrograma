import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }

  loginUser(user:any):Observable<any> {
    return this.http.post<any>('http://localhost:8080/auth/login', user);
  }
  
  registerUser(user:any):Observable<any> {
    return this.http.post<any>('http://localhost:8080/auth/signup', user);
  }
}
