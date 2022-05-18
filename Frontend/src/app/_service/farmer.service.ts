import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class FarmerService {

  constructor(private http: HttpClient) {
  }

  addItem(item): Observable<any> {
    return this.http.post<any>(environment.backend_url + "/farmer/addItem", item);
  }
}
