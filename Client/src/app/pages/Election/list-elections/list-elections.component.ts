import { Component, OnInit } from '@angular/core';
import {Election} from "@/models/Election";
import {Router} from "@angular/router";
import {ApiService} from "@services/api.service";

@Component({
  selector: 'app-list-elections',
  templateUrl: './list-elections.component.html',
  styleUrls: ['./list-elections.component.scss']
})
export class ListElectionsComponent implements OnInit {
  search="";
  // elections: Election[] = [
  //   {
  //     codeElection: 1,
  //     nomElection: "election1",
  //     typeElection: "type1",
  //     dateElection: null,
  //   },
  //   {
  //     codeElection: 2,
  //     nomElection: "election2",
  //     typeElection: "type2",
  //     dateElection: new Date(),
  //   }
  // ]
  elections!: Election[];
  allElections!: Election[];

  count = 0;
  offset = 1;
  pageSize = 5;
  field = '';
  pageSizes = [5,10,20];
  sortTypes = ['','codeElection','nomElection','typeElection'];

  constructor( private electionService: ApiService ,private router: Router) { }

  ngOnInit(): void {
    this.electionService.getElections().subscribe(
      (data) => {
        this.count = data.length;
        this.pageSizes.push(this.count);
      }
    );
    this.retrieveElections();
  }
  getRequestParams(offset: number, pageSize: number, field: string): any {
    let params: any = {};

    if (offset) {
      params[`offset`] = offset - 1;
    }
    if (pageSize) {
      params[`pageSize`] = pageSize;
    }
    if (field) {
      params[`field`] = field;
    }
    return params;
  }
  updateElection(id: number) {
    this.router.navigate(['/update-election',id]);
  }
  detailElection(id: number) {
    this.router.navigate(['/detail-election',id]);
  }
  deleteAllElection() {
    confirm("delete ?")
    this.electionService.deleteAllElections().subscribe({
      complete : () =>{
        this.router.navigate(['/']);
      }
    });
  }
  retrieveElections(): void {
    const params = this.getRequestParams(this.offset, this.pageSize, this.field);
    console.log(params);
    this.electionService.getAllElections(params)
      .subscribe(
        (response : any )=> {
          this.elections = response.data.Elections;
          // this.count = this.allElections.length;
          console.log(response.data.Elections);
        });
  }
  handlePageChange(event: number): void {
    this.offset = event;
    this.retrieveElections();
  }
  handlePageSizeChange(event: any): void {
    this.pageSize = event.target.value;
    this.offset = 1;
    this.retrieveElections();
  }
  sortBy(event: any) {
    this.field = event.target.value;
    this.offset = 1;
    this.retrieveElections();
  }
}
