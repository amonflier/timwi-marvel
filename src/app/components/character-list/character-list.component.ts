import { Component, OnInit, ViewChild } from '@angular/core';
import { Character } from '../../models/character';
import { CharacterService } from '../../services/character.service';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-character-list',
  templateUrl: './character-list.component.html',
  styleUrls: ['./character-list.component.css'],
  providers: [CharacterService]
})

export class CharacterListComponent implements OnInit {
  characters: Character[]
  dataSource: MatTableDataSource<Character>;
  displayedColumns = [ "id", "name", "thumbnail", "description", "superteam"]

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor( private characterService: CharacterService  ) { }

  ngOnInit(): void {
    this.characterService.characters
    .subscribe(characters =>{
      this.dataSource=new MatTableDataSource(characters as Character[])
    })
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  addToSuperteam(id: number): void{
    this.characterService.addToSuperteam(id)
    .subscribe({
      next : superMember => alert("Character added to Superteam.")
    })
  }

}
