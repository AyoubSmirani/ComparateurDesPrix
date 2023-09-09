import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { CategoryServiceService } from '../beautiqueService/category-service.service';
import { TokeninterceptorService } from '../tokenService/tokeninterceptor.service';
import { JwtValidationService } from '../tokenService/jwt-validation.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent  implements OnInit{
  
  matricule:any = ''
 
  constructor(private activated:ActivatedRoute,private router:Router,private categoryService:CategoryServiceService,public validateToken:JwtValidationService){}
  ngOnInit(): void {
    if( this.router.url!='/Alllistproduit'){
    this.matricule = this.activated.snapshot.paramMap.get('matricule')
    }

    //  this.connected = this.validateToken.isAuth()
   
  }
  
  goto(cat:string){
    //if( this.router.url!=`/listproduit/${this.matricule}`){
     // this.list.ngOnInit()
   // }
   if(cat===''){
    
        this.router.navigate(['alllistproduit'])   
   }else{
    this.categoryService.setSelectedCategory(cat);
   this.router.navigate(['listproduit', cat]);
   }
   
  }


 


}
