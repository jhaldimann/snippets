import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  loginUrl = 'http://localhost:1337/token'
  constructor(private http: HttpClient) { }

  login(){
    return this.http.get(this.loginUrl)
  }
}
