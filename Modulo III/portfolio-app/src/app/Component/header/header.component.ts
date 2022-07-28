import { Component, OnInit } from '@angular/core';
import { PortfolioService } from 'src/app/Services/portfolio.service';
import { ShowInfoContactService } from 'src/app/Services/show-info-contact.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  myPortfolio:any;
  contactInfoView:Boolean;

  constructor(private dataPortfolio:PortfolioService, private showInfoContact:ShowInfoContactService) {
    this.contactInfoView = false;
   }

  ngOnInit(): void {
    this.dataPortfolio.getData().subscribe(data => {
      console.log(data);
      this.myPortfolio = data;
    });
  }
  Onclick(){
    if(this.contactInfoView === false) {
      this.contactInfoView = true;
    } else {
      this.contactInfoView = false;
    }
    
  }
   
  

}
