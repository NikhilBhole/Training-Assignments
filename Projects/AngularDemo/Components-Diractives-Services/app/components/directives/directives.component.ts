import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {

  public displayName: boolean = true;
  public color: String = "red";
  public colors: String[] = ["red", "blue", "yallow", "green"];
  // @Input() public parentData: String = "";
  @Input("parentData") public name: String;
  @Output() public childEvent = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  fireEvent(){
    this.childEvent.emit("Hey Employees");
  }
}
