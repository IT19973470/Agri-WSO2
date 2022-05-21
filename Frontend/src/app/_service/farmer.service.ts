import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class FarmerService {

  item;

  constructor(private http: HttpClient) {
  }

  addItem(form, item): Observable<any> {
    return this.http.post<any>(environment.backend_url + "/farmer/addItem/" + item.description + "/" + item.price + "/" + item.qty + "/" + JSON.parse(localStorage.getItem('user')).email, form);
  }

  updateItem(item, itemId): Observable<any> {
    return this.http.put<any>(environment.backend_url + "/farmer/updateItem/" + itemId, item);
  }

  removeItem(itemId): Observable<any> {
    return this.http.delete<any>(environment.backend_url + "/farmer/removeItem/" + itemId);
  }

  getItems(): Observable<any> {
    return this.http.get<any>(environment.backend_url + "/farmer/getItems/" + JSON.parse(localStorage.getItem('user')).email);
  }
}
