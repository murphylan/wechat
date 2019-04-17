import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ChartsModule } from 'ng2-charts/ng2-charts';
import { ButtonsModule } from 'ngx-bootstrap/buttons';
import { DbListComponent } from './db-list/db-list.component';
import { DbRoutingModule } from './db-routing.module';
import { DbFormComponent } from './db-form/db-form.component';

@NgModule({
  declarations: [DbListComponent, DbFormComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    ButtonsModule,
    ChartsModule,
    DbRoutingModule
  ]
})
export class DbModule { }
