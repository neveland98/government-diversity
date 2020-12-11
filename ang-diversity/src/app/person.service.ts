import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Person } from './Person';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PersonService {
  private allPeopleUrl = 'http://localhost:8080/api/diversity/allPeople';
  
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  constructor(private http: HttpClient) { }

  getAllPeople(): Observable<Person[]>{
    return this.http.get<Person[]>(this.allPeopleUrl).pipe();
  }
}
