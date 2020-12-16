import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CharacterListComponent } from './components/character-list/character-list.component'
import { SuperteamComponent } from './components/superteam/superteam.component';

const routes: Routes = [
  {path: 'api/characters', component: CharacterListComponent},
  {path: 'api/superteam', component : SuperteamComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
