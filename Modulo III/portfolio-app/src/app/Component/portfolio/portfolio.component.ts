import { Component, OnInit } from '@angular/core';
import { SecurityService } from 'src/app/Services/security/security.service';

@Component({
  selector: 'app-portfolio',
  templateUrl: './portfolio.component.html',
  styleUrls: ['./portfolio.component.css']
})
export class PortfolioComponent implements OnInit {

  constructor(private securityService : SecurityService) { }

  ngOnInit(): void {
    this.securityService.getToken();
  }

}
