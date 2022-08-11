import {Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {MatSort} from "@angular/material/sort";
import {MatTableDataSource} from "@angular/material/table";


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  name: any = '';
  snippets: any = []

  displayedColumns = ['category', 'language', 'text'];
  dataSource = new MatTableDataSource(this.snippets);

  constructor(private http: HttpClient) { }

  getDataFromJWT(token: any) {
      let base64Url = token.split('.')[1];
      let base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
      let jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
      }).join(''));

      return JSON.parse(jsonPayload);
  }

  ngOnInit(): void {
    const token = localStorage.getItem('token');
    if(token) {
      this.name = this.getDataFromJWT(token).name;

      const headers = { 'Authorization': `Bearer ${token}`, "Access-Control-Allow-Origin": "*"}

      const url = 'http://localhost:1337/api/snippets/username/' + this.name;

      this.http.get(url, {headers: headers}).subscribe(res => {
        this.snippets = res;
      });
    }
  }

}

export interface Element {
  text: string;
  category: number;
  language: number;
}
