import { Component, OnInit } from '@angular/core';
import { Person } from '../Person';

@Component({
  selector: 'app-all-people',
  templateUrl: './all-people.component.html',
  styleUrls: ['./all-people.component.css']
})
export class AllPeopleComponent implements OnInit {

  person: Person = {
    id:1,
    firstName:'Joe',
    lastName:'Aitken',
    birthYear: 1997,
    gender: 'M',
    race: 'WHITE',
    party: 'INDEPENDENT'
  }
  
  constructor() { }

  ngOnInit(): void {
  }

}
