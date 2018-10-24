import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'
import { AppComponent } from './app.component';
import { EmplistComponent } from './emplist/emplist.component';
import { EmpcountComponent } from './empcount/empcount.component';

@NgModule({
  declarations: [
    AppComponent,
    EmplistComponent,
    EmpcountComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
