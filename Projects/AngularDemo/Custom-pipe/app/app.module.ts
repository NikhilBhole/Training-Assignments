import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { EmpTitlePipePipe } from './emp-title-pipe.pipe';

@NgModule({
  declarations: [
    AppComponent,
    EmpTitlePipePipe
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
