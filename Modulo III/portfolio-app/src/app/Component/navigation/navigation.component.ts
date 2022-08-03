import { Component, OnInit } from '@angular/core';
import { SecurityService } from 'src/app/Services/security/security.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  log : String = "Login" 

  constructor(private security : SecurityService) { }

  ngOnInit(): void {
  }
  LogUser() {
    console.log(this.security.getToken())
    if(this.security.getToken()) {
      this.log = "Logout";
    } 
  }
}
