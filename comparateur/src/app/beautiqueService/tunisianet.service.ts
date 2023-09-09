import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TunisianetService {

  constructor(private http:HttpClient) { }
   api:string = 'http://localhost:8080/bon_plan/';
   navChangeCat!:boolean
   getAllProduct(){
    return this.http.get(this.api + 'all')
   }

   getProductById(id:number){
    return this.http.get(this.api + 'get/'+ id)
   }
   
   findProductsByName(nomProduit:string){
    return this.http.get(this.api + 'findNom/'+ nomProduit)
   }

   UpdateProduct(id:number,product:any){
    return this.http.put(this.api + 'update/' +id,product)
   }

   getProductByCategorie(categorie:string){
    return this.http.get(this.api + 'findcat/'+categorie)
   }

   addProduct(product:any){
    return this.http.post(this.api + 'add',product)
   }

   deleteProduct(id:number){
    return this.http.delete(this.api + 'delete/'+id)
   }

}
