import { Component, OnInit } from '@angular/core';
import { EditionService } from 'src/app/Services/edition/edition.service';
import { PortfolioService } from 'src/app/Services/portfolio/portfolio.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  myPortfolio : any;
  contactInfoView : Boolean;
  btnEdition : boolean;
  btnAdd : boolean;
  imageContact:string;

  constructor(private dataPortfolio:PortfolioService, private edition:EditionService) {
    this.contactInfoView = false;
    this.btnEdition = this.edition.btnsEdition;
    this.btnAdd = this.edition.btnsAdd;
    this.imageContact = "";
   }

  ngOnInit(): void {
    this.dataPortfolio.getData().subscribe(data => {
      this.myPortfolio = data;
    });
    this.btnEdition = this.edition.showBtnsEdition();
  }

  Onclick() {
    if(this.contactInfoView === false) {
      this.contactInfoView = true;
    } else {
      this.contactInfoView = false;
    } 
  }


  addItem() {
    if(this.btnAdd == false) {
      this.btnAdd = true;
    } else {
      this.btnAdd = false;
    }    
  }
  openFile(element:any) {
    this.imageContact = element.target.files[0].name;
   }

  saveChanges() {
    /*SIN CONEXION CON EL BACKEND*/
    let name = (<HTMLInputElement>document.getElementById("name-contact")).value;
    let link = (<HTMLInputElement>document.getElementById("link-contact")).value;
    let imageInput = "./assets/images/" + this.imageContact;

    console.log(imageInput)
    
    let newContact = {
      "name":name, 
      "link":link,
      "alt":name,
      "image":imageInput
    }
    this.myPortfolio.contactInformation.unshift(newContact);
    this.btnAdd = false;
  }
   
 
 
  

}
