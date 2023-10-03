import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApiServiceService } from 'src/app/service/api-service.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { ContactDetailsComponent } from '../contact-details/contact-details.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {

  constructor(private service:ApiServiceService,private router:Router,private modalService: NgbModal) { }
  contactData:any=[]
  contacts:any;
  p:number=1;
  total: number =0;
  ngOnInit(): void {


    this.service.getData().subscribe((data:any)=>{
      console.log(data)
      this.contactData=data
    })
  }
  logOut(){
    localStorage.removeItem("accessToken")
    this.router.navigateByUrl("/login")


  }

  onDelete(data :any){
    this.service.deleteContact(data).subscribe((res:any)=>{
      alert("Deleted Successfully")
      window.location.reload();
      console.log(res)

    })
  }

  openModal(contactId:any){
    const modalRef= this.modalService.open(ContactDetailsComponent)
    modalRef.componentInstance.contactId=contactId
  }



}


