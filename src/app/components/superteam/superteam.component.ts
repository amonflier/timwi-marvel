import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Character } from 'src/app/models/character';
import { CharacterService } from 'src/app/services/character.service';
import { SuperteamMember } from '../../models/superteamMember';

@Component({
  selector: 'app-superteam',
  templateUrl: './superteam.component.html',
  styleUrls: ['./superteam.component.css']
})

export class SuperteamComponent implements OnInit {
  characters: Observable<Character[]>
  superteam: Observable<SuperteamMember[]>

  constructor( private characterService: CharacterService ) { }

  ngOnInit(): void {
    this.characters=this.characterService.characters
    this.superteam=this.characterService.superteam
  }

  removeFromSuperteam(id: number): void{
    this.characterService.removeFromSuperteam(id)
    .subscribe({
      next : superMember=> this.superteam=this.characterService.superteam
    })
  }

}
