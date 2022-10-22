import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailElectionComponent } from './detail-election.component';

describe('DetailElectionComponent', () => {
  let component: DetailElectionComponent;
  let fixture: ComponentFixture<DetailElectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailElectionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetailElectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
