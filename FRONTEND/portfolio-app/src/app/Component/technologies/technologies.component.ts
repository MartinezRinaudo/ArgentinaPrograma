import { Component, OnInit } from '@angular/core';
import { EditionService } from 'src/app/Services/edition/edition.service';
import { PortfolioService } from 'src/app/Services/portfolio/portfolio.service';

@Component({
  selector: 'app-technologies',
  templateUrl: './technologies.component.html',
  styleUrls: ['./technologies.component.css']
})
export class TechnologiesComponent implements OnInit {
  technologiesData : any;
  btnEdition : boolean;
  btnAdd : boolean;
  imageTech:string
  idPrincipal: number;
  idElement:number;

  constructor(private dataPortfolio:PortfolioService, private edition:EditionService) { 
    this.btnEdition = this.edition.btnsEdition;
    this.btnAdd = this.edition.btnsAdd;
    this.imageTech = "";
    this.idPrincipal = 0;
    this.idElement = 0;
   
  }

  ngOnInit(): void {
    this.dataPortfolio.getData(1).subscribe(data => {
      this.technologiesData = data.technologies;
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

  openFile(element:any) {
    this.imageTech = element.target.files[0].name;
  }

  saveChanges() {
   
    let id = this.idPrincipal;
    let category = (<HTMLInputElement>document.getElementById("category-tech")).value;
    let idTech = this.idElement;
    let imageUrl = "./assets/images/" + this.imageTech;
    let name = (<HTMLInputElement>document.getElementById("name-tech")).value;
    let percentage = (<HTMLInputElement>document.getElementById("percentage-tech")).value;
  
    let newTech = {
      technologies : [
        {
          "id": id,
          "category": category,
          "technologyList": [
              {
                "id": idTech,
                "imageUrl": imageUrl,
                "imageName": name,
                "percentage": percentage
              }
            ]
        }
      ]
    }
      
    let tech = JSON.stringify(newTech);
    
    this.dataPortfolio.editElement(1, "technology", tech)
      .subscribe((response) => {
        this.technologiesData = response.technologies;
      });  
      this.btnAdd = false;
      this.idPrincipal = 0;
      this.idElement = 0;
  }

  editItem(event:any){
    this.addItem(); 
    this.idElement = event.path[5].id;
    this.idPrincipal = event.target.id;
    
    setTimeout(() => {    
      let category = (<HTMLInputElement>document.getElementById("category-tech"));
      let imageUrl = (<HTMLInputElement>document.getElementById("image-tech"));
      let name = (<HTMLInputElement>document.getElementById("name-tech"));
      let percentage = (<HTMLInputElement>document.getElementById("percentage-tech"));
      
      
     for (let i = 0; i < this.technologiesData.length; i++) {
      
      if(this.technologiesData[i].id == this.idPrincipal){

        category.value = (this.technologiesData[i]).category;
        
        for (let j = 0; j < (this.technologiesData[i]).technologyList.length; j++) {
          if(this.technologiesData[i].technologyList[j].id == this.idElement) {
            //imageUrl.value = (this.technologiesData[i]).technologyList[j].imageUrl;
            name.value = this.technologiesData[i].technologyList[j].imageName;
            percentage.value =this.technologiesData[i].technologyList[j].percentage;
            
          }  
        }  
      }  
     }
    }, 5000);
   } 
}


