import { Component, OnInit } from '@angular/core';
import {LoginService} from "../../login.service";
import {environment} from "../../../environments/environment";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})

export class LoginComponent implements OnInit {

  constructor( private loginService: LoginService) { }

  ngOnInit(): void {
    console.log('-------------------------', environment.apiUrl);
  }

  login() {
    console.log('-------------------------', environment.apiUrl);
    this.loginService.login().subscribe(data => {
      // @ts-ignore
      this.createSession(data.token);
    })
  }

  createSession(token: string) {
    window.localStorage.setItem("token", token);
  }
}
