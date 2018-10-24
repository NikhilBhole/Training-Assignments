import { Injectable } from '@angular/core';

import { IEmployee } from './IEmployee';

import { Http, Response, RequestOptions, Headers } from '@angular/http';

import { Observable } from "rxjs/internal/Observable";

import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {

  option: RequestOptions;
  headers: Headers;
  constructor(private _http: Http) { 
    this.headers = new Headers();
    this.headers.append('Access-Control-Allow-Origin', 'http://localhost:4200');
    let option = new RequestOptions({headers: this.headers});
  }

  getEmployees(): Observable<IEmployee[]>{

    return this._http.get('http://localhost:8080/restwebservicesdemo/employee/employees.ds',this.option).pipe(
    map((response: Response) => <IEmployee[]>response.json()));

  }

  addEmployee(employee: IEmployee){
    this._http.post('http://localhost:8080/restwebservicesdemo/employee/add.ds', employee, this.option);
  }

}
