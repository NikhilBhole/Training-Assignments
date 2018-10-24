import { Component, OnInit } from '@angular/core';
import { IEmployee } from '../../IEmployee';

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {

  public employeeRecords: IEmployee[] = [
    {
      id:1, name: 'Nikhil', designation: 'software Engineer'
    },
    {
      id:2, name: 'Santosh', designation: 'software Engineer'
    },
    {
      id:3, name: 'Swaraj', designation: 'software Engineer'
    },
    {
      id:4, name: 'Akshay', designation: 'software Engineer'
    }  
  ];

  constructor() { }

  ngOnInit() {
  }

}
