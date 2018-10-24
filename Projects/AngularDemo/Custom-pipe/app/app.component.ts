import { Component } from '@angular/core';
import { IEmployee } from './IEmployee'
import { Employee } from './Employee'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'customPipeDemo';

  public employees: Employee[] = [
    {
      id: 1, name: 'Nikhil', gender: 'male', designation: 'SE'
    },
    {
      id: 2, name: 'Nayan', gender: 'male', designation: 'SE'
    },
    {
      id: 3, name: 'pooja', gender: 'female', designation: 'SE'
    },
  ];

  /*getEmployee(){
    this.employees: Employee[] = [
          {
          id: 1, name: 'Nikhil', gender: 'male', designation: 'SE'
        },
        {
          id: 2, name: 'Nayan', gender: 'male', designation: 'SE'
        },
        {
          id: 3, name: 'pooja', gender: 'female', designation: 'SE'
        },
        {
          id: 4, name: 'veronica', gender: 'female', designation: 'SE'
        },
        {
          id: 5, name: 'Sumit', gender: 'male', designation: 'SE'
        },
    ];*/
  }
