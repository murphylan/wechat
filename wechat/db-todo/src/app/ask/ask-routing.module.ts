import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AskListComponent, AskDetailComponent } from '.';
import { AskFormComponent } from './ask-form/ask-form.component';

const routes: Routes = [
  {
    path: '',
    data: {
      title: 'Ask'
    },
    children: [
      {
        path: '',
        redirectTo: 'asklist'
      },
      {
        path: 'asklist',
        component: AskListComponent,
        data: {
          title: 'AskList'
        }
      },
      {
        path: 'askdetail',
        component: AskDetailComponent,
        data: {
          title: 'AskDetail'
        }
      },
      {
        path: 'askform',
        component: AskFormComponent,
        data: {
          title: 'AskForm'
        }
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AskRoutingModule {}
