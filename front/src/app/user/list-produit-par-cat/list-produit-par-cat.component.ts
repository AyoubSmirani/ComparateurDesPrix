import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryServiceService } from 'src/app/beautiqueService/category-service.service';
import { TunisianetService } from 'src/app/beautiqueService/tunisianet.service';
import { JwtValidationService } from 'src/app/tokenService/jwt-validation.service';
import jwt_decode from "jwt-decode";
import { FeedbackService } from 'src/app/beautiqueService/feedback.service';
@Component({
  selector: 'app-list-produit-par-cat',
  templateUrl: './list-produit-par-cat.component.html',
  styleUrls: ['./list-produit-par-cat.component.scss']
})
export class ListProduitParCatComponent implements OnInit{
  constructor(private http:TunisianetService,private activated:ActivatedRoute,
    private categoryService: CategoryServiceService,private router:Router,
    public validateToken:JwtValidationService,private feddbackHttp:FeedbackService){}

    
  searchText:string = ''
  perPage: number = 16;
  currentPage: number = 1;
   data:any = []
   totalRecords: number = this.data.length;
   cat:any =''
   connected!:boolean
   


 
  ngOnInit(): void {
  
    this.cat = this.activated.snapshot.paramMap.get('cat')
    
    this.categoryService.getSelectedCategory().subscribe((cat) => {
      this.cat = cat;
      this.http.getProductByCategorie(cat).subscribe(
        (data) => {
          this.connected = this.validateToken.isAuth()
          this.data = data;
          console.log(this.data);
        },
        (err) => {
          console.log(err);
        }
      );
    });


  }
  

  goto(id:number){
      this.router.navigate(['produit',id])
  }


  navigateToFirstPage(): void {
    this.currentPage = 1;
  }




}
