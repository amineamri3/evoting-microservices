import { Component, OnInit } from '@angular/core';
import {ApiService} from "@services/api.service";
import Chart, {ChartConfiguration} from "chart.js/auto";
import {ActivatedRoute, Params} from "@angular/router";
@Component({
  selector: 'app-vote-stats',
  templateUrl: './vote-stats.component.html',
  styleUrls: ['./vote-stats.component.scss']
})
export class VoteStatsComponent implements OnInit {
  chartData!: Map<String, number>;
  candidatsNames: any = [];
  nbrVotes: number[] = [];
  pieChart: any = [];
  nomElection: string;
  resultStatus : boolean = true;

  constructor(private voteService : ApiService,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(
      (params: Params) => {
        this.nomElection = params['nomElection'];
      }
    );
    const params = this.getRequestParams(this.nomElection);
    this.voteService.getVotesByCandidat(params).subscribe(
      {
        next : (data: any) => {
          this.chartData = data.data.Stats
          for (let key in this.chartData) {
            if ( !this.chartData.hasOwnProperty(key)) {
              continue;
            }
            this.candidatsNames.push(key);
            // @ts-ignore
            this.nbrVotes.push(this.chartData[key]);
          }
          let configData = {
            labels: this.candidatsNames,
            datasets: [{
              label: 'Nombre des Votes',
              data: this.nbrVotes,
              backgroundColor: [
                'rgba(13,100,215,0.92)',
                'rgba(154,29,29,0.85)',
                'rgba(83,27,197,0.78)',
                'rgba(23,114,7,0.67)',
                'rgba(255,134,10,0.87)',
                'rgba(60,253,253,0.62)',
                'rgba(245,214,120,0.86)',
                'rgba(54,225,13,0.72)',
              ],
              hoverBackgroundColor: [
                'rgba(13,100,215,0.5)',
                'rgba(154,29,29,0.5)',
                'rgba(83,27,197,0.5)',
                'rgba(23,114,7,0.5)',
                'rgba(255,134,10,0.5)',
                'rgba(60,253,253,0.5)',
                'rgba(245,214,120,0.5)',
                'rgba(54,225,13,0.5)',
              ],
              borderColor: [
                'rgb(13,100,215)',
                'rgb(154,29,29)',
                'rgb(83,27,197)',
                'rgb(23,114,7)',
                'rgb(255,134,10)',
                'rgb(60,253,253)',
                'rgb(245,214,120)',
                'rgb(54,225,13)',
              ],
              borderWidth: 1
            }]
          };
          this.pieChart = new Chart('piechart', {
            type: "pie",
            data : configData,
            options: {
              responsive: true,
              maintainAspectRatio: false
            }
          });
        },
        complete : () => {
          this.resultStatus = this.candidatsNames.length != 0;
        }
      }
    )
  }
  getRequestParams(nomElection : string): any {
    let params: any = {};

    if (nomElection) {
      params[`nomElection`] = nomElection;
    }
    return params;
  }
}
