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
  id: number;


  constructor(private dataPortfolio:PortfolioService, private edition:EditionService) { 
    this.btnEdition = this.edition.btnsEdition;
    this.btnAdd = this.edition.btnsAdd;
    this.id = 0;
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
    let id = this.id;
    let name = (<HTMLInputElement>document.getElementById("name-education")).value;
    let place = (<HTMLInputElement>document.getElementById("place-education")).value;
    let startDate = (<HTMLInputElement>document.getElementById("start-date-education")).value;
    let endDate = (<HTMLInputElement>document.getElementById("end-date-education")).value;
    
    let newEdu = {
      education: [
        {
          "id":id,
          "name":name, 
          "place":place, 
          "startDate":startDate,
          "endDate":endDate,
        }
      ]  
    }

    let edu = JSON.stringify(newEdu);
    
    this.dataPortfolio.editElement(1, "education", edu)
      .subscribe((response) => {
        this.education = response.education
      });  
      this.btnAdd = false;
      this.id = 0;
  }

  editItem(event:any){
    this.addItem(); 
    this.id = event.target.id;
    
    setTimeout(() => {    
      let name = (<HTMLInputElement>document.getElementById("name-education"));
      let place = (<HTMLInputElement>document.getElementById("place-education"));
      let startDate = (<HTMLInputElement>document.getElementById("start-date-education"));
      let endDate = (<HTMLInputElement>document.getElementById("end-date-education")); 
      
     for (let i = 0; i < this.education.length; i++) {
      if(this.education[i].id == this.id){
        name.value = (this.education[i]).name;
        place.value = (this.education[i]).place;
        startDate.value = (this.education[i]).startDate;
        endDate.value = (this.education[i]).endDate;
      }
     }
    }, 100);
   } 
}
