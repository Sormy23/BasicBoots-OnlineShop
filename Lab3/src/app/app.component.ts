import { Component } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Lab3';

  getURL() {
    return this.router.url;
  }

  constructor(private router: Router) {
  }

  protected readonly console = console;
}
