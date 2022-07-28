import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './Component/header/header.component';
import { LanguagesComponent } from './Component/languages/languages.component';
import { AboutmeComponent } from './Component/aboutme/aboutme.component';
import { ExperienceComponent } from './Component/experience/experience.component';
import { EducationComponent } from './Component/education/education.component';
import { TechnologiesComponent } from './Component/technologies/technologies.component';
import { ProjectsComponent } from './Component/projects/projects.component';
import { PortfolioService } from './Services/portfolio.service';
import { HttpClientModule } from '@angular/common/http'
import { ShowInfoContactService } from './Services/show-info-contact.service';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LanguagesComponent,
    AboutmeComponent,
    ExperienceComponent,
    EducationComponent,
    TechnologiesComponent,
    ProjectsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [PortfolioService, ShowInfoContactService],
  bootstrap: [AppComponent]
})
export class AppModule { }
