import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'snippets';

  isTokenAvailable() : Boolean {
    return window?.localStorage?.getItem('token') !== null;
  }
}
