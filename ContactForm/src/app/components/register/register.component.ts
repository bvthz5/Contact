import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ApiServiceService } from 'src/app/service/api-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private service:ApiServiceService,private router:Router) { }
  registerForm!:FormGroup
  ngOnInit(): void {
    if(localStorage.getItem("accessToken")!=null){
      this.router.navigateByUrl('/home')
    }
    this.registerForm=new FormGroup({
      name: new FormControl("",Validators.required),
      email: new FormControl('', [Validators.required,Validators.email]),
      password: new FormControl("", [Validators.required,Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/)])
    })
  }
  userRegister(){
    this.registerForm.markAllAsTouched()
    if(this.registerForm.valid){
    this.service.registerUser(this.registerForm.value).subscribe(res=>{
      console.log("Success",res)
      alert("Success")
      
      this.router.navigateByUrl("login")
    },
    error=>{
      console.log(error);
      alert("Registration Failed")

    }
    )
  }
  }
}
