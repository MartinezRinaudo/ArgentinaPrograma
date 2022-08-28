import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SecurityService } from 'src/app/Services/security/security.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  log : string
  username : string;
  constructor(private security : SecurityService, private router : Router) {
    this.log = "Login";
    this.username = "";
   }

  ngOnInit(): void {
  }

  LogStatus() {
    if(this.security.getToken()) {
      this.log = "Logout";
      this.username = "User: " + this.security.getUsername();
    } 
  }

  SignIn() {
    if(this.security.getToken()) {
      this.security.removeToken();
      this.router.navigateByUrl("/login");
    } else {

    }
  }
}
