import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Term } from './Term';

@Injectable({
  providedIn: 'root'
})
export class TermService {

  private allTermsUrl = 'http://localhost:8080/api/diversity/allTerms';
  
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  constructor(private http: HttpClient) { }

  getAllTerms(): Observable<Term[]>{
    return this.http.get<Term[]>(this.allTermsUrl).pipe();
  }
}
