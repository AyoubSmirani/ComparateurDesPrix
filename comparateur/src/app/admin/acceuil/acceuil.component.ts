import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/UserService/user.service';

@Component({
  selector: 'app-acceuil',
  templateUrl: './acceuil.component.html',
  styleUrls: ['./acceuil.component.scss']
})
export class AcceuilComponent implements OnInit{
  data:any = []
  constructor(private http:UserService){}


  ngOnInit(): void {
    this.http.AfficherCompte().subscribe((data)=>{
        console.log(data)
        this.data = data
    },(err)=>{
        console.log(err)
    })
  }


  delete(id:number){
    console.log(id)
    this.http.supprimerCompte(id).subscribe((data)=>{
       console.log(data)
       this.ngOnInit()
    },(err)=>{
        console.log(err)
    })
  }


  
}
