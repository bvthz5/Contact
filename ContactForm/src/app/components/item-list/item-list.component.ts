import { ItemComponent } from './../item/item.component';
import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ApiServiceService } from 'src/app/service/api-service.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {
  item:any;
  constructor(private service:ApiServiceService,private modalService:NgbModal) { }

  ngOnInit(): void {
    this.service.itemList().subscribe({
      next: (res: any) => {
        this.item = res;
        console.log(res)
      },
      error: (error: any) => console.log(error)

    });
  }
deleteItem(data:any){
  this.service.deleteitem(data).subscribe((res:any)=>{
    window.location.reload();
    console.log(res)
  })
}
openModal(itemId:any){
  const modalRef= this.modalService.open(ItemComponent)
  modalRef.componentInstance.itemId=itemId
}

}
