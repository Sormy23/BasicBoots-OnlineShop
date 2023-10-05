import { Component } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {

  constructor(protected router: Router) {}

  ngOnInit() {
    if (window.localStorage.getItem('token') == null) {
      this.router.navigateByUrl("login");
    }
  }

  deleteToken() {
    window.localStorage.removeItem('token');
    this.router.navigateByUrl("login");
  }
}
