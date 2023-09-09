import { Component, OnInit } from '@angular/core';
import { FeedbackService } from '../beautiqueService/feedback.service';
import { ActivatedRoute } from '@angular/router';
import { UserService } from '../UserService/user.service';
import jwt_decode from "jwt-decode";
@Component({
  selector: 'app-list-commentaire',
  templateUrl: './list-commentaire.component.html',
  styleUrls: ['./list-commentaire.component.css']
})
export class ListCommentaireComponent implements OnInit{

  listCommentaire:any = []
  id:any
  name!:string 
  token:any
    decodedToken:any 
  constructor(private feddbackHttp:FeedbackService,private activated:ActivatedRoute,private httpUser:UserService){}

  ngOnInit(): void {
    this.id = this.activated.snapshot.paramMap.get('idP')
    this.token =  localStorage.getItem('token')
      this.decodedToken =  jwt_decode(JSON.stringify(this.token))

    this.feddbackHttp.listProduitCommentaire(this.id).subscribe((data)=>{
      
      console.log(data)
      this.listCommentaire = data
      this.httpUser.getCompte(this.decodedToken.sub).subscribe((data:any)=>{
        this.name  = data.firstname + ' ' + data.lastname
      },(err)=>{
        console.log(data)
      })
    },(err)=>{
          console.log(err)
    })
  }




}
