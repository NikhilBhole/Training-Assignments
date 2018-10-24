import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'validationDemo';
  formdata;

  ngOnInit() {
     this.formdata = new FormGroup({
        uname: new FormControl("", Validators.compose([
           Validators.required,
           Validators.minLength(6)
        ])),
        passwd: new FormControl("", this.passwordvalidation)
     });
  }
  
  passwordvalidation(formcontrol) {
     if (formcontrol.value.length < 5) {
        return {"passwd" : true};
     }
  }
  
  onClickSubmit(data) {
     console.log(data.uname);
     if (data.uname=="systemadmin" && data.passwd=="admin123") {
        alert("Login Successful");
        
      //  this.router.navigate(['app-mainpage'])
     } else {
        alert("Invalid Login");
        return false;
     }
    }

}
