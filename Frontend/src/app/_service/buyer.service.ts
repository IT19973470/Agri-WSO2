import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class BuyerService {

  cart;

  constructor(private http: HttpClient) {
  }

  getItems(txt): Observable<any> {
    return this.http.get<any>(environment.backend_url + "/buyer/getItems/" + txt);
  }

  getDeliveries(): Observable<any> {
    return this.http.get<any>(environment.backend_url + "/delivery/getDeliveries");
  }

  addToCart(cart) {
    return this.http.post<any>(environment.backend_url + "/buyer/addToCart", cart);
  }

  getCart() {
    return this.http.get<any>(environment.backend_url + "/buyer/getCart/" + JSON.parse(localStorage.getItem('user')).email);
  }

  addCart(cart) {
    return this.http.post<any>(environment.backend_url + "/buyer/addCart", cart)
  }

  removeItem(id) {
    return this.http.delete<any>(environment.backend_url + "/buyer/removeCartDetail/" + id)
  }
}
