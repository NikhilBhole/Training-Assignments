import { Injectable } from '@angular/core';

@Injectable()
export class EmployeeService {

  constructor() { }

  getEmployees(){
      return [
      { "id": 1, "name": "Nikhil", "age": 26 },
      { "id": 2, "name": "Nayan", "age": 27 },
      { "id": 3, "name": "Sumit", "age": 25 },
      { "id": 4, "name": "Harshal", "age": 23 }
    ];
  }

}
