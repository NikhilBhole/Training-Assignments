import { Component, OnInit } from '@angular/core';

import { IEmployee } from '../IEmployee';
import { EmployeeServiceService } from '../employee-service.service';

@Component({
  selector: 'app-employeelist',
  templateUrl: './employeelist.component.html',
  styleUrls: ['./employeelist.component.css']
})
export class EmployeelistComponent implements OnInit {

  public employees : IEmployee[]; 

  constructor(private _employeeService: EmployeeServiceService) { }


  ngOnInit() {
    this._employeeService.getEmployees().subscribe(employeeData => this.employees = employeeData);
  }

}
