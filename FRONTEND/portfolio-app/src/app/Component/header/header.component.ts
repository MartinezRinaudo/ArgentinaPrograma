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
  imageContact:string
  imageHeader:string;
  id: number;

  constructor(private dataPortfolio:PortfolioService, private edition:EditionService) {
    this.contactInfoView = false;
    this.btnEdition = this.edition.btnsEdition;
    this.btnAdd = this.edition.btnsAdd;
    this.imageHeader = "";
    this.imageContact = "";
    this.id = 0;
   }

  ngOnInit(): void {
    this.dataPortfolio.getData(1).subscribe(data => {
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
    this.imageHeader = element.target.files[0].name;
   }


   saveChangesH() {
   
    let fullName = (<HTMLInputElement>document.getElementById("name-header")).value;
    let profession = (<HTMLInputElement>document.getElementById("profession-header")).value;
    let email = (<HTMLInputElement>document.getElementById("email-header")).value;
    let location = (<HTMLInputElement>document.getElementById("location-header")).value;
    let imageUrl = "./assets/images/" + this.imageHeader;

    const patchProfileInfo = (element:any, patchElement:string) =>{
      let info = JSON.stringify(element);
    
       this.dataPortfolio.editElement(1, patchElement, info)
      .subscribe((response) => {
        this.myPortfolio = response;
      });  
      this.btnAdd = false;
      this.id = 0;
    }
    
    if(fullName != null) {
      let name = {"fullName": fullName}
      patchProfileInfo(name, "FULLNAME")
    }
    if(profession != null) {
      let prof = {"profession": profession}
      patchProfileInfo(prof, "PROFESSION")
    }
    if(email != null) {
      let mail = {"email": email}
      patchProfileInfo(mail, "EMAIL")
    }
    if(location != null) {
      let loc = {"location": location}
      patchProfileInfo(loc, "LOCATION")
    }
    if(imageUrl != null) {
      let imgUrl = {"imageUrl": imageUrl}
      patchProfileInfo(imgUrl, "IMAGEURL")
    }
  }

  saveChangesCI() {
    let id = this.id;
    let name = (<HTMLInputElement>document.getElementById("name-contact")).value;
    let link = (<HTMLInputElement>document.getElementById("link-contact")).value;
    let imageInput = "./assets/images/" + this.imageContact;

    console.log(imageInput)
    
    let newContact = {
      "contactInformation": [
        {
            "id": id,
            "imageUrl": imageInput,
            "imageName": name,
            "link": link,
            "socialMedia": name
        }
      ]
    }
    
    let contact = JSON.stringify(newContact);
    
    this.dataPortfolio.editElement(1, "contactinformation", contact)
      .subscribe((response) => {
        this.myPortfolio.contactInformation = response.contactInformation;
      });  
      this.btnAdd = false;
      this.id = 0;
  }


  editItem(event:any){
    this.addItem(); 
    this.id = event.target.id;
    console.log(this.id)
    
    setTimeout(() => {    
      let name = (<HTMLInputElement>document.getElementById("name-contact"));
      let link = (<HTMLInputElement>document.getElementById("link-contact"));
      let imageInput =  (<HTMLInputElement>document.getElementById("image-contact"));
      let fullName = (<HTMLInputElement>document.getElementById("name-header"));
      let profession = (<HTMLInputElement>document.getElementById("profession-header"));
      let email = (<HTMLInputElement>document.getElementById("email-header"));
      let location = (<HTMLInputElement>document.getElementById("location-header"));
      let imageUrl = (<HTMLInputElement>document.getElementById("image-header"));
      
     for (let i = 0; i < this.myPortfolio.contactInformation.length; i++) {
        if(this.myPortfolio.contactInformation[i].id == this.id){
          name.value = (this.myPortfolio.contactInformation[i]).socialMedia;
          link.value = (this.myPortfolio.contactInformation[i]).link;
          imageInput.value = (this.myPortfolio.contactInformation[i]).imageUrl;
        }
      }

      if(this.myPortfolio.id == this.id){
        fullName.value = (this.myPortfolio).fullName;
        profession.value = (this.myPortfolio).profession;
        email.value = (this.myPortfolio).email;
        location.value = (this.myPortfolio).location;
        imageUrl.value = (this.myPortfolio).imageUrl;
      }
  
    }, 100);
   } 
   
 
 
  

}
