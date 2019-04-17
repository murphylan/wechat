import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { switchMap } from 'rxjs/operators';
import { FormGroup, FormControl } from '@angular/forms';
import { DbService } from 'src/app/service/db.service';
import { DB } from 'src/app/model';

@Component({
  selector: 'app-db-form',
  templateUrl: './db-form.component.html',
  styleUrls: ['./db-form.component.scss']
})
export class DbFormComponent implements OnInit {
  currentDb: DB;
  profileForm = new FormGroup({
    tname: new FormControl(''),
    sql44: new FormControl(''),
    sql37: new FormControl(''),
    sql: new FormControl(''),
    status: new FormControl(''),
  });

  errMessage: string;

  constructor(private dbService: DbService,
    private route: ActivatedRoute,
    private router: Router, ) { }

  ngOnInit() {
    let id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.currentDb = this.dbService.getDbById(+id);
      this.profileForm.setValue(this.currentDb);
    }
  }

  onSubmit() {
    console.warn(this.profileForm.value);
    if (this.currentDb) { // update
      let newdb = this.profileForm.value;
      newdb.id = this.currentDb.id;
      this.dbService.editDb(newdb).subscribe(editDb => {
      }, error => {
        this.errMessage = error.message ? error.message : error.error.message;
      });
    } else { // insert
      this.dbService.addDb(this.profileForm.value).subscribe(addedDb => {
      }, error => {
        this.errMessage = error.message ? error.message : error.error.message;
      });
    }
    this.profileForm.reset();
  }

}
