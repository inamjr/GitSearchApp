import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Stats } from './common/stats';

@Injectable({
  providedIn: 'root',
})
export class SerchService {
  private BackendUrl = 'http://localhost:8080/stats';
  constructor(private http: HttpClient) {}

  getStat(): Observable<any> {
    const url =
      'https://api.github.com/search/repositories?q=is:public%20project%20in:name%20language:python%20stars:%3E=500';
    return this.http.get<any>(url).pipe(map((response) => response.items));
  }
  getdbInfo(): Promise<Stats[]> {
    return this.http.get<Stats[]>(`${this.BackendUrl}`).toPromise();
  }
}
