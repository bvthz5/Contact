import { Component, OnInit } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Obj } from '@popperjs/core';
import { ApiServiceService } from 'src/app/service/api-service.service';

@Component({
  selector: 'app-add-contact',
  templateUrl: './add-contact.component.html',
  styleUrls: ['./add-contact.component.css']
})
export class AddContactComponent implements OnInit {

  constructor(private service: ApiServiceService,private router :Router,private activatedRoute:ActivatedRoute) { }
  contactGroup!: FormGroup
   id:any
  contactDetails:any={

  }
  ngOnInit(): void {
  if(this.activatedRoute.snapshot.paramMap.get('id')!=null){
     this.id=this.activatedRoute.snapshot.paramMap.get('id')
    console.log(this.id);

    this.service.getContactDetails(this.id).subscribe({
      next: (response: any) => {

        console.log('Success', response);
        this.contactDetails=response
        this.contactGroup.patchValue(this.contactDetails)
      },
      error: (error: any) => {
        console.log('error', error);
      },
      complete: () => {
        console.log('Completed');
      },
    })
    console.log(this.contactDetails);


  }
  this.contactGroup = new FormGroup({
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('', Validators.required),
    nickName: new FormControl('', Validators.required),
    address: new FormControl('', Validators.required),
    dob: new FormControl('', Validators.required),
    city: new FormControl('', Validators.required),
    state: new FormControl('', Validators.required),
    country: new FormControl('', Validators.required),
    zipCode: new FormControl('', Validators.required),
    phones:new FormControl("",Validators.required),
    emails: new FormControl('', Validators.required),




  })


  }


  addContacts() {
    if (this.contactGroup.valid) {
      this.service.addContact(this.contactGroup.value).subscribe((response:any)=>{
        console.log(response);
        this.router.navigateByUrl("home")


      })
    }
  }
  updateContacts(contactId:any) {
    if (this.contactGroup.valid) {
      this.service.updateContact(this.contactGroup.value,contactId).subscribe((response:any)=>{
        console.log(response);
        this.router.navigateByUrl("home")


      })
    }
  }

}
