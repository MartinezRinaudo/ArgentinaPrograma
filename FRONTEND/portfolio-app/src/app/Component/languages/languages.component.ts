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
  id: number;

  constructor(private dataPortfolio:PortfolioService, private edition:EditionService) {
    this.btnEdition = this.edition.btnsEdition;
    this.btnAdd = this.edition.btnsAdd;
    this.id = 0;
  }

  ngOnInit(): void {
    this.dataPortfolio.getData(1).subscribe(data => {
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

    let id = this.id;
    let name = (<HTMLInputElement>document.getElementById("name-language")).value;
    let level = (<HTMLInputElement>document.getElementById("level-language")).value;
    let newLanguage = {
      languages: [
        {
          "id": id,
          "name":name, 
          "level":level  
        }
      ]    
    }

    let language = JSON.stringify(newLanguage);
    
    this.dataPortfolio.editElement(1, "language", language)
      .subscribe((response) => {
        this.languagesData = response.languages
      });  
      this.btnAdd = false;
      this.id = 0;
  }

  editItem(event:any){
    this.addItem(); 
    this.id = event.target.id;

    
    console.log(this.id)
    console.log(this.languagesData)
    setTimeout(() => {    
      let name = (<HTMLInputElement>document.getElementById("name-language"));
      let level = (<HTMLInputElement>document.getElementById("level-language"));
      for (let i = 0; i < this.languagesData.length; i++) {
        if(this.languagesData[i].id == this.id){
          name.value = (this.languagesData[i]).name;
          level.value = (this.languagesData[i]).level;
        }
      }
    }, 100);
   }
}
