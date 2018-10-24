import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[appMyDirective]'
})
export class MyDirectiveDirective {

  constructor(private ref: ElementRef) { }

  @HostListener('click') handleClick(){

    
    const str = this.ref.nativeElement.innerText;
    if (str.length > 1) {
      this.ref.nativeElement.innerText =
        str.substring(0, str.length - 1);
        
    }

  }
}
