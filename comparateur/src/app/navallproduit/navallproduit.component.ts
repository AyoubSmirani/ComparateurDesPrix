import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryServiceService } from '../beautiqueService/category-service.service';
import { JwtValidationService } from '../tokenService/jwt-validation.service';


@Component({
  selector: 'app-navallproduit',
  templateUrl: '../navbar/navbar.component.html',
  styleUrls: ['../navbar/navbar.component.css']
})
export class NavallproduitComponent {
  matricule:any = ''
  connected!:boolean 
  wishlist!:boolean
  commentaire!:boolean
  constructor(private activated:ActivatedRoute,private router:Router,private categoryService:CategoryServiceService,public validateToken:JwtValidationService){}
  ngOnInit(): void {
    if( this.router.url!='/Alllistproduit'){
    this.matricule = this.activated.snapshot.paramMap.get('matricule')
    }
    
      this.connected = this.validateToken.isAuth()
    

  }
  
  goto(cat:string){
    this.categoryService.setSelectedCategory(cat);
   this.router.navigate(['listproduit', cat]);
   
   
  }

  openClosewishlist(){
    this.commentaire = false
    this.wishlist = !this.wishlist
    console.log(this.wishlist)
  }
  openClosecommentaire(){
    this.wishlist = false
    this.commentaire = !this.commentaire
    console.log(this.wishlist)
  }
  
  logout(){
    localStorage.removeItem('token'); 
    this.ngOnInit();
  }
}
