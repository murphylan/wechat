import { Component, OnInit } from '@angular/core';
import { DbService } from 'src/app/service/db.service';
import { DB } from 'src/app/model';

@Component({
  selector: 'app-db-list',
  templateUrl: './db-list.component.html',
  styleUrls: ['./db-list.component.scss']
})
export class DbListComponent implements OnInit {

  dbs: Array<DB>;
  errorMessage: string;

  constructor(private dbService: DbService) {
    this.dbService.getDatabaseSchemas();
  }

  ngOnInit() {
    this.dbService.getDbs().subscribe(res => {
      this.dbs = res;
    },
      error => {
        this.errorMessage = error.message;
      });
  }
}
