import { Component, OnInit } from '@angular/core';
import {Vote} from "@/models/Vote";
import {ApiService} from "@services/api.service";

@Component({
  selector: 'app-list-votes',
  templateUrl: './list-votes.component.html',
  styleUrls: ['./list-votes.component.scss']
})
export class ListVotesComponent implements OnInit {
  elections = [
    {
      codeElection: 1,
      nomElection: "Election Présidentielle 2022",
    },
    {
      codeElection: 2,
      nomElection: "Election Municipales 2023",
    }
  ]

  search="";
  votes!: Vote[];

  codeElection : number;
  codeCandidat: number;
  codeParti: number;
  constructor(private voteService : ApiService) { }

  ngOnInit(): void {
    this.retrieveVotes();
  }

  retrieveVotes(): void {

    this.voteService.getVotes()
      .subscribe(
        (response : any )=> {
          this.votes = response.data.Votes;
        });
  }
}
