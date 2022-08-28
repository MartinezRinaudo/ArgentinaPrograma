import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }
  /* Falta api backend propia */

  /*
    USERNAME: george.bluth@reqres.in 
    PASSWORD: anything
  */
 
  loginUser(user:any):Observable<any> {
    return this.http.post<any>('https://reqres.in/api/login', user);
  }

  
  registerUser(user:any):Observable<any> {
    return this.http.post<any>('https://reqres.in/api/register', user);
  }
}
