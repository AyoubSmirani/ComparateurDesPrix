import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TunisianetService } from 'src/app/beautiqueService/tunisianet.service';
import { Location } from '@angular/common';
import jwt_decode from "jwt-decode";
import { FeedbackService } from 'src/app/beautiqueService/feedback.service';
import { JwtValidationService } from 'src/app/tokenService/jwt-validation.service';
import { WishlistService } from 'src/app/wishlistserv/wishlist.service';
import { UserService } from 'src/app/UserService/user.service';
import { ListCommentaireComponent } from 'src/app/list-commentaire/list-commentaire.component';
@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css']
})
export class ProduitComponent implements OnInit{
  constructor(private activated:ActivatedRoute,private http:TunisianetService,private location: Location ,
    public validateToken:JwtValidationService,private feddbackHttp:FeedbackService,private httpwishlist:WishlistService,
    private httpUser:UserService,private listCommentaireComponent:ListCommentaireComponent
    ){}
  data:any = {}
  id:any
  connected!:boolean
   token:any
    decodedToken:any 
  AlLdatabyNameProduct:any = []
  Cfeedback:boolean = false


  feedback = {
    commentaire:'',
    id_produit:0,
    id_user:0,
    nom_produit:'',
    reponse_commentaire:'',
    nomUser:''
   }
 wishlist = { 
   	id_produit:0,
    	id_user:0,
      image_produit:'',
      nom_produit:'',
      prix_produit:0,
      
 }


  parse(char:string){
    return parseInt(char)
  }

  ngOnInit(): void {



    this.id = this.activated.snapshot.paramMap.get('idP')
    
    if(this.validateToken.isAuth()){
      this.token =  localStorage.getItem('token')
      this.decodedToken =  jwt_decode(JSON.stringify(this.token))
      console.log(this.decodedToken)
      }

    this.http.getProductById(this.id).subscribe((data:any)=>{  
        console.log(data.table_description)  
         this.connected = this.validateToken.isAuth()
         this.data = data
            this.http.findProductsByName(data.nomProduit).subscribe((data)=>{
               console.log(data)
              this.AlLdatabyNameProduct = data      
           },(err)=>{
              console.log(err)
           })
    },(err)=>{
          console.log(err)
    })



    
  }

  

  commentez(nom_produit:string,id_produit:number){
    
    this.feedback.nom_produit = nom_produit;
    this.feedback.id_produit = id_produit;
    this.feedback.id_user = this.decodedToken.sub
    console.log(this.feedback.commentaire)
    if(this.feedback.commentaire !== ''){
    this.httpUser.getCompte(this.feedback.id_user).subscribe((data:any)=>{
      console.log(data)
    this.feedback.nomUser = data.firstname + ' ' + data.lastname
    this.feddbackHttp.ajouterCommentaire(this.feedback).subscribe((data)=>{
               console.log(data) 
               this.listCommentaireComponent.ngOnInit();
             },(err)=>{
               console.log(err)
    })
    },(err)=>{
      console.log(err)
    })}
    else{
         this.Cfeedback = true
    }
    
  }

  ajouterWishlist(nom_produit:string,id_produit:number,image_produit:string,prix_produit:number){
    console.log(nom_produit)
    this.wishlist.nom_produit = nom_produit;
    this.wishlist.id_produit = id_produit;
    this.wishlist.image_produit = image_produit;
    this.wishlist.prix_produit = prix_produit;
    this.wishlist.id_user = this.decodedToken.sub
    console.log(this.wishlist)
    this.httpwishlist.ajoutwishlist(this.wishlist).subscribe((data)=>{
      console.log(data)
    },(err)=>{
      console.log(err)
    }) 
  }




  goBack(): void {
    this.location.back();
  }

  logout(){
    localStorage.removeItem('token'); 
    this.ngOnInit();
  }

}
