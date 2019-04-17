import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { DB } from '../model';
import { BehaviorSubject, Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DbService {

  baseUrl = environment.apiUrl;
  dbs: Array<DB>;
  dbsSubject: BehaviorSubject<Array<DB>>;
  configUrl = this.baseUrl + '/products';

  constructor(private http: HttpClient) {
    this.dbsSubject = new BehaviorSubject<Array<DB>>([]);
  }

  getDatabaseSchemas() {
    return this.http.get<Array<DB>>(this.configUrl).subscribe(response => {
      this.dbs = response;
      this.dbsSubject.next(this.dbs);
    }, error => {
      this.dbs = [];
      this.dbsSubject.next(this.dbs);
    });
  }

  getDbs(): BehaviorSubject<Array<DB>> {
    return this.dbsSubject;
  }

  addDb(db: DB): Observable<DB> {
    return this.http.post<DB>(this.configUrl, db).pipe(
      tap(
        response => {
          this.dbs.push(response);
          this.dbsSubject.next(this.dbs);
        }));
  }

  editDb(db: DB): Observable<DB> {
    return this.http.put<DB>(this.configUrl+`/${db.id}`, db).pipe(
      tap(
        editedDb => {
          const foundDb = this.dbs.find(cdb => cdb.id === editedDb.id);
          Object.assign(foundDb, editedDb);
          this.dbsSubject.next(this.dbs);
        }));
  }

  getDbById(id: Number): DB {
    return this.dbs.find(db => db.id == id);
  }

}
