import { Component, OnInit } from '@angular/core';
import { WishlistService } from '../wishlistserv/wishlist.service';
import { Router } from '@angular/router';
import { JwtValidationService } from '../tokenService/jwt-validation.service';
import jwt_decode from "jwt-decode";
@Component({
  selector: 'app-wishlist',
  templateUrl: './wishlist.component.html',
  styleUrls: ['./wishlist.component.css']
})
export class WishlistComponent implements OnInit {

  data:any = [];
  token: any;
  decodedToken: any;
 
  constructor(private httpwishlist:WishlistService,private router:Router,public validateToken:JwtValidationService){}

ngOnInit(): void {
  if(this.validateToken.isAuth()){
    this.token =  localStorage.getItem('token')
    this.decodedToken =  jwt_decode(JSON.stringify(this.token))
    console.log(this.decodedToken.sub)
    }
  this.httpwishlist.getwishlist(this.decodedToken.sub).subscribe((data)=>{
      console.log(data)
      this.data = data
  },(err)=>{
    console.log(err)
  })
}

goto(id:number){
  this.router.navigate(['produit',id])
}



}
