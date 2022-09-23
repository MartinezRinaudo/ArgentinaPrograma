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
  btnAdd : boolean;

  constructor(private dataPortfolio:PortfolioService, private edition:EditionService) {
    this.btnEdition = this.edition.btnsEdition;
    this.btnAdd = this.edition.btnsAdd;
  }

  ngOnInit(): void {
    this.dataPortfolio.getData().subscribe(data => {
      this.languagesData = data.languages;
    });
    this.btnEdition = this.edition.showBtnsEdition();
  }

  addItem() {
    if(this.btnAdd == false) {
      this.btnAdd = true;
    } else {
      this.btnAdd = false;
    }    
  }

  saveChanges() {
    /*SIN CONEXION CON EL BACKEND*/
    let name = (<HTMLInputElement>document.getElementById("name-language")).value;
    let level = (<HTMLInputElement>document.getElementById("level-language")).value;
    let newLanguage = {
      "name":name, 
      "level":level    
    }
    this.languagesData.unshift(newLanguage);
    this.btnAdd = false;
  }
}
