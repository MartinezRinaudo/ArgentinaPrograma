import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SecurityService } from '../security/security.service';
 
@Injectable({
  providedIn: 'root'
})
export class PortfolioService {
  url:string;
  headers:any;
  token:string = <string>this.security.getToken();

  constructor(private http:HttpClient, private security:SecurityService) { 
    this.url = 'http://localhost:8080/profile/';  
    this.headers = new HttpHeaders({ 'Content-Type': 'application/json','Authorization':this.token});
  }
  
  getData(id:number):Observable<any> {
    return this.http.get(this.url + id);
  }
  editElement(id:number, element:string, updatedElement:any):Observable<any> {
    let fullUrl = this.url + id + "/" + element; 
    console.log(updatedElement)
    console.log(this.headers)
    const options = {headers:this.headers}; 
    return this.http.patch<any>(fullUrl, updatedElement,options);
  }
  
}
