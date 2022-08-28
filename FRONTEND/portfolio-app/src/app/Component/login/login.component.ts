import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/Services/login/login.service';
import { Router } from '@angular/router';
import { SecurityService } from 'src/app/Services/security/security.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  email:string = "";
  password:string = "";

  constructor(private loginService : LoginService, private router : Router, public security : SecurityService) { 
  }

  ngOnInit(): void {
   
  }
  SignIn() {
    const user = {email:this.email, password:this.password};
    this.loginService.loginUser(user).subscribe(data => {
      this.security.setToken(data.token);
      this.security.setUsername(this.email);
      this.router.navigateByUrl("/portfolio");
    })
  }
}
