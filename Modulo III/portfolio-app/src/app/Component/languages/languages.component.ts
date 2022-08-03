import { Component, OnInit } from '@angular/core';
import { PortfolioService } from 'src/app/Services/portfolio/portfolio.service';

@Component({
  selector: 'app-languages',
  templateUrl: './languages.component.html',
  styleUrls: ['./languages.component.css']
})
export class LanguagesComponent implements OnInit {
  languagesData:any;

  constructor(private dataPortfolio:PortfolioService) { }

  ngOnInit(): void {
    this.dataPortfolio.getData().subscribe(data => {
      this.languagesData = data.languages;
    })
  }

}
