import {Component, Input, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {getDataFromJWT} from "../../utils/jwt";

@Component({
  selector: 'app-new-snippet',
  templateUrl: './new-snippet.component.html',
  styleUrls: ['./new-snippet.component.scss']
})
export class NewSnippetComponent implements OnInit {

  name: any = '';
  snippets: any = []

  @Input() text: string = '';
  @Input() category: string = '';
  @Input() language: string = '';

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  createNewSnippet(): void {
    const token = localStorage.getItem('token');
    if(token) {
      this.name = getDataFromJWT(token).name;

      const headers = { 'Authorization': `Bearer ${token}`, "Access-Control-Allow-Origin": "*"}

      const url = 'http://localhost:1337/api/snippets/';

      this.http.post(url, {
        'text': this.text,
        'category': this.category,
        'language': this.language,
        'username': this.name
      } ,{headers: headers}).subscribe(res => {
        this.text = '';
        this.category = '';
        this.language = '';
      });
    }
  }
}
