import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TunisianetService } from 'src/app/beautiqueService/tunisianet.service';

@Component({
  selector: 'app-listproduit',
  templateUrl: './listproduit.component.html',
  styleUrls: ['./listproduit.component.scss']
})
export class ListproduitComponent implements OnInit{
  constructor(private http:TunisianetService,private router:Router,){}
  searchText:string = ''
  perPage: number = 16;
  currentPage: number = 1;
   data:any = []
   totalRecords: number = this.data.length;
  ngOnInit(): void {
    console.log(this.searchText)
    this.http.getAllProduct().subscribe((data)=>{
        this.data = data;
        console.log(this.data)
    },(err)=>{
       console.log(err)
    })
  }
  

  navigateToFirstPage(): void {
    this.currentPage = 1;
  } 
  goto(id:number){
    this.router.navigate(['produit',id])
  }


}
