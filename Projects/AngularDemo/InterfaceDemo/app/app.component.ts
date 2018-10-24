import { Component } from '@angular/core';
import { IEmployee } from './IEmployee'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'interfaceDemo';
  public employees: IEmployee[] = [
    {
      id: 1, name:  'Nikhil', designation: 'SE'
    },
    {
      id: 2, name:  'Sumit', designation: 'SE'
    },
    {
      id: 3, name:  'Nayan', designation: 'SE'
    },

  ];

  getEmployees(){

      this.employees = [
      {
        id: 1, name:  'Nikhil', designation: 'SE'
      },
      {
        id: 2, name:  'Sumit', designation: 'SE'
      },
      {
        id: 3, name:  'Nayan', designation: 'SE'
      },
      {
        id: 4, name:  'Harshal', designation: 'SE'
      },
      {
        id: 5, name:  'Santosh', designation: 'SE'
      },
    ];
  }

trackByEmployeeId(index: number, employee: IEmployee): number{
  return employee.id;
}





}
