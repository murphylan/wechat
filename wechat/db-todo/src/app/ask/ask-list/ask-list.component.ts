import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ask-list',
  templateUrl: './ask-list.component.html',
  styleUrls: ['./ask-list.component.scss']
})
export class AskListComponent implements OnInit {

  constructor(private router: Router) {}

  ngOnInit() {}

  goToLink(link: string): void {
    this.router.navigateByUrl(link);
  }

}
