import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {

  constructor(private http:HttpClient) { }

  api_url="http://localhost:8080"
  header= new HttpHeaders()
  getData(){
    let token=localStorage.getItem('accessToken')
    console.log('accessToken',token);
    this.header=new HttpHeaders({
      'Content-Type':'application/json',
      'Authorization':'Contacts '+token

    })
    return this.http.get(this.api_url+"/contacts",{headers:this.header})
  }
  registerUser(data:any){
    this.header=new HttpHeaders({
      'Content-Type':'application/json',
    })
    return this.http.post(this.api_url+"/users",data,{headers:this.header})
  }
  loginUser(data:any){
    return this.http.post(this.api_url+"/login",data)
  }

  addContact(data:any){
    let token=localStorage.getItem('accessToken')
    console.log('accessToken',token);
    this.header=new HttpHeaders({
      'Content-Type':'application/json',
      'Authorization':'Contacts '+token

    })
    Object.assign(data, { "emails": [data.emails] });
    Object.assign(data, { "phones": [data.phones] });
    return this.http.post(this.api_url+"/contacts",data,{headers:this.header})
  }

  deleteContact(data:any){
    let token=localStorage.getItem('accessToken')
    console.log('accessToken',token);
    this.header=new HttpHeaders({
      'Content-Type':'application/json',
      'Authorization':'Contacts '+token

    })
    return this.http.delete(this.api_url+"/contacts/"+data,{headers:this.header})
  }

  getContactDetails(contactId:any){
    let token=localStorage.getItem('accessToken')
    console.log('accessToken',token);
    this.header=new HttpHeaders({
      'Content-Type':'application/json',
      'Authorization':'Contacts '+token

    })
    return this.http.get(this.api_url+"/contacts/"+contactId,{headers:this.header})
  }
  updateContact(data:any,contactId:any){
    let token=localStorage.getItem('accessToken')
    console.log('accessToken',token);
    this.header=new HttpHeaders({
      'Content-Type':'application/json',
      'Authorization':'Contacts '+token

    })
    Object.assign(data, { "emails": [data.emails] });
    Object.assign(data, { "phones": [data.phones] });
    return this.http.put(this.api_url+"/contacts/"+contactId,data,{headers:this.header})
  }


  itemdetails(id:any)
  {
    let token=localStorage.getItem('accessToken')
    console.log('accessToken',token);
    this.header=new HttpHeaders({
      'Content-Type':'application/json',
      'Authorization':'Contacts '+token

    })
    return this.http.get(this.api_url+"/item/"+id,{headers:this.header})

  }
  itemList() {
    const httpOptions = {
      headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': 'Contacts '+localStorage.getItem('accessToken')
  })}
  return this.http.get(this.api_url+'/item',httpOptions)

  }
   deleteitem(data:any){

    this.header=new HttpHeaders({
      'Content-Type':'application/json',
      'Authorization':'Contacts '+localStorage.getItem('accessToken')

    })
    return this.http.delete(this.api_url+'/item/'+data,{headers:this.header})
  }


   getItemDetails(id:any)
  {
    let token=localStorage.getItem('accessToken')
    console.log('accessToken',token);
    this.header=new HttpHeaders({
      'Content-Type':'application/json',
      'Authorization':'Contacts '+token

    })
    return this.http.get(this.api_url+"/item/"+id,{headers:this.header})

  }
  itemAdd(info: any): Observable<any> {
    this.header=new HttpHeaders({
       'content-type':'application/json',
       'Authorization':'Contacts '+localStorage.getItem('accessToken')
     })
   alert("Successfully Inserted");
   return this.http.post(this.api_url+'/item', info.value,{headers:this.header})

   }
  updateItem(data:any,itemId:any){
    let token=localStorage.getItem('accessToken')
    console.log('accessToken',token);
    this.header=new HttpHeaders({
      'Content-Type':'application/json',
      'Authorization':'Contacts '+token

    })

    return this.http.put(this.api_url+"/item/"+itemId,data,{headers:this.header})
  }
  

}









