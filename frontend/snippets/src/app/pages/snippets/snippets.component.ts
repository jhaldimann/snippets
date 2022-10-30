import { Component, OnInit } from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {HttpClient} from "@angular/common/http";
import {getDataFromJWT} from "../../utils/jwt";

@Component({
  selector: 'app-snippets',
  templateUrl: './snippets.component.html',
  styleUrls: ['./snippets.component.scss']
})
export class SnippetsComponent implements OnInit {

  name: any = '';
  snippets: any = []

  displayedColumns = ['category', 'language', 'text'];
  dataSource = new MatTableDataSource(this.snippets);

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    const token = localStorage.getItem('token');
    if(token) {
      this.name = getDataFromJWT(token).name;

      const headers = { 'Authorization': `Bearer ${token}`, "Access-Control-Allow-Origin": "*"}

      const url = 'http://localhost:1337/api/snippets/username/' + this.name;

      this.http.get(url, {headers: headers}).subscribe(res => {
        this.snippets = res;
        this.dataSource = new MatTableDataSource(this.snippets);
      });
    }
  }
}

export interface Element {
  text: string;
  category: number;
  language: number;
}

