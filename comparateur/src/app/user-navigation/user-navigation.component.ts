import { Component, OnInit } from '@angular/core';
import { JwtValidationService } from '../tokenService/jwt-validation.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-navigation',
  templateUrl: './user-navigation.component.html',
  styleUrls: ['./user-navigation.component.css']
})
export class UserNavigationComponent implements OnInit{
  wishlist!:boolean
  commentaire!:boolean
  connected!:boolean 
  constructor(public validateToken:JwtValidationService,private router:Router){}
  ngOnInit(): void {
   // if( this.router.url!='/Alllistproduit'){
  // this.matricule = this.activated.snapshot.paramMap.get('matricule')
  //  }

      this.connected = this.validateToken.isAuth()
   
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
    this.router.navigate(['login'])
  }

}
