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

  constructor(private dataPortfolio:PortfolioService, private edition : EditionService) { 
    this.btnEdition = this.edition.btnsEdition;
  }

  ngOnInit(): void {
    this.dataPortfolio.getData().subscribe(data => {
      this.experienceData = data.experience;
    });
    this.btnEdition = this.edition.showBtnsEdition();
  }

}
