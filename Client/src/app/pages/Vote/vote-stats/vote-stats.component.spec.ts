import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VoteStatsComponent } from './vote-stats.component';

describe('VoteStatsComponent', () => {
  let component: VoteStatsComponent;
  let fixture: ComponentFixture<VoteStatsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VoteStatsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VoteStatsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
