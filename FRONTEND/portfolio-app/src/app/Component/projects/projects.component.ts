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
  id: any;

  constructor(private dataPortfolio:PortfolioService, private edition : EditionService) { 
    this.btnEdition = this.edition.btnsEdition;
    this.btnAdd = this.edition.btnsAdd;
    this.id = null;
  }

  ngOnInit(): void {
    this.dataPortfolio.getData().subscribe(data => {
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
    /*SIN CONEXION CON EL BACKEND*/
    
    let name = (<HTMLInputElement>document.getElementById("name-project")).value;
    let place = (<HTMLInputElement>document.getElementById("place-project")).value;
    let englishDesc = (<HTMLInputElement>document.getElementById("english-description-project")).value;
    let spanishDesc = (<HTMLInputElement>document.getElementById("spanish-description-project")).value;
    
    let idProject:number;
    if(this.id == null) {
      idProject = this.projectsData.length;
    } else {
      idProject = this.id;
    }

    let newProject = {
      "id": idProject,
      "name":name, 
      "place":place, 
      "descriptionEnglish":englishDesc,
      "descriptionSpanish":spanishDesc
    }

    if(this.id == null) {
      this.projectsData.unshift(newProject);
    }else {
      this.projectsData[idProject] = newProject
    }

    
    this.btnAdd = false;
    this.id = null;
  }

  editItem(event:any){
    this.addItem(); 
    this.id = event.target.id;

    let name = (<HTMLInputElement>document.getElementById("data-list-project-name-" + this.id)).textContent;
    let place = (<HTMLInputElement>document.getElementById("data-list-project-place-" + this.id)).textContent;
    let englishDesc = (<HTMLInputElement>document.getElementById("data-list-project-description-en-" + this.id)).textContent;
    let spanishDesc = (<HTMLInputElement>document.getElementById("data-list-project-description-es-" + this.id)).textContent;
   
    let information: string[];

    if(name != null && place != null && englishDesc != null && spanishDesc != null){
       information = [name, place, englishDesc, spanishDesc]
    }
    setTimeout(() =>{
      let inputs = document.getElementsByTagName("input");

      for (let i = 0; i < inputs.length; i++) {
        inputs[i].value = information[i]
      }
    },100)
  }

}
