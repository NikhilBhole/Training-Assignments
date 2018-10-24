import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {
  public name: String = "Nikhil";
  public message: String = "Welcome Employees";
  public person = {
    "firstName": "Nikhil",
    "lastName": "Bhole"
  }
  public date = new Date();
  
  constructor() { }

  ngOnInit() {
  }

}
