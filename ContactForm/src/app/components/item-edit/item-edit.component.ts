import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ApiServiceService } from 'src/app/service/api-service.service';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-item-edit',
  templateUrl: './item-edit.component.html',
  styleUrls: ['./item-edit.component.css']
})
export class ItemEditComponent implements OnInit {
  constructor(private service: ApiServiceService, private activatedRoute: ActivatedRoute,private router:Router) { }
  id: any;
  itemAdd!:FormGroup;
  itemDetails: any = {};
  ngOnInit(): void {
    if (this.activatedRoute.snapshot.paramMap.get('id') != null) {
      this.id = this.activatedRoute.snapshot.paramMap.get('id')
      console.log(this.id);

      this.service.getItemDetails(this.id).subscribe({
        next: (response: any) => {

          console.log('Success', response);
          this.itemDetails = response
          this.itemAdd.patchValue(this.itemDetails)
        },
        error: (error: any) => {
          console.log('error', error);
        }
      })
      console.log(this.itemDetails);


    }
    this.itemAdd = new FormGroup({
      name: new FormControl('',Validators.required),
      description: new FormControl('',Validators.required),
      type: new FormControl('',Validators.required)
    })

  }

  addItem() {
    console.log(this.itemAdd.value);
    this.service.itemAdd(this.itemAdd).subscribe({
      next: (res: any) => {
        console.log(res)
      this.router.navigateByUrl('items');
      },
      error: (error: any) => console.log(error)

    });
  }
updateItem(id:any){
  if (this.itemAdd.valid) {
    this.service.updateItem(this.itemAdd.value,id).subscribe((response:any)=>{
      console.log(response);
      this.router.navigateByUrl('items');
    })
  }
  }
 }




