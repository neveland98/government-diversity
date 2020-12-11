import { Component, OnInit } from '@angular/core';
import { Person } from '../Person';
import { PersonService } from '../person.service';


@Component({
  selector: 'app-all-people',
  templateUrl: './all-people.component.html',
  styleUrls: ['./all-people.component.css']
})
export class AllPeopleComponent implements OnInit {

  people: Person[];

  constructor(private personService: PersonService) { }

  ngOnInit(): void {
    this.getAllPeople();
  }

  getAllPeople(): void{
    this.personService.getAllPeople()
      .subscribe(allPeople => {
        this.people = allPeople;
      });
  }

}
