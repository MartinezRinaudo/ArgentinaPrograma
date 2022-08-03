import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './Component/header/header.component';
import { LanguagesComponent } from './Component/languages/languages.component';
import { AboutmeComponent } from './Component/aboutme/aboutme.component';
import { ExperienceComponent } from './Component/experience/experience.component';
import { EducationComponent } from './Component/education/education.component';
import { TechnologiesComponent } from './Component/technologies/technologies.component';
import { ProjectsComponent } from './Component/projects/projects.component';
import { PortfolioService } from './Services/portfolio/portfolio.service';
import { HttpClientModule } from '@angular/common/http';
import { NavigationComponent } from './Component/navigation/navigation.component';
import { LoginComponent } from './Component/login/login.component';
import { PortfolioComponent } from './Component/portfolio/portfolio.component';
import { SignupComponent } from './Component/signup/signup.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LanguagesComponent,
    AboutmeComponent,
    ExperienceComponent,
    EducationComponent,
    TechnologiesComponent,
    ProjectsComponent,
    NavigationComponent,
    LoginComponent,
    PortfolioComponent,
    SignupComponent,

  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot([
      {path: 'portfolio', component: PortfolioComponent},
      {path: 'login', component: LoginComponent},
      {path: 'signup', component: SignupComponent},
      {path: '', redirectTo: '/portfolio', pathMatch: 'full'},
    ]),
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [PortfolioService],
  bootstrap: [AppComponent]
})
export class AppModule { }
