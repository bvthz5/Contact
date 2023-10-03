import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Obj } from '@popperjs/core';
import { ApiServiceService } from 'src/app/service/api-service.service';
@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})
export class ItemComponent implements OnInit {

  // constructor(private service: ApiServiceService) { }
  //    ngOnInit(): void {

  // }
  // itemAdd = new FormGroup({
  //   name: new FormControl(''),
  //   description: new FormControl(''),
  //   type: new FormControl('')
  // })


  // addItem() {
  //   console.log(this.itemAdd.value);
  //   this.service.itemAdd(this.itemAdd).subscribe({
  //     next: (res: any) => {
  //       console.log(res)
  //     },
  //     error: (error: any) => console.log(error)

  //   });
  // }



@Input()itemId:any;
itemDetails:any={};
  constructor(private service:ApiServiceService,public activeModal:NgbActiveModal) { }

  ngOnInit(): void {
    console.log(this.itemId);
        this.service.itemdetails(this.itemId).subscribe({
      next: (response: any) => {

        console.log('Success', response);
        this.itemDetails=response
      },
      error: (error: any) => {
        console.log('error', error);
      }
  });
  }
}














