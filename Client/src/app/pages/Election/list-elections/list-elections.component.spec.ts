import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListElectionsComponent } from './list-elections.component';

describe('ListElectionsComponent', () => {
  let component: ListElectionsComponent;
  let fixture: ComponentFixture<ListElectionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListElectionsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListElectionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
