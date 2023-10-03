import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddContactComponent } from './components/add-contact/add-contact.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { AuthGuard } from './service/auth.guard';
import { ItemComponent } from './components/item/item.component';
import { ItemListComponent } from './components/item-list/item-list.component';
import { ItemEditComponent } from './components/item-edit/item-edit.component';

const routes: Routes = [
  {path:"",redirectTo:"login",pathMatch:"full"},
  { path: "register", component: RegisterComponent,pathMatch:"full",},
  { path: "login", component: LoginComponent,pathMatch:"full"},
  {path:"home",component:HomeComponent,pathMatch:"full" ,canActivate:[AuthGuard]},
  {path:"addContact",component:AddContactComponent,pathMatch:"full" ,canActivate:[AuthGuard]},
  {path:"addContact/:id",component:AddContactComponent,pathMatch:"full" ,canActivate:[AuthGuard]},
  {path:"item",component:ItemEditComponent,pathMatch:"full" ,canActivate:[AuthGuard]},
  {path:"item/:id",component:ItemEditComponent,pathMatch:"full" ,canActivate:[AuthGuard]},

  {path:"items",component:ItemListComponent,pathMatch:"full" ,canActivate:[AuthGuard]}



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
