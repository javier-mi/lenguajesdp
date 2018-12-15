import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})
export class EquationsService {
  public API = '//localhost:8080';
  public EQUATION_API = this.API + '/equations';

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.API + '/equations');
  }
  
  get(id: string) {
    return this.http.get(this.EQUATION_API + '/' + id);
  }

  save(equation: any): Observable<any> {
    let result: Observable<Object>;
    if (equation['href']) {
      result = this.http.put(equation.href, equation);
    } else {
      result = this.http.post(this.EQUATION_API + '/save', equation);
    }
    return result;
  }

  remove(href: string) {
    return this.http.delete(href);
  }
}
