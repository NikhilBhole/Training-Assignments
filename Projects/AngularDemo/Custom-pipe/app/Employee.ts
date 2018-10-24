import { IEmployee } from './IEmployee'

export class Employee implements IEmployee {

     constructor(public id: number, public name: String, public gender: String, public designation: String){}
}