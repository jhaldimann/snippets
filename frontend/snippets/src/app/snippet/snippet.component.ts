import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-snippet',
  templateUrl: './snippet.component.html',
  styleUrls: ['./snippet.component.scss']
})
export class SnippetComponent implements OnInit {

  @Input()
  text: string = '';

  @Input()
  category: string = '';

  @Input()
  language: string = '';

  constructor() {
  }

  ngOnInit(): void {
  }

}
