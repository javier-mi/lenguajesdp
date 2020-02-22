import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})
export class EquationsService {
  public API = '//localhost:8080';
  public EQUATION_API = this.API + '';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.EQUATION_API + '/getAll');
  }
  
  get(id: string) {
    return this.http.get(this.EQUATION_API + '/get/' + id);
  }

  save(equation: any): Observable<any> {
    let result: Observable<any>;
    return this.http.post(this.EQUATION_API + '/save', equation);
  }

  remove(id: number) : Observable<any> {
    return this.http.delete(this.EQUATION_API + '/delete/' + id);
  }
}
