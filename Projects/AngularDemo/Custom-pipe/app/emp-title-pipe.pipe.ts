import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'empTitlePipe'
})
export class EmpTitlePipePipe implements PipeTransform {

  transform(value: String, gender: String): String {
    if(gender.toLowerCase() == "male"){
      return "Mr. "+ value;
    }
    else{
      return "Miss. "+ value;
    }
  }

}
