import { Component, OnInit } from '@angular/core';
import { EditionService } from 'src/app/Services/edition/edition.service';
import { PortfolioService } from 'src/app/Services/portfolio/portfolio.service';

@Component({
  selector: 'app-education',
  templateUrl: './education.component.html',
  styleUrls: ['./education.component.css']
})
export class EducationComponent implements OnInit {

  education:any;
  btnEdition : boolean; 

  constructor(private dataPortfolio:PortfolioService, private edition:EditionService) { 
    this.btnEdition = this.edition.btnsEdition;
  }

  ngOnInit(): void {
    this.dataPortfolio.getData().subscribe(data => {
      this.education = data.education;
    });
    this.btnEdition = this.edition.showBtnsEdition();
  }

}
