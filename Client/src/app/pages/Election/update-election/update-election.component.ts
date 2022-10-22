import { Component, OnInit } from '@angular/core';
import {Election} from "@/models/Election";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {ApiService} from "@services/api.service";

@Component({
  selector: 'app-update-election',
  templateUrl: './update-election.component.html',
  styleUrls: ['./update-election.component.scss']
})
export class UpdateElectionComponent implements OnInit {

  election: Election = new Election();
  id!: number;
  updateForm!: FormGroup;
  typesElection: string[] = ["Présidentielle","Municipales","Régionales","Législatives"]

  constructor(private electionService: ApiService ,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    // create the form
    this.updateForm = new FormGroup({
      'electionData': new FormGroup({
        'codeElection': new FormControl(null, [Validators.required]),
        'nomElection': new FormControl(null, [Validators.required]),
        'typeElection': new FormControl("Choisir le type d'élection",[Validators.required]),
        'dateElection': new FormControl('',[Validators.required]),
      }),
    });
    // get the id from url
    this.route.params.subscribe(
      (params: Params) => {
        this.id = params['id'];
      }
    );
    // get that election and populate the form
    this.electionService.getElectionById(this.id).subscribe(
      (data : any) => {
        this.election = data.data.Election
        console.log(this.election.dateElection)
        this.updateForm.patchValue({
          'electionData': {
            'codeElection': this.election.codeElection,
            'nomElection': this.election.nomElection,
            'typeElection': this.election.typeElection,
            'dateElection': this.formatDate(this.election.dateElection),
          }
        });
      }
    );

  }
  updateElection() {
    // get new data from the form and send the request
    this.election.codeElection = this.updateForm.get('electionData.codeElection')?.value;
    this.election.nomElection = this.updateForm.get('electionData.nomElection')?.value;
    this.election.typeElection = this.updateForm.get('electionData.typeElection')?.value;
    this.election.dateElection = this.updateForm.get('electionData.dateElection')?.value;
    this.electionService.updateElection(this.election).subscribe({
    next : (data:any)=>{
      this.election = data.data.Election
    },
      complete : () =>{
        this.router.navigate(['/list-elections']);
      }
  });
  }
  onSubmit() {
    this.updateElection();
  }
  onReset() {
    this.router.navigate(['/list-elections']);
  }
  formatDate(date : Date) {
    const d = new Date(date);
    let month = '' + (d.getMonth() + 1);
    let day = '' + d.getDate();
    const year = d.getFullYear();
    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;
    return [year, month, day].join('-');
  }
}
