import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Request } from './request.model';
import { Router } from '@angular/router';

@Injectable({
	providedIn: 'root'
})
export class AuthService {

	private baseUrl = 'http://localhost:8080/api/auth';

	constructor(private router: Router, private http: HttpClient) { }

	login(request: Request): Observable<any> {
		return this.http.post<any>(this.baseUrl + '/login', request, { headers: new HttpHeaders({ 'Content-Type': 'application/json' }) }).pipe(map((resp) => {
			sessionStorage.setItem('user', request.username);
			sessionStorage.setItem('token', 'Bearer ' + resp.jwt);
			return resp;
		}));
	}

	register(request: Request): Observable<any> {
		return this.http.post<any>(this.baseUrl + '/register', request, { headers: new HttpHeaders({ 'Content-Type': 'application/json' }), responseType: 'text' as 'json' }).pipe(map((resp) => {
			return "User successfully registered";
		}));
	}

	logout() {
		sessionStorage.removeItem('user');
		sessionStorage.removeItem('token');

		this.router.navigateByUrl('login');
	}

	isUserLoggedIn() {
		return sessionStorage.getItem('token') !== null;
	}

	getLoggedInUser() {
		return sessionStorage.getItem('user') as string;
	}

	getToken() {
		let token = sessionStorage.getItem('token') as string;
		return token;
	}

}
