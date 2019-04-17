import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DbFormComponent } from './db-form.component';

describe('DbFormComponent', () => {
  let component: DbFormComponent;
  let fixture: ComponentFixture<DbFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DbFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DbFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
