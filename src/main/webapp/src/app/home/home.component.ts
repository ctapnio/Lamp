import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthService } from '../auth.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
	selector: 'app-home',
	templateUrl: './home.component.html',
	styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

	isLoggedIn = false;

	loggedInUser: string = '';

	greeting: any[] = [];

	constructor(private route: ActivatedRoute, private router: Router, private http: HttpClient, private authService: AuthService) { }

	ngOnInit() {
		this.isLoggedIn = this.authService.isUserLoggedIn();
		this.loggedInUser = this.authService.getLoggedInUser();

		if (!this.authService.isUserLoggedIn()) {
			this.router.navigateByUrl('login');
		}
	}

	doLogout() {
		this.authService.logout();
	}
	
	home(): void {
		this.router.navigateByUrl('home');
	}

}
