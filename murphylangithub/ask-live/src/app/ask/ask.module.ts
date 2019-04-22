import { NgModule } from '@angular/core';
import { ButtonsModule } from 'ngx-bootstrap/buttons';
import { FormsModule } from '@angular/forms';
import { ChartsModule } from 'ng2-charts';
// Carousel Component
import { CarouselModule } from 'ngx-bootstrap/carousel';
import { AskRoutingModule } from './ask-routing.module';
import { AskDetailComponent } from './ask-detail/ask-detail.component';
import { AskListComponent } from '.';
import { AskFormComponent } from './ask-form/ask-form.component';

@NgModule({
  declarations: [
    AskDetailComponent, 
    AskListComponent, 
    AskFormComponent],
  imports: [
    FormsModule,
    AskRoutingModule,
    ChartsModule,
    ButtonsModule.forRoot(),
    CarouselModule.forRoot(),
  ]
})
export class AskModule { }
