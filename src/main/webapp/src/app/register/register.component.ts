import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Request } from '../request.model';

@Component({
	selector: 'app-register',
	templateUrl: './register.component.html',
	styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

	constructor(private authService: AuthService) { }

	username: string = '';
	password: string = '';

	error: string = '';
	success: string = '';

	ngOnInit(): void {
	}

	doRegister() {
		if (this.username !== '' && this.username !== null && this.password !== '' && this.password !== null) {
			const request: Request = { username: this.username, password: this.password };

			this.authService.register(request).subscribe((result) => {
				this.success = result;
			}, (err) => {
				console.log(err);
				this.error = `${err.name}: Username already in use.`;
			});
		} else {
			this.error = 'All fields are mandatory';
		}
	}

}
