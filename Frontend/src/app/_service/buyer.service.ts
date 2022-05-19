import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class BuyerService {

  constructor(private http: HttpClient) {
  }

  getItems(txt): Observable<any> {
    return this.http.get<any>(environment.backend_url + "/buyer/getItems/" + txt);
  }
}
