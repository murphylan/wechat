import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AskFormComponent } from './ask-form.component';

describe('AskFormComponent', () => {
  let component: AskFormComponent;
  let fixture: ComponentFixture<AskFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AskFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AskFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
