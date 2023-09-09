import { Component } from '@angular/core';

import { Router } from '@angular/router';
import { JwtValidationService } from '../tokenService/jwt-validation.service';
import jwt_decode from "jwt-decode";
import { FeedbackService } from '../beautiqueService/feedback.service';

@Component({
  selector: 'app-commentaire-user-list',
  templateUrl: './commentaire-user-list.component.html',
  styleUrls: ['./commentaire-user-list.component.css']
})
export class CommentaireUserListComponent {
 
  
  data:any = [];
  token: any;
  decodedToken: any;
 
  constructor(private httpCommentaie:FeedbackService,private router:Router,public validateToken:JwtValidationService){}

ngOnInit(): void {
  if(this.validateToken.isAuth()){
    this.token =  localStorage.getItem('token')
    this.decodedToken =  jwt_decode(JSON.stringify(this.token))
    console.log(this.decodedToken.sub)
    }
  this.httpCommentaie.listUserCommentaire(this.decodedToken.sub).subscribe((data)=>{
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
