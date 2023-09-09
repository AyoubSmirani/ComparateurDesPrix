import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../UserService/user.service';
import { Router } from '@angular/router';
import jwt_decode from "jwt-decode";
import { JwtValidationService } from '../tokenService/jwt-validation.service';
@Component({
  selector: 'app-gerer-compte',
  templateUrl: './gerer-compte.component.html',
  styleUrls: ['./gerer-compte.component.css']
})
export class GererCompteComponent implements OnInit{
  
  user = {
    id: 0,
    firstname: '',
    lastname: '',
    email: '',
    password: '',
    role: ''
  };
  token: any;
  decodedToken: any;
  
  inputForm!: FormGroup;
  
  constructor(
    private fb: FormBuilder,
    private http: UserService,
    private router: Router,
    public validateToken: JwtValidationService
  ) {
    this.inputForm = this.fb.group({
      id:[ 0 ],
      firstname: ['', Validators.required],
      lastname: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
      role: ['', Validators.required]
    });
  }
  
  ngOnInit(): void {
    this.token = localStorage.getItem('token');
    this.decodedToken = jwt_decode(JSON.stringify(this.token));
    console.log(this.decodedToken);
  
    this.http.getCompte(this.decodedToken.sub).subscribe(
      (data: any) => {
        this.user.id = data.id;
        this.user.email = data.email;
        this.user.firstname = data.firstname;
        this.user.password = data.password;
        this.user.lastname = data.lastname;
  
        this.inputForm.patchValue({
          id: data.id,
          email: data.email,
          firstname: data.firstname,
          password: data.password,
          lastname: data.lastname
        });
      },
      (err) => {
        console.log(err);
      }
    );
  }
  
  ChangerMesCordonnes() {
    console.log(this.inputForm.value);
    this.http.modifierCompte(this.inputForm.value).subscribe(
      (data) => {
        console.log(data);
        // handle success callback
      },
      (err) => {
        console.log(err);
        // handle error callback
      }
    );
  }

SupprimerCompte(){

  localStorage.removeItem('token');
  this.router.navigate(['login'])
this.http.supprimerCompte(this.decodedToken.sub).subscribe((data)=>{
  console.log(data)
  
},(err)=>{
  console.log(err)
})

}








}
