import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SecurityService {

  constructor() { }

  public getToken() {
    return localStorage.getItem('token');
  }
  public setToken(jwt : string) {
    localStorage.setItem('token', jwt);
  }
  public removeToken() {
    localStorage.removeItem('token');
  }
}
