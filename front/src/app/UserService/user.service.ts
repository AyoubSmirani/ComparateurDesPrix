import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http:HttpClient) { }
  api:string = 'http://localhost:8080/user/';

  ajoutCompte(user:any){
    return this.http.post(this.api + 'addUser',user) 
  }
  
  supprimerCompte(id:number){
   return this.http.delete(this.api + 'deleteUser/' + id).pipe(
    catchError((error: any) => {
      console.error('Error deleting user:', error);
      return of('Unable to delete user.');
    })
  );
  }
  
  AfficherCompte(){
    return this.http.get(this.api + 'getAllUsers' )
   }

  login(user:any){
    return this.http.post(this.api + 'signin',user) 
  }
  
  modifierCompte(user:any){
    return this.http.put(this.api + 'updateUser/' + user.id ,user) 
  }
  
  getCompte(id:any){
    return this.http.get(this.api + 'get/' + id ) 
  }
}
