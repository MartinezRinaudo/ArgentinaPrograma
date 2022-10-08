import { Component, OnInit } from '@angular/core';
import { EditionService } from 'src/app/Services/edition/edition.service';
import { PortfolioService } from 'src/app/Services/portfolio/portfolio.service';

@Component({
  selector: 'app-aboutme',
  templateUrl: './aboutme.component.html',
  styleUrls: ['./aboutme.component.css']
})
export class AboutmeComponent implements OnInit {
  aboutme:any;
  btnEdition : boolean; 
  
  constructor(private dataPortfolio:PortfolioService, private edition:EditionService) { 
    this.btnEdition = this.edition.btnsEdition;
  }

  ngOnInit(): void {
    this.dataPortfolio.getData(1).subscribe(data => {
      this.aboutme = data.aboutMe;
    });
    this.btnEdition = this.edition.showBtnsEdition();
  }

}
