import { Component, OnInit } from '@angular/core';
import { EditionService } from 'src/app/Services/edition/edition.service';
import { PortfolioService } from 'src/app/Services/portfolio/portfolio.service';

@Component({
  selector: 'app-experience',
  templateUrl: './experience.component.html',
  styleUrls: ['./experience.component.css']
})
export class ExperienceComponent implements OnInit {

  experienceData:any;
  btnEdition : boolean;
  btnAdd : boolean;


  constructor(private dataPortfolio:PortfolioService, private edition : EditionService) { 
    this.btnEdition = this.edition.btnsEdition;
    this.btnAdd = this.edition.btnsAdd;
  }

  ngOnInit(): void {
    this.dataPortfolio.getData(1).subscribe(data => {
      this.experienceData = data.experience;
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
    let job = (<HTMLInputElement>document.getElementById("job-experience")).value;
    let place = (<HTMLInputElement>document.getElementById("place-experience")).value;
    let startDate = (<HTMLInputElement>document.getElementById("start-date-experience")).value;
    let endDate = (<HTMLInputElement>document.getElementById("end-date-experience")).value;
    let jobType = (<HTMLInputElement>document.getElementById("job-type-experience")).value;
    let skills = (<HTMLInputElement>document.getElementById("skills-experience")).value;
    
    let newJob = {
      "job":job, 
      "place":place, 
      "start":startDate,
      "end":endDate,
      "type":jobType,
      "skills":skills
    }
    this.experienceData.unshift(newJob);
    this.btnAdd = false;
  }


}
