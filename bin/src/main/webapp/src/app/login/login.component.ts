import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from '../auth.service';
import { Request } from '../request.model';

@Component({
selector: 'app-login',
templateUrl: './login.component.html',
styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

	username: string = '';
	password : string = '';

	isSignedin = false;

	error: string = '';

	constructor(private route: ActivatedRoute, private router: Router, private authService: AuthService) {}

	ngOnInit() {
		this.isSignedin = this.authService.isUserLoggedIn();

		if(this.isSignedin) {
			this.router.navigateByUrl('home');
		}
	}

	doLogin() {
		if(this.username !== '' && this.username !== null && this.password !== '' && this.password !== null) {
			const request: Request = { username: this.username, password: this.password};

			this.authService.login(request).subscribe((result)=> {
				//this.router.navigate(['/home']);
				this.router.navigateByUrl('home');
			}, () => {
				this.error = 'Either invalid credentials or something went wrong';
			});
		} else {
			this.error = 'Invalid Credentials';
		}
	}

}
