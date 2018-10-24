import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public inputData: String = "Home";
  public greeting: String = "";
  public isDisabled: boolean = false;
  public successClass: String = "text-success";
  public hasError: boolean = true;
  public highlightedColor: String = "orange";
  public titleStyles = {
    color: "blue",
    fontStyle: "italic"
  }

  public isSpacial: boolean = true;
  public messageClasses = {
    "text-success": !this.hasError,
    "text-danger": this.hasError,
    "text-spacial": this.isSpacial
  }
  constructor() { }

  ngOnInit() {
  }

  onclick(event){
    console.log(event);
    this.greeting = event.type;
  }
  logMessage(value){
    console.log(value);
  }
}
