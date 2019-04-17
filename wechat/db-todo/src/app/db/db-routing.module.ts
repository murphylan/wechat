import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DbListComponent } from './db-list/db-list.component';
import { DbFormComponent } from './db-form/db-form.component';

const routes: Routes = [
  {
    path: '',
    data: {
      title: 'DB'
    },
    children: [
      {
        path: '',
        redirectTo: 'dblist'
      },
      {
        path: 'dblist',
        component: DbListComponent,
        data: {
          title: 'DbList'
        }
      },
      {
        path: 'dbform',
        component: DbFormComponent,
        data: {
          title: 'DbForm'
        }
      },
      {
        path: 'dbform/:id',
        component: DbFormComponent,
        data: {
          title: 'DbForm'
        }
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DbRoutingModule { }
