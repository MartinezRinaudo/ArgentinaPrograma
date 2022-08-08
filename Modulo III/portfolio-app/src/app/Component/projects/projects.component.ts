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

  constructor(private dataPortfolio:PortfolioService, private edition : EditionService) { 
    this.btnEdition = this.edition.btnsEdition;
  }

  ngOnInit(): void {
    this.dataPortfolio.getData().subscribe(data => {
      this.projectsData = data.projects;
    });
    this.btnEdition = this.edition.showBtnsEdition();
  }

}
