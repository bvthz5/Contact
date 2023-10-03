import { Component, Input, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ApiServiceService } from 'src/app/service/api-service.service';

@Component({
  selector: 'app-contact-details',
  templateUrl: './contact-details.component.html',
  styleUrls: ['./contact-details.component.css']
})
export class ContactDetailsComponent implements OnInit {

  constructor(private service:ApiServiceService,public activeModal: NgbActiveModal) { }
  @Input() contactId:any
  contactDetails:any={}
 

  ngOnInit(): void {
    

    console.log(this.contactId);
    this.service.getContactDetails(this.contactId).subscribe({
      next: (response: any) => {
        console.log('Success', response);
        this.contactDetails=response
        const dob = new Date(this.contactDetails.dob);
        const dobDiffage = Math.abs(Date.now() - dob.getTime() );
        this.contactDetails.age = Math.floor((dobDiffage / (1000 * 3600 * 24)) / 365);
        // let timeDiff = Math.abs(Date.now() - this.contactDetails.dob.getTime());
        // let age = Math.floor((timeDiff / (1000 * 3600 * 24))/365.25);
        // console.log(age)
        
      },
      error: (error: any) => {
        console.log('error', error);
      },
      complete: () => {
        console.log('Completed');
      },
    });


  }
  



}
