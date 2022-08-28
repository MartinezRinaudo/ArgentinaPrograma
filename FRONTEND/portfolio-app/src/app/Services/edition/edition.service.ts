import { Injectable } from '@angular/core';
import { SecurityService } from '../security/security.service';


@Injectable({
  providedIn: 'root'
})
export class EditionService {
  btnsEdition : boolean = false;

  constructor(private security : SecurityService) {
    
  }
   
  public showBtnsEdition() {
    if(this.security.getToken()) {      
      return true;
    } else {
      return false;
    }
  }
}
