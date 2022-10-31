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
  id: number;


  constructor(private dataPortfolio:PortfolioService, private edition : EditionService) { 
    this.btnEdition = this.edition.btnsEdition;
    this.btnAdd = this.edition.btnsAdd;
    this.id = 0;
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
    let id = this.id;
    let job = (<HTMLInputElement>document.getElementById("job-experience")).value;
    let place = (<HTMLInputElement>document.getElementById("place-experience")).value;
    let startDate = (<HTMLInputElement>document.getElementById("start-date-experience")).value;
    let endDate = (<HTMLInputElement>document.getElementById("end-date-experience")).value;
    let jobType = (<HTMLInputElement>document.getElementById("job-type-experience")).value;
    let skills = (<HTMLInputElement>document.getElementById("skills-experience")).value;
    
    let newJob = {
      experience: [{
        "id": id,
        "job":job, 
        "place":place, 
        "startDate":startDate,
        "endDate":endDate,
        "typeOfJob":jobType,
        "skills":skills
      }] 
    }
  
    let experience = JSON.stringify(newJob);
    
    this.dataPortfolio.editElement(1, "experience", experience)
      .subscribe((response) => {
        this.experienceData = response.experience
      });  
      this.btnAdd = false;
      this.id = 0;
  }

  editItem(event:any){
    this.addItem(); 
    this.id = event.target.id;
    
    setTimeout(() => {    
      let job = (<HTMLInputElement>document.getElementById("job-experience"));
      let place = (<HTMLInputElement>document.getElementById("place-experience"));
      let startDate = (<HTMLInputElement>document.getElementById("start-date-experience"));
      let endDate = (<HTMLInputElement>document.getElementById("end-date-experience"));
      let jobType = (<HTMLInputElement>document.getElementById("job-type-experience"));
      let skills = (<HTMLInputElement>document.getElementById("skills-experience"));
      
     for (let i = 0; i < this.experienceData.length; i++) {
      if(this.experienceData[i].id == this.id){
        job.value = (this.experienceData[i]).job;
        place.value = (this.experienceData[i]).place;
        startDate.value = (this.experienceData[i]).startDate;
        endDate.value = (this.experienceData[i]).endDate;
        jobType.value = (this.experienceData[i]).typeOfJob;
        skills.value = (this.experienceData[i]).skills;
      }
     }
    }, 100);
   } 

}
