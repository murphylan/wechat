import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AskDetailComponent } from './ask-detail.component';

describe('AskDetailComponent', () => {
  let component: AskDetailComponent;
  let fixture: ComponentFixture<AskDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AskDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AskDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
