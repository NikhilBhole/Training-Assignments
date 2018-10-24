import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-empcount',
  templateUrl: './empcount.component.html',
  styleUrls: ['./empcount.component.css']
})
export class EmpcountComponent implements OnInit {

  constructor() { }

  // @Input() For Parent To Chield

  @Input()
  all: number = 10;
  
  @Input()
  male: number = 5;
  
  @Input()
  female: number = 5;

/* */// For Chield to parent

  // Holds the selected value of the radio button
  selectedRadioButtonValue: string="All";
  
      // The Output decorator makes the property an Output property
      // EventEmitter class is used to create the custom event
      // When the radio button selection changes, the selected
      // radio button value which is a string gets passed to the
      // event handler method. Hence, the event payload is string.
      @Output()
      countRadioButtonSelectionChanged: EventEmitter<string> =
                                          new EventEmitter<string>();
  
      // This method raises the custom event. We will bind this
      // method to the change event of all the 3 radio buttons
      onRadioButtonSelectionChange() {
          this.countRadioButtonSelectionChanged
              .emit(this.selectedRadioButtonValue);
      }


  ngOnInit() {
  }

}
