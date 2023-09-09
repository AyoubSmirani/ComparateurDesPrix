import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
//import { TokenInterceptorService } from './services/token-interceptor.service';
import { TokeninterceptorService } from './tokenService/tokeninterceptor.service';
import { JwtHelperService } from '@auth0/angular-jwt';
import { JWT_OPTIONS } from '@auth0/angular-jwt';
import { ListproduitComponent } from './user/listproduit/listproduit.component';
import { ProduitComponent } from './user/produit/produit.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { ListProduitParCatComponent } from './user/list-produit-par-cat/list-produit-par-cat.component';
import { SeconnecterComponent } from './seconnecter/seconnecter.component';
import { NavallproduitComponent } from './navallproduit/navallproduit.component';
import { FilterPipe } from './user/recherche/pipe';
import { InscrireComponent } from './inscrire/inscrire.component';
import { AdminNavComponent } from './admin-nav/admin-nav.component';
import { AcceuilComponent } from './admin/acceuil/acceuil.component';
import { CommentaireComponent } from './admin/commentaire/commentaire.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatDialogModule} from '@angular/material/dialog';
import { WishlistComponent } from './wishlist/wishlist.component';
import { GererCompteComponent } from './gerer-compte/gerer-compte.component';
import { CommentaireUserListComponent } from './commentaire-user-list/commentaire-user-list.component';
import { UserNavigationComponent } from './user-navigation/user-navigation.component';
import { ListCommentaireComponent } from './list-commentaire/list-commentaire.component';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    ListproduitComponent,
    ProduitComponent,
    ListProduitParCatComponent,
    SeconnecterComponent,
    NavallproduitComponent,
    FilterPipe,
    InscrireComponent,
    AdminNavComponent,
    AcceuilComponent,
    CommentaireComponent,
    WishlistComponent,
    GererCompteComponent,
    CommentaireUserListComponent,
    UserNavigationComponent,
    ListCommentaireComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    NgxPaginationModule,
    BrowserAnimationsModule,
    MatDialogModule
    
  ],
  providers: [
    { provide: JWT_OPTIONS, useValue: JWT_OPTIONS },
    JwtHelperService
    //Token intercepter
    ,
    { provide: HTTP_INTERCEPTORS, useClass: TokeninterceptorService, multi: true },
    ListCommentaireComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
