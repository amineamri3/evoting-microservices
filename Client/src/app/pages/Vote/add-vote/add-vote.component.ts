import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Vote} from "@/models/Vote";
import {Router} from "@angular/router";
import {ApiService} from "@services/api.service";

@Component({
  selector: 'app-add-vote',
  templateUrl: './add-vote.component.html',
  styleUrls: ['./add-vote.component.scss']
})
export class AddVoteComponent implements OnInit {
  // liste des elections où le user est inscrit
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
  // list all candidats
  candidats = [
    {
      codeCandidat: 1,
      nomCandidat: "Amine"
    },
    {
      codeCandidat: 2,
      nomCandidat: "Yassine"
    },
  ];
  // list all partis
  partis= [
    {
      codeParti: 1,
      nomParti: "Nidaa Tounes"
    },
    {
      codeParti: 2,
      nomParti: "Parti des travailleurs"
    },
  ];

  addForm!: FormGroup;
  vote: Vote = new Vote();
  disableParti : boolean = true;
  disableCandidat: boolean = true;
  constructor(private router: Router, private voteService: ApiService) { }

  ngOnInit(): void {
    this.addForm = new FormGroup({
      'voteData': new FormGroup({
        'election': new FormControl("Choisir l'élection désirée", [Validators.required]),
        'parti': new FormControl("Choisir une parti politique",[Validators.required]),
        'candidat': new FormControl("Choisir un candidat",[Validators.required]),
      }),
    });
  }
  addVote() {
    this.vote.nomElection = this.addForm.get('voteData.election')?.value;
    this.vote.nomParti = this.addForm.get('voteData.parti')?.value;
    this.vote.nomCandidat =  this.addForm.get('voteData.candidat')?.value;
    this.vote.codeElecteur = 1;
    this.vote.dateVote = new Date();
    console.log(this.vote);
    this.voteService.addVote(this.vote).subscribe({
      next: (data) => {
        console.log(data);
      },
      complete : () => {
        //supprimer l'inscription a cette election
        this.router.navigate(['/list-votes']);
      }

    });
  }
  onSubmit() {
    this.addVote();
    this.addForm.reset();
    // console.log(this.addForm);
  }
  onReset() {
    this.addForm.reset();
    this.router.navigate(['/list-votes']);
  }

  electionSelected(event: any){
    this.disableParti = false;
    console.log(event.target.value)
    //filtrer parti list pour afficher les parti inscrits a l'election choisi
  }
  partiSelected(event: any){
    this.disableCandidat = false;
    console.log(event.target.value)
    //filtrer candidat list pour afficher les candidat inscrits a la parti choisi

  }
}
