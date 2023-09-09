import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class WishlistService {

  constructor(private http:HttpClient) { }
  api:string = 'http://localhost:8080/wishlist/';

  ajoutwishlist(produit:any){
    return this.http.post(this.api + 'add',produit) 
  }
  
  getwishlist(idUser:number){
    return this.http.get(this.api + 'findByIdUser/'+ idUser) 
  }
}
