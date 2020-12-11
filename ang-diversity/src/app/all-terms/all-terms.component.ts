import { Component, OnInit } from '@angular/core';
import { Term } from '../Term';
import { TermService } from '../term.service';

@Component({
  selector: 'app-all-terms',
  templateUrl: './all-terms.component.html',
  styleUrls: ['./all-terms.component.css']
})
export class AllTermsComponent implements OnInit {
  terms: Term[];

  constructor(private termService: TermService) { }

  ngOnInit(): void {
    this.getAllTerms();
  }

  getAllTerms(): void {
    this.termService.getAllTerms()
      .subscribe(allTerms => {
        this.terms = allTerms;
      });
  }
}
