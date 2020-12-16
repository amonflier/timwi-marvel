import { Pipe, PipeTransform } from '@angular/core';
import { Character } from '../models/character';
import { SuperteamMember } from '../models/superteamMember';

@Pipe({
  name: 'superteam'
})
export class SuperteamPipe implements PipeTransform {

  transform(characters: Character[], superteam:SuperteamMember[]): Character[] {
    return characters && characters.length && superteam ? characters.filter(character => 
      superteam.find(superMember => superMember.id === character.id)
    ):[]
  }

}
