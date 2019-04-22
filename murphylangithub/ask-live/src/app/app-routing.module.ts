import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { DefaultLayoutComponent } from './default-layout/default-layout.component';
import { E404Component } from './error/e404/e404.component';
import { E500Component } from './error/e500/e500.component';
import { AuthGuard } from './guard';
import { TodoCalendarComponent } from './todo-calendar/todo-calendar.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'dashboard',
    pathMatch: 'full',
  },
  {
    path: '404',
    component: E404Component,
    data: {
      title: 'Page 404'
    }
  },
  {
    path: '500',
    component: E500Component,
    data: {
      title: 'Page 500'
    }
  },
  {
    path: 'login', component: LoginComponent
  },
  {
    path: '', component: DefaultLayoutComponent, canActivate: [AuthGuard],
    data: {
      title: 'Home'
    },
    children: [
      {
        path: 'dashboard',
        loadChildren: './dashboard/dashboard.module#DashboardModule'
      },
      {
        path: 'ask',
        loadChildren: './ask/ask.module#AskModule'
      },
      {
        path: 'db',
        loadChildren: './db/db.module#DbModule'
      },
      {
        path: 'calendar',
        component: TodoCalendarComponent
      },
    ]
  },
  { path: '**', component: E404Component }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
