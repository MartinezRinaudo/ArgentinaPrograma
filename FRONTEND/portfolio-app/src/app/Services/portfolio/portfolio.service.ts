import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
 
@Injectable({
  providedIn: 'root'
})
export class PortfolioService {
  url:string;

  constructor(private http:HttpClient) { 
    this.url = 'http://localhost:8080/profile/';  
  }

  getData(id:number):Observable<any> {
    return this.http.get(this.url + id);
  }

  
}
