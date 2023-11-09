
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PostsComponent } from './posts/posts.component';
import { PostAddComponent } from './posts/post-add/post-add.component';
import { PostListComponent } from './posts/post-list/post-list.component';

import { HttpClientModule } from "@angular/common/http";
import { PostService } from './posts/post.service';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { HttpInterceptorService } from './httpInterceptor.service';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { PostMypostsComponent } from './posts/post-myposts/post-myposts.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTabsModule } from '@angular/material/tabs';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
	{ path: 'home', component: HomeComponent },
	{ path: 'login', component: LoginComponent },
	{ path: 'register', component: RegisterComponent },
	{ path: '', redirectTo: 'home', pathMatch: 'full' },
];

@NgModule({
	declarations: [
		AppComponent,
		PostsComponent,
		PostAddComponent,
		PostListComponent,
		LoginComponent,
		RegisterComponent,
		HomeComponent,
		PostMypostsComponent
	],
	imports: [
		BrowserModule,
		AppRoutingModule,
		FormsModule,
		HttpClientModule,
		BrowserAnimationsModule,
		MatTabsModule,
		MatIconModule,
		MatButtonModule,
		NgbModule,
		[RouterModule.forRoot(routes)]
	],
	providers: [{
		provide: HTTP_INTERCEPTORS,
		useClass: HttpInterceptorService,
		multi: true
	}, PostService],
	bootstrap: [AppComponent]
})

export class AppModule { }

