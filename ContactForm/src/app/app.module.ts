import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { RegisterComponent } from './components/register/register.component';
import { ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './components/login/login.component';
import { AddContactComponent } from './components/add-contact/add-contact.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ContactDetailsComponent } from './components/contact-details/contact-details.component';
import { ItemComponent } from './components/item/item.component';
import { ItemListComponent } from './components/item-list/item-list.component';
import { ItemEditComponent } from './components/item-edit/item-edit.component';
import { HeaderComponent } from './components/header/header.component';
import { UserprofileComponent } from './components/userprofile/userprofile.component';
import { IonicModule } from '@ionic/angular';
import { NgxPaginationModule } from 'ngx-pagination';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RegisterComponent,
    LoginComponent,
    AddContactComponent,
    ContactDetailsComponent,
    ItemComponent,
    ItemListComponent,

    ItemEditComponent,
     HeaderComponent,
     UserprofileComponent,




  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgbModule,
    IonicModule.forRoot(),
    NgxPaginationModule


  ],
  providers: [

  ],
  bootstrap: [AppComponent],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
})
export class AppModule { }
