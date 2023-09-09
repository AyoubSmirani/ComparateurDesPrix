import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../UserService/user.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-inscrire',
  templateUrl: './inscrire.component.html',
  styleUrls: ['./inscrire.component.css']
})
export class InscrireComponent {
  inputForm!: FormGroup;
  constructor(private fb: FormBuilder,private http:UserService,private router:Router) {
    this.inputForm = this.fb.group(
      { "firstname": ["", Validators.required],
        "lastname": ["", Validators.required],
        "email": ["", [Validators.required,Validators.email]],
        "password": ["", Validators.required],
        "role": ["user", Validators.required]
      }
   )

  }

  Signup(){
    console.log(this.inputForm.value)
    this.http.ajoutCompte(this.inputForm.value).subscribe((data)=>{
      this.router.navigate(['login'])
    },(err)=>{
       console.log(err)
    })
  }





}
