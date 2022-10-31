import { Component, OnInit } from '@angular/core';
import { EditionService } from 'src/app/Services/edition/edition.service';
import { PortfolioService } from 'src/app/Services/portfolio/portfolio.service';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {
  projectsData : any;
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
      this.projectsData = data.projects;
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
    let name = (<HTMLInputElement>document.getElementById("name-project")).value;
    let place = (<HTMLInputElement>document.getElementById("place-project")).value;
    let englishDesc = (<HTMLInputElement>document.getElementById("english-description-project")).value;
    let spanishDesc = (<HTMLInputElement>document.getElementById("spanish-description-project")).value;
    
  

    let newProject = {
      projects: [
        {
          "id": id,
          "name":name, 
          "place":place, 
          "englishDescription":englishDesc,
          "spanishDescription":spanishDesc
        }
      ]
    }

    let project = JSON.stringify(newProject);
    
    this.dataPortfolio.editElement(1, "project", project)
      .subscribe((response) => {
        this.projectsData = response.projects
      });  
      this.btnAdd = false;
      this.id = 0;
  }

  editItem(event:any){
    this.addItem(); 
    this.id = event.target.id;
    
    setTimeout(() => {    
      let name = (<HTMLInputElement>document.getElementById("name-project"));
      let place = (<HTMLInputElement>document.getElementById("place-project"));
      let englishDesc = (<HTMLInputElement>document.getElementById("english-description-project"));
      let spanishDesc = (<HTMLInputElement>document.getElementById("spanish-description-project")); 
      
     for (let i = 0; i < this.projectsData.length; i++) {
      if(this.projectsData[i].id == this.id){
        name.value = (this.projectsData[i]).name;
        place.value = (this.projectsData[i]).place;
        englishDesc.value = (this.projectsData[i]).englishDescription;
        spanishDesc.value = (this.projectsData[i]).spanishDescription;
      }
     }
    }, 100);
   } 
}
