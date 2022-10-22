import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from "rxjs";
import {Election} from "@/models/Election";
import {Vote} from "@/models/Vote";

@Injectable({
    providedIn: 'root'
})
export class ApiService {
    constructor(private http: HttpClient) {}

  //Election API
  private readonly electionURL = 'http://localhost:8082/evoting/election';
  private readonly voteURL = 'http://localhost:8083/evoting/vote';


  getElections(): Observable<Election[]> {
    return this.http.get<Election[]>(`${this.electionURL}/get-all`);
  }
  getAllElections(params: any): Observable<Election[]> {
    return this.http.get<Election[]>(`${this.electionURL}/get-paged-sorted`,{params});
  }
  getElectionById(id: number): Observable<Election> {
    return this.http.get<Election>(`${this.electionURL}/get/`+id);
  }
  addElection(election: Election): Observable<Election> {
    return this.http.post<Election>(`${this.electionURL}/add`, election);
  }
  deleteElection(id: number): Observable<Election> {
    return this.http.delete<Election>(`${this.electionURL}/delete/${id}`);
  }
  deleteAllElections(): Observable<Election> {
    return this.http.delete<Election>(`${this.electionURL}/delete-all`);
  }
  updateElection(election: Election): Observable<Election> {
    return this.http.put<Election>(`${this.electionURL}/update`, election);
  }
  //Vote API
  getVotes(): Observable<Vote[]> {
    return this.http.get<Vote[]>(`${this.voteURL}/get-all`);
  }
  addVote(vote: Vote): Observable<Vote> {
    return this.http.post<Vote>(`${this.voteURL}/add`, vote);
  }
  getVotesByCandidat(params : any): Observable<Map<String, number>> {
    return this.http.get<Map<String, number>>(`${this.voteURL}/get-all-filtered`,{params});
  }
}
