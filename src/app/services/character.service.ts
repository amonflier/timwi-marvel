import { Injectable } from '@angular/core'
import {Character } from '../models/character'
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SuperteamMember } from '../models/superteamMember';

@Injectable({
  providedIn: 'root'
})
export class CharacterService {
  private apiUrl ='http://localhost:3000/'

  constructor(private http: HttpClient) { }

  get characters(): Observable<Character[]>{
    return this.http.get<Character[]>(this.apiUrl + 'results')
  }

  get superteam(): Observable<SuperteamMember[]>{
    return this.http.get<SuperteamMember[]>(this.apiUrl + 'superteam')
  }

  addToSuperteam(id:number):Observable<SuperteamMember>{
    return this.http.post<SuperteamMember>(this.apiUrl + 'superteam', new SuperteamMember(id))
  }

  removeFromSuperteam(id:number):Observable<SuperteamMember>{
    return this.http.delete<SuperteamMember>(this.apiUrl + 'superteam/' + id)
  }
}