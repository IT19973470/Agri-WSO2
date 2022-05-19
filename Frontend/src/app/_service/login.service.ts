import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  accLogin(user): Observable<any> {
    return this.http.post<any>(environment.backend_url + "/user/login", user);
  }

  signUp(user): Observable<any> {
    return this.http.post<any>(environment.backend_url + "/user/signUp", user);
  }

  accLogout() {
    // this.navBarService.logged = false;
    localStorage.clear();
  }
}
