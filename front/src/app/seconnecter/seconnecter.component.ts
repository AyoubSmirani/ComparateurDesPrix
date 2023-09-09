import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import jwt_decode from "jwt-decode";
import { delay } from 'rxjs';
import { UserService } from '../UserService/user.service';
@Component({
  selector: 'app-seconnecter',
  templateUrl: './seconnecter.component.html',
  styleUrls: ['./seconnecter.component.css']
})
export class SeconnecterComponent  {
  test = "";
  error = '';
  inputFormulaire!: FormGroup;
    constructor(private fb: FormBuilder, private router: Router,private http:UserService)
    {
      this.inputFormulaire = this.fb.group(
        {
          "email": ["", [Validators.required, Validators.email]],
          "password": ["", [Validators.required]]
        }
      )
    }
    ngOnInit(): void{ 

    }



    onSubmit(){
      console.log(this.inputFormulaire.value)
      this.http.login(this.inputFormulaire.value).subscribe ((data:any)=>{
      console.log(data);
      localStorage.setItem('token',data.token); // Stockage du token dans le Local Storage
      
      var token =  localStorage.getItem('token') ;  // Récupération du token depuis le Local Storage
      const decodedToken:any = jwt_decode(JSON.stringify(token)) // Décodage du token grâce à la bibliothèque jwt_decode
      console.log(decodedToken)
     console.log(token)
     // Redirection vers la page correspondante en fonction du rôle de l'utilisateur 
     if(decodedToken.role==='admin'){ 
      this.router.navigate(['adminAcceuil'])
     }
     else{
      this.router.navigate(['Alllistproduit'])
     }
       
    }
    ,
    (err)=>{
      this.error = 'mot de passe ou email incorrect'
      console.log(err) // Affichage de l'erreur en cas d'échec de la méthode login() de AuthService
    },
    )
    delay(20000)
   
    }
}
