import { Component, OnInit } from '@angular/core';
import {LoginService} from "../login.service";

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
      this.createCookie(data.token);
    })
  }

  createCookie(token: string) {
    const d = new Date();
    // After one day it will expire
    d.setTime(d.getTime() + (24*60*60*1000));
    let expires = "expires="+ d.toUTCString();
    document.cookie = "token" + "=" + token + ";" + expires + ";path=/";
  }
}
