import { Component, OnInit } from '@angular/core';
import { PortfolioService } from 'src/app/Services/portfolio/portfolio.service';

@Component({
  selector: 'app-aboutme',
  templateUrl: './aboutme.component.html',
  styleUrls: ['./aboutme.component.css']
})
export class AboutmeComponent implements OnInit {
  aboutme:any;

  constructor(private dataPortfolio:PortfolioService) { }

  ngOnInit(): void {
    this.dataPortfolio.getData().subscribe(data => {
      this.aboutme = data.aboutme;
    });
  }

}
