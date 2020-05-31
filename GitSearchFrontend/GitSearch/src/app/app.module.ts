import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from "@angular/common/http";


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import {SerchService} from "./serch.service";
import { DbinfoComponent } from './dbinfo/dbinfo.component';
import { ItemsComponent } from './items/items.component';
import { HeaderComponent } from './header/header.component'

@NgModule({
  declarations: [
    AppComponent,
    DbinfoComponent,
    ItemsComponent,
    HeaderComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [SerchService],
  bootstrap: [AppComponent]
})
export class AppModule { }
