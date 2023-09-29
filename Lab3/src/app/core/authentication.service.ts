import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from "rxjs/index";
import {ApiResponse} from "../model/api.response";
import {AuthToken} from "../model/auth-token.model";
import {environment} from '../../environments/environment';

@Injectable()
export class AuthenticationService {

  constructor(private http: HttpClient) { }
  baseUrl = environment.apiUrl+'/token/generate-token';

  login(loginPayload: any) : Observable<ApiResponse<AuthToken>> {
    return this.http.post<ApiResponse<AuthToken>>(this.baseUrl, loginPayload);
  }
}
