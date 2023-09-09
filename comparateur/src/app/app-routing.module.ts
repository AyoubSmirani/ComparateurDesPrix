import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SeconnecterComponent } from './seconnecter/seconnecter.component';
import { ListproduitComponent } from './user/listproduit/listproduit.component';
import { ListProduitParCatComponent } from './user/list-produit-par-cat/list-produit-par-cat.component';
import { ProduitComponent } from './user/produit/produit.component';
import { InscrireComponent } from './inscrire/inscrire.component';
import { CommentaireComponent } from './admin/commentaire/commentaire.component';
import { AcceuilComponent } from './admin/acceuil/acceuil.component';
import { RoleGuard } from './guard/role.guard';
import { GererCompteComponent } from './gerer-compte/gerer-compte.component';

const routes: Routes = [
  {path:'', redirectTo:'Alllistproduit' ,pathMatch:'full'},

  {path:'login',component:SeconnecterComponent },

  {path:'inscrire',component:InscrireComponent },
  
  {path:'Alllistproduit',component:ListproduitComponent},
  
  {path:'listproduit/:cat',component:ListProduitParCatComponent},

  {path:'produit/:idP',component:ProduitComponent},

  {path:'GererCompte',component:GererCompteComponent},

  {path:'adminAcceuil',component:AcceuilComponent ,canActivate:[RoleGuard] ,data:{expectedRole:'admin'}},

  {path:'adminlistCommentaire',component:CommentaireComponent ,canActivate:[RoleGuard] ,data:{expectedRole:'admin'}},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
