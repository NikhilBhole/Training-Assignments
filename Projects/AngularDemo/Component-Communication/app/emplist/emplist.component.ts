import { Component, OnInit } from '@angular/core';
import { IEmployee } from '../IEmployee'

@Component({
  selector: 'app-emplist',
  templateUrl: './emplist.component.html',
  styleUrls: ['./emplist.component.css']
})
export class EmplistComponent implements OnInit {

  employeeList: IEmployee[];

  // This property keeps track of which radio button is selected
    // We have set the default value to All, so all the employees
    // are displayed in the table by default
    //selectedEmployeeCountRadioButton: string = 'All';
    
      constructor() {
          this.employeeList = [
              {
                  code: 'emp101', name: 'Tom', gender: 'Male',
                  annualSalary: 5500, dateOfBirth: '6/25/1988'
              },
              {
                  code: 'emp102', name: 'Alex', gender: 'Male',
                  annualSalary: 5700.95, dateOfBirth: '9/6/1982'
              },
              {
                  code: 'emp103', name: 'Mary', gender: 'Female',
                  annualSalary: 6500.826, dateOfBirth: '10/14/1980'
              },
              
          ];
      }
      getEmployees(): void {
        this.employeeList = [
            {
                code: 'emp101', name: 'Tom', gender: 'Male',
                annualSalary: 5500, dateOfBirth: '2/6/1988'
            },
            {
                code: 'emp102', name: 'Alex', gender: 'Male',
                annualSalary: 5700.95, dateOfBirth: '9/6/1982'
            },
            {
                code: 'emp103', name: 'Mary', gender: 'Female',
                annualSalary: 6500.826, dateOfBirth: '10/14/1980'
            },
            {
                code: 'emp104', name: 'John', gender: 'Male',
                annualSalary: 6500.826, dateOfBirth: '4/10/1980'
            },
            {
                code: 'emp105', name: 'Nancy', gender: 'Female',
                annualSalary: 6700.826, dateOfBirth: '5/12/1982'
            },
            
        ];
      }
      // For Parent To Chield
    /*  */
    getTotalEmployeesCount(): number {
        return this.employeeList.length;
    }

    getMaleEmployeesCount(): number {
        return this.employeeList.filter(e => e.gender === 'Male').length;
    }

    getFemaleEmployeesCount(): number {
        return this.employeeList.filter(e => e.gender === 'Female').length;
    }
  /* */

 // For chield to parent
 /* */
     // This property keeps track of which radio button is selected
    // We have set the default value to All, so all the employees
    // are displayed in the table by default
    selectedEmployeeCountRadioButton: string = 'All';
    
    
     // Depending on which radio button is selected, this method updates
    // selectedEmployeeCountRadioButton property declared above
    // This method is called when the child component (EmployeeCountComponent)
    // raises the custom event - countRadioButtonSelectionChanged
    // The event binding is specified in employeeList.component.html
    onEmployeeCountRadioButtonChange(selectedRadioButtonValue: string): void {
        this.selectedEmployeeCountRadioButton = selectedRadioButtonValue;
    }


  ngOnInit() {
  }

}
