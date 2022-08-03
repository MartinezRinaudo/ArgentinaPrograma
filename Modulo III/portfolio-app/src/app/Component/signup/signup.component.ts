import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/Services/login/login.service';
import { Router } from '@angular/router';
import { SecurityService } from 'src/app/Services/security/security.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  email:String = "";
  password:String = "";

  constructor(private loginService:LoginService, private router : Router, private security : SecurityService) {}

  ngOnInit(): void {
  }
  RegisterUser() {
    const user = {email:this.email, password:this.password};
    this.loginService.registerUser(user).subscribe(data => {
      this.security.setToken(data.token);
      this.router.navigateByUrl("/portfolio");
    });
  }
}
