import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CharacterListComponent } from './character-list/character-list.component';
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator'


@NgModule({
  declarations: [CharacterListComponent],
  imports: [
    CommonModule,
    MatTableModule,
    MatPaginatorModule
  ]
})
export class CharacterListModule { }
