import { Component, OnInit } from '@angular/core';
import { EditionService } from 'src/app/Services/edition/edition.service';
import { PortfolioService } from 'src/app/Services/portfolio/portfolio.service';

@Component({
  selector: 'app-languages',
  templateUrl: './languages.component.html',
  styleUrls: ['./languages.component.css']
})
export class LanguagesComponent implements OnInit {
  languagesData : any;
  btnEdition : boolean;

  constructor(private dataPortfolio:PortfolioService, private edition:EditionService) {
    this.btnEdition = this.edition.btnsEdition;
  }

  ngOnInit(): void {
    this.dataPortfolio.getData().subscribe(data => {
      this.languagesData = data.languages;
    });
    this.btnEdition = this.edition.showBtnsEdition();
  }

}
