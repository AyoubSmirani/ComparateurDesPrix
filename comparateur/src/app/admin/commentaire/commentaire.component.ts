import { Component, Inject, OnInit } from '@angular/core';
import { FeedbackService } from 'src/app/beautiqueService/feedback.service';

import {MatDialog, MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

export interface DialogData {
  id_feedback: number;
  idProduit: number;
  commentaire:string;
  id_user:number;
  nom_produit:string;
  reponseCommentaire:string;
  nomUser:string;
}










@Component({
  selector: 'app-commentaire',
  templateUrl: './commentaire.component.html',
  styleUrls: ['./commentaire.component.scss']
})
export class CommentaireComponent implements OnInit{
  
  data:any = []
  perPage: number = 16;
  currentPage: number = 1;
  totalRecords: number = this.data.length;
  constructor(private httpfeedback:FeedbackService,public dialog: MatDialog){}
  ngOnInit(): void {
      this.httpfeedback.ToutCommentaire().subscribe((data)=>{
        console.log(data)
        this.data = data
      },(err)=>{
        console.log(err)
      })
  }
   
  
  navigateToFirstPage(): void {
    this.currentPage = 1;
  }


  supprimer(id:number){
    this.httpfeedback.supprimerCommentaire(id).subscribe((data)=>{
      console.log(data)
      this.ngOnInit()
    },(err)=>{
      console.log(err)
    })
  }


  

  openDialog(data:any) {
    
    const dialogRef = this.dialog.open(DialogAnimationsExampleDialog, {
      data: { id_feedback: data.id_feedback,
        idProduit: data.idProduit,
        commentaire:data.commentaire,
        nomUser:data.nomUser,
        id_user:data.id_user,
        nom_produit:data.nom_produit,
        reponseCommentaire:data.reponseCommentaire},
    });
  }





}


@Component({
  selector: 'dialog-animations-example-dialog',
  templateUrl: 'dialog-animations-example-dialog.html',
})
export class DialogAnimationsExampleDialog implements OnInit{
  constructor(
    private httpFeddback:FeedbackService,
     
    public dialogRef: MatDialogRef<DialogAnimationsExampleDialog>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
  ) {}
  feedback = {
    id_feedback:this.data.id_feedback,
     commentaire:this.data.commentaire,
     idProduit:this.data.idProduit,
     id_user:this.data.id_user,
     nomUser:this.data.nomUser,
     nom_produit:this.data.nom_produit,
     reponseCommentaire:''
    }
   
   

  ngOnInit(): void {
    console.log(this.data)
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  onInput(event: any) {
    this.feedback.reponseCommentaire = ''
    this.feedback.reponseCommentaire += event.target.value;
    
  }

  commentez() {
    console.log(this.feedback.reponseCommentaire);
    this.httpFeddback.mondifierCommentaire(this.feedback).subscribe((data)=>{
      console.log(data)
      this.ngOnInit();
    //  this.comment.ngOnInit();
      this.dialogRef.close();
    }
    ,(err)=>{
      console.log(err)
    })
  }
}

