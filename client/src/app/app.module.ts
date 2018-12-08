import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { EquationsComponent } from './equations/equations.component';
import { EquationsListComponent } from './equations-list/equations-list.component';

@NgModule({
  declarations: [
    AppComponent,
    EquationsComponent,
    EquationsListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
