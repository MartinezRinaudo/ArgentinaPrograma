import { Component, OnInit } from '@angular/core';
import { EditionService } from 'src/app/Services/edition/edition.service';
import { PortfolioService } from 'src/app/Services/portfolio/portfolio.service';
import { PortfolioComponent } from '../portfolio/portfolio.component';

@Component({
  selector: 'app-technologies',
  templateUrl: './technologies.component.html',
  styleUrls: ['./technologies.component.css']
})
export class TechnologiesComponent implements OnInit {
  technologiesData : any;
  btnEdition : boolean;

  constructor(private dataPortfolio:PortfolioService, private edition:EditionService) { 
    this.btnEdition = this.edition.btnsEdition;
  }

  ngOnInit(): void {
    this.dataPortfolio.getData().subscribe(data => {
      this.technologiesData = data.technologies;
    });
    this.btnEdition = this.edition.showBtnsEdition();
  }
}


