import { Component, OnInit } from '@angular/core';
import { EditionService } from 'src/app/Services/edition/edition.service';
import { PortfolioService } from 'src/app/Services/portfolio/portfolio.service';

@Component({
  selector: 'app-aboutme',
  templateUrl: './aboutme.component.html',
  styleUrls: ['./aboutme.component.css']
})
export class AboutmeComponent implements OnInit {
  aboutme:any;
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
      this.aboutme = data.aboutMe;
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
    let englishDesc = (<HTMLInputElement>document.getElementById("english-description-aboutme")).value;
    let spanishDesc = (<HTMLInputElement>document.getElementById("spanish-description-aboutme")).value;

    let newAboutMe = {
      aboutMe: {
          "id": id, 
          "englishDescription":englishDesc,
          "spanishDescription":spanishDesc
        }
    }

    let aboutMe = JSON.stringify(newAboutMe);
    
    this.dataPortfolio.editElement(1, "aboutme", aboutMe)
      .subscribe((response) => {
        this.aboutme = response.aboutMe;
      });  
      this.btnAdd = false;
      this.id = 0;
  }

  editItem(event:any){
    this.addItem(); 
    this.id = event.target.id;
    setTimeout(() => {    
      let englishDesc = (<HTMLInputElement>document.getElementById("english-description-aboutme"));
      let spanishDesc = (<HTMLInputElement>document.getElementById("spanish-description-aboutme"));
      englishDesc.value = (this.aboutme).englishDescription;
      spanishDesc.value = (this.aboutme).spanishDescription;
    }, 100);
   }

}
