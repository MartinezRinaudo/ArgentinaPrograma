import { Component, OnInit } from '@angular/core';
import { PortfolioService } from 'src/app/Services/portfolio/portfolio.service';

@Component({
  selector: 'app-experience',
  templateUrl: './experience.component.html',
  styleUrls: ['./experience.component.css']
})
export class ExperienceComponent implements OnInit {

  experienceData:any;

  constructor(private dataPortfolio:PortfolioService) { }

  ngOnInit(): void {
    this.dataPortfolio.getData().subscribe(data => {
      this.experienceData = data.experience;
    });
  }

}
