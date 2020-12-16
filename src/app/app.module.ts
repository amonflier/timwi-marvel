import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CharacterListModule } from './components/character-list.module';

import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import { SuperteamComponent } from './components/superteam/superteam.component';
import { SuperteamPipe } from './pipes/superteam.pipe';

@NgModule({
  declarations: [
    AppComponent,
    SuperteamComponent,
    SuperteamPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CharacterListModule,
    HttpClientModule,
    MatButtonModule,
    MatToolbarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
