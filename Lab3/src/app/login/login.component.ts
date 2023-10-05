import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {AuthenticationService} from "../core/authentication.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  invalidLogin: boolean = false;
  constructor(private formBuilder: FormBuilder, private router: Router, private authenticateService: AuthenticationService) { }

  onSubmit() {
    if (this.loginForm.invalid) {
      return;
    }
    const loginPayload = {
      username: this.loginForm.controls['username'].value,
      password: this.loginForm.controls['password'].value
    }
    this.authenticateService.login(loginPayload).subscribe(data => {
        window.localStorage.setItem('token', data.result.token);
        this.router.navigateByUrl("admin");
      }, error => {
        this.invalidLogin = true;
        console.log(error.message);
      }
    );
  }

  ngOnInit() {
    if (window.localStorage.getItem('token') != null) {
      this.router.navigateByUrl("admin");
    }
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.compose([Validators.required])],
      password: ['', Validators.required]
    });
  }



}
