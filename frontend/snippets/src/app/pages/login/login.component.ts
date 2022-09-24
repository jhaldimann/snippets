import { Component, OnInit } from '@angular/core';
import {LoginService} from "../../login.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})


export class LoginComponent implements OnInit {

  constructor( private loginService: LoginService) { }



  ngOnInit(): void {
  }

  login() {
    this.loginService.login().subscribe(data => {
      // @ts-ignore
      this.createSession(data.token);
    })
  }

  createSession(token: string) {
    window.localStorage.setItem("token", token);
  }
}
