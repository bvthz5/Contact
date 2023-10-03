import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ApiServiceService } from 'src/app/service/api-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private service: ApiServiceService,private router:Router) { }
  loginForm!: FormGroup
  ngOnInit(): void {
    if(localStorage.getItem("accessToken")!=null){
      this.router.navigateByUrl('/home')
    }
    this.loginForm = new FormGroup({

      email: new FormControl('', [Validators.required,Validators.email]),
      password: new FormControl("", [Validators.required,Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/)])
    })
  }
  userLogin() {
    this.loginForm.markAllAsTouched()
    if (this.loginForm.valid) {
     
      this.service.loginUser(this.loginForm.value).subscribe((response: any) => {
        console.log("Success", response.accessToken.value)
        alert("Successful")
        localStorage.setItem("accessToken",response.accessToken.value)
        this.router.navigateByUrl('/home')
      } ,
      (error:any)=>{
        console.log(error);
        alert("Login Failed")
        
      }
      )
      
    }

  }
}
