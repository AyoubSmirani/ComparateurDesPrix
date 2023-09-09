import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

  constructor(private http:HttpClient) { }
  api:string = 'http://localhost:8080/feedback/';
 
  ajouterCommentaire(commentaire:any){
   return this.http.post(this.api + 'add', commentaire)
  }

  ToutCommentaire(){
    return this.http.get(this.api + 'all')
  }
  
  mondifierCommentaire(commentaire:any){
    console.log(commentaire)
    return this.http.put(this.api + 'update/' + commentaire.id_feedback, commentaire)
   }
   
   supprimerCommentaire(id:number){
    return this.http.delete(this.api + 'delete/' + id)
   }
   
   listUserCommentaire(idCommentaire:number){
    return this.http.get(this.api + 'findByIdUser/'+ idCommentaire)
  }
  
  listProduitCommentaire(id:number){
    return this.http.get(this.api + 'findByIdProduit/'+ id)
  }

}
