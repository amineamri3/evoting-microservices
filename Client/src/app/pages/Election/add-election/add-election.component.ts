import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {Election} from "@/models/Election";
import {ApiService} from "@services/api.service";

@Component({
  selector: 'app-add-election',
  templateUrl: './add-election.component.html',
  styleUrls: ['./add-election.component.scss']
})
export class AddElectionComponent implements OnInit {

  typesElection: string[] = ["Présidentielle","Municipales","Régionales","Législatives"]
  addForm!: FormGroup;
  election: Election = new Election();
  elections: Election[] = [];
  constructor(private electionService: ApiService ,private router: Router) { }


  ngOnInit(): void {
    this.addForm = new FormGroup({
      'electionData': new FormGroup({
        'nomElection': new FormControl(null, [Validators.required]),
        'typeElection': new FormControl("Choisir le type d'élection",[Validators.required]),
        'dateElection': new FormControl('',[Validators.required]),
      }),
    });
  }
  addElection() {
    this.election.nomElection = this.addForm.get('electionData.nomElection')?.value;
    this.election.typeElection = this.addForm.get('electionData.typeElection')?.value;
    this.election.dateElection =  this.addForm.get('electionData.dateElection')?.value;
    console.log(this.election);
    this.electionService.addElection(this.election).subscribe({
      next: (data) => {
        console.log(data);
      },
      complete : () => {
        this.router.navigate(['/list-elections']);
      }

  });
  }
  onSubmit() {
    this.addElection();
    this.addForm.reset();
    // console.log(this.addForm);
  }
  onReset() {
    this.addForm.reset();
    this.router.navigate(['/list-elections']);
  }
}
