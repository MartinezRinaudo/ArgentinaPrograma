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
  btnEdition : boolean

  constructor(private dataPortfolio:PortfolioService, private edition:EditionService) {
    this.contactInfoView = false;
    this.btnEdition = this.edition.btnsEdition;
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
   
  

}
