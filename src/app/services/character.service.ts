import { Injectable } from '@angular/core'
import {Character } from '../models/character'
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CharacterService {
  private apiUrl ='http://localhost:8090/api/'

  private httpOptions = {
    headers: new HttpHeaders({ 
      'Access-Control-Allow-Origin':'*',
      'mon-entete-personnalise':'maValeur'
    })
  };

  constructor(private http: HttpClient) { }

  get characters(): Observable<Character[]>{
    console.log('getCharacters')
    return this.http.get<Character[]>(this.apiUrl + 'characters')
  }

  get superteam(): Observable<Character[]>{
    return this.http.get<Character[]>(this.apiUrl + 'superteam')
  }

  addToSuperteam(id:number){
    return this.http.get(this.apiUrl + 'superteam/add/' + id)
  }

  removeFromSuperteam(id:number){
    return this.http.get(this.apiUrl + 'superteam/delete/' + id)
  }
}