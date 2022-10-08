import { Component, OnInit } from '@angular/core';
import { EditionService } from 'src/app/Services/edition/edition.service';
import { PortfolioService } from 'src/app/Services/portfolio/portfolio.service';

@Component({
  selector: 'app-education',
  templateUrl: './education.component.html',
  styleUrls: ['./education.component.css']
})
export class EducationComponent implements OnInit {

  education:any;
  btnEdition : boolean; 
  btnAdd : boolean;

  constructor(private dataPortfolio:PortfolioService, private edition:EditionService) { 
    this.btnEdition = this.edition.btnsEdition;
    this.btnAdd = this.edition.btnsAdd;
  }

  ngOnInit(): void {
    this.dataPortfolio.getData(1).subscribe(data => {
      this.education = data.education;
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
    let name = (<HTMLInputElement>document.getElementById("name-education")).value;
    let place = (<HTMLInputElement>document.getElementById("place-education")).value;
    let startDate = (<HTMLInputElement>document.getElementById("start-date-education")).value;
    let endDate = (<HTMLInputElement>document.getElementById("end-date-education")).value;
    
    let newEdu = {
      "name":name, 
      "place":place, 
      "start":startDate,
      "end":endDate,
    }
    this.education.unshift(newEdu);
    this.btnAdd = false;
  }

}
