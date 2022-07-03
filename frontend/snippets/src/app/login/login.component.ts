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
    console.log('Before login');
    this.loginService.login().subscribe(data => {
      console.log(data);
    })
    console.log('After login');
  }

}
