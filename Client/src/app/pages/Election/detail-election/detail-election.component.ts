import { Component, OnInit } from '@angular/core';
import {Election} from "@/models/Election";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {ApiService} from "@services/api.service";

@Component({
  selector: 'app-detail-election',
  templateUrl: './detail-election.component.html',
  styleUrls: ['./detail-election.component.scss']
})
export class DetailElectionComponent implements OnInit {

  election: Election = new Election();
  id!: number;
  constructor(private electionService: ApiService ,private route: ActivatedRoute,private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(
      (params: Params) => {
        this.id = params['id'];
      }
    );
    this.electionService.getElectionById(this.id).subscribe(
      (data : any) => {
        this.election = data.data.Election
      }
    );
  }
  deleteElection(id: number) {
    confirm("delete ?");
    this.electionService.deleteElection(id).subscribe({
      complete : () => {
        this.router.navigate(['/list-elections']);
      }
    });
  }

}
