import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class LoginService {


  loginUrl = `http://${environment.apiUrl}:1337/token`
  constructor(private http: HttpClient) { }

  authenticateUser(user: string, password: string) {

    return "Basic " + btoa(user + ":" + password);
  }

  login() {

    console.log(environment.apiUrl)
    let username = (<HTMLInputElement>document.querySelector("#username")).value;
    let password = (<HTMLInputElement>document.querySelector("#password")).value;

    const headers = { 'Authorization': this.authenticateUser(username, password), "Access-Control-Allow-Origin": "*"}
    return this.http.post(this.loginUrl, null , {'headers':headers});
  }
}
